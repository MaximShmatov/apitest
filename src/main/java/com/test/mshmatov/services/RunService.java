package com.test.mshmatov.services;

import com.test.mshmatov.database.entities.RunEntity;
import com.test.mshmatov.database.repositories.RunRepository;
import com.test.mshmatov.database.repositories.UserRepository;
import com.test.mshmatov.dto.RunDto;
import com.test.mshmatov.dto.RunFinishDto;
import com.test.mshmatov.dto.RunStartDto;
import com.test.mshmatov.mappers.RunMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RunService {
    private final RunRepository runRepository;
    private final UserRepository userRepository;
    private final RunMapper runMapper;

    public Optional<RunDto> findById(Integer id) {
        return runRepository.findById(id)
                .map(runMapper::mapEntityToDto);
    }

    public List<RunDto> getAll() {
        return Optional.ofNullable(runRepository.getAllBy())
                .map(run -> run.stream().map(runMapper::mapEntityToDto).toList())
                .orElse(List.of());
    }

    public boolean deleteById(Integer id) {
        if (runRepository.existsById(id)) {
            runRepository.removeById(id);
            return true;
        }
        return false;
    }

    public Optional<RunDto> update(RunDto run) {
        RunDto updatedRun = null;
        if (runRepository.existsById(run.getId())) {
            updatedRun = runMapper.mapEntityToDto(
                    runRepository.save(runMapper.mapDtoToEntity(run))
            );
        }
        return Optional.ofNullable(updatedRun);
    }

    public RunDto create(RunDto run) {
        RunEntity runEntity = runMapper.mapDtoToEntity(run);
        runEntity.setId(null);
        return runMapper.mapEntityToDto(runRepository.save(runEntity));
    }

    public Optional<RunDto> addRunStart(RunStartDto run) {
        RunDto runStart = userRepository.findById(run.getUserId())
                .map(userEntity -> {
                    var runEntity = RunEntity.builder()
                            .userEntity(userEntity)
                            .startLatitude(run.getStartLatitude())
                            .startLongitude(run.getStartLongitude())
                            .startDatetime(OffsetDateTime.parse(run.getStartDatetime()))
                            .build();
                    return runMapper.mapEntityToDto(runRepository.save(runEntity));
                })
                .orElse(null);
        return Optional.ofNullable(runStart);
    }

    public Optional<RunDto> setRunFinish(RunFinishDto run) {
        RunDto runDto = runRepository.findByIdAndUserEntityId(run.getRunId(), run.getUserId())
                .map(runEntity -> {
                    runEntity.setFinishLatitude(run.getFinishLatitude());
                    runEntity.setFinishLongitude(run.getFinishLongitude());
                    runEntity.setFinishDatetime(OffsetDateTime.parse(run.getFinishDatetime()));
                    return runMapper.mapEntityToDto(runRepository.save(runEntity));
                })
                .orElse(null);
        return Optional.ofNullable(runDto);
    }


}
