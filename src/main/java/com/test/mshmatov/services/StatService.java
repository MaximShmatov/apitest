package com.test.mshmatov.services;

import com.test.mshmatov.database.entities.RunEntity;
import com.test.mshmatov.database.repositories.RunRepository;
import com.test.mshmatov.dto.AverageSpeedStatDto;
import com.test.mshmatov.mappers.RunMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatService {
    private final RunRepository runRepository;
    private final RunMapper runMapper;

    public List<AverageSpeedStatDto> getUserRunsStat(Integer userId, OffsetDateTime fromDateTime, OffsetDateTime toDatetime) {
        List<RunEntity> runs = runRepository.findAllByUserAndStartDateRange(
                userId,
                fromDateTime,
                toDatetime);
        return Optional.ofNullable(runs)
                .map(runList -> runList.stream()
                        .map(run -> new AverageSpeedStatDto(runMapper.mapEntityToDto(run), calculateAverageSpeed(run)))
                        .toList()
                )
                .orElse(List.of());
    }

    private Float calculateAverageSpeed(RunEntity run) {
        OffsetDateTime runTime = run.getFinishDatetime().minusMinutes(run.getStartDatetime().getMinute());
        return (float) (run.getDistance() / runTime.getHour());
    }

}
