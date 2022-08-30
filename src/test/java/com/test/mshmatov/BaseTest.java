package com.test.mshmatov;

import com.test.mshmatov.database.entities.GenderType;
import com.test.mshmatov.database.entities.RunEntity;
import com.test.mshmatov.database.entities.UserEntity;
import com.test.mshmatov.dto.RunDto;
import com.test.mshmatov.dto.RunFinishDto;
import com.test.mshmatov.dto.RunStartDto;
import com.test.mshmatov.dto.UserDto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class BaseTest {

    protected static final UserEntity USER_ENTITY = UserEntity.builder()
            .id(1)
            .firstName("first")
            .lastName("last")
            .birthDate(LocalDate.now())
            .gender(GenderType.M)
            .build();

    protected static final UserDto USER_DTO = UserDto.builder()
            .id(1)
            .firstName("first")
            .lastName("last")
            .birthDate(LocalDate.now().toString())
            .gender("M")
            .build();

    protected static final RunEntity RUN_ENTITY = RunEntity.builder()
            .id(3)
            .userEntity(USER_ENTITY)
            .startLatitude(77.1539f)
            .startLongitude(-139.398f)
            .startDatetime(OffsetDateTime.now())
            .finishLatitude(-77.1804f)
            .finishLongitude(-139.55f)
            .finishDatetime(OffsetDateTime.now().plusHours(1))
            .distance(1000)
            .build();

    protected static final RunDto RUN_DTO = RunDto.builder()
            .id(3)
            .userDto(USER_DTO)
            .startLatitude(77.1539f)
            .startLongitude(-139.398f)
            .startDatetime(OffsetDateTime.now().toString())
            .finishLatitude(-77.1804f)
            .finishLongitude(-139.55f)
            .finishDatetime(OffsetDateTime.now().plusDays(1).toString())
            .distance(1000)
            .build();

    protected static final RunStartDto RUN_START_DTO = RunStartDto.builder()
            .userId(1)
            .startLatitude(77.1539f)
            .startLongitude(-139.398f)
            .startDatetime(OffsetDateTime.now().toString())
            .build();

    protected static final RunFinishDto RUN_FINISH_DTO = RunFinishDto.builder()
            .userId(1)
            .runId(3)
            .finishLatitude(-77.1804f)
            .finishLongitude(-139.55f)
            .finishDatetime(OffsetDateTime.now().plusDays(1).toString())
            .distance(null)
            .build();

}
