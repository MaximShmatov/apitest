package com.test.mshmatov.mappers;

import com.test.mshmatov.database.entities.GenderType;
import com.test.mshmatov.database.entities.UserEntity;
import com.test.mshmatov.dto.UserDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper implements Mapper<UserEntity, UserDto> {

    @Override
    public UserDto mapEntityToDto(UserEntity entity) {
        return new UserDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                String.valueOf(entity.getBirthDate()),
                String.valueOf(entity.getGender())
        );
    }

    @Override
    public UserEntity mapDtoToEntity(UserDto dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthDate(LocalDate.parse(dto.getBirthDate()))
                .gender(GenderType.of(dto.getGender()))
                .build();
    }

}
