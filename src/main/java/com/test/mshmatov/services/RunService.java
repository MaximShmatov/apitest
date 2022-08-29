package com.test.mshmatov.services;

import com.test.mshmatov.database.entities.RunEntity;
import com.test.mshmatov.database.repositories.RunRepository;
import com.test.mshmatov.dto.RunDto;
import com.test.mshmatov.mappers.RunMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RunService {
    private final RunRepository runRepository;
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
}
