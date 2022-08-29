package com.test.mshmatov.mappers;

import com.test.mshmatov.database.entities.RunEntity;
import com.test.mshmatov.dto.RunDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RunMapper implements Mapper<RunEntity, RunDto> {
    private final UserMapper userMapper;

    @Override
    public RunDto mapEntityToDto(RunEntity entity) {
        return new RunDto(
                entity.getId(),
                userMapper.mapEntityToDto(entity.getUserEntity()),
                entity.getStartLatitude(),
                entity.getStartLongitude(),
                entity.getStartDatetime().toString(),
                entity.getFinishLatitude(),
                entity.getFinishLongitude(),
                Optional.ofNullable(entity.getFinishDatetime())
                        .map(OffsetDateTime::toString)
                        .orElse(null),
                entity.getDistance()
        );
    }

    @Override
    public RunEntity mapDtoToEntity(RunDto dto) {
        return RunEntity.builder()
                .id(dto.getId())
                .userEntity(userMapper.mapDtoToEntity(dto.getUserDto()))
                .startLatitude(dto.getStartLatitude())
                .startLongitude(dto.getStartLongitude())
                .startDatetime(OffsetDateTime.parse(dto.getStartDatetime()))
                .finishLatitude(dto.getFinishLatitude())
                .finishLongitude(dto.getFinishLongitude())
                .finishDatetime(OffsetDateTime.parse(dto.getFinishDatetime()))
                .distance(dto.getDistance())
                .build();
    }

}
