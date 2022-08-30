package com.test.mshmatov.services;

import com.test.mshmatov.database.entities.RunEntity;
import com.test.mshmatov.database.repositories.RunRepository;
import com.test.mshmatov.dto.AverageSpeedStatDto;
import com.test.mshmatov.dto.UserStatDto;
import com.test.mshmatov.mappers.RunMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatService {
    private final RunRepository runRepository;
    private final RunMapper runMapper;

    public List<AverageSpeedStatDto> getUserRunsStat(Integer userId, String fromDatetime, String toDatetime) {
        OffsetDateTime fromDate = OffsetDateTime.parse(fromDatetime);
        OffsetDateTime toDate = OffsetDateTime.parse(toDatetime);
        List<RunEntity> runs = runRepository.findAllByUserAndStartDateRange(userId, fromDate, toDate);
        return Optional.ofNullable(runs)
                .map(runList -> runList.stream()
                        .map(run -> new AverageSpeedStatDto(runMapper.mapEntityToDto(run), calculateAverageSpeed(run)))
                        .toList()
                )
                .orElse(List.of());
    }

    public UserStatDto getUserStat(Integer userId, String fromDatetime, String toDatetime) {
        OffsetDateTime fromDate = OffsetDateTime.parse(fromDatetime);
        OffsetDateTime toDate = OffsetDateTime.parse(toDatetime);
        List<RunEntity> runs = runRepository.findAllByUserAndStartDateRange(userId, fromDate, toDate);
        return Optional.ofNullable(runs)
                .map(this::calculateUserStat)
                .orElse(new UserStatDto());
    }

    private Long calculateAverageSpeed(RunEntity run) {
        long runTime = Duration.between(run.getStartDatetime(), run.getFinishDatetime()).toHours();
        return runTime == 0 ? 0 : run.getDistance() / runTime;
    }

    private UserStatDto calculateUserStat(List<RunEntity> runs) {
        int runsQuantity = runs.size();
        AtomicReference<Long> totalDistance = new AtomicReference<>(0L);
        AtomicReference<Long> totalSpeed = new AtomicReference<>(0L);
        runs.forEach(run -> {
            totalDistance.set(totalDistance.get() + run.getDistance());
            totalSpeed.set(totalSpeed.get() + calculateAverageSpeed(run));
        });
        Long averageSpeed = runsQuantity == 0 ? 0 : totalSpeed.get() / runsQuantity;
        return new UserStatDto(runsQuantity, totalDistance.get(), averageSpeed);
    }

}
