package com.test.mshmatov.mappers;

import static org.junit.jupiter.api.Assertions.*;
import com.test.mshmatov.database.entities.GenderType;
import com.test.mshmatov.database.entities.UserEntity;
import com.test.mshmatov.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import java.time.LocalDate;

@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class UserMapperTest {
    private final UserMapper userMapper;
    private static UserEntity userEntity;
    private static UserDto userDto;


    @BeforeAll
    public static void initialize() {
        var date = LocalDate.now();
        userEntity = UserEntity.builder()
                .id(10)
                .firstName("first")
                .lastName("last")
                .birthDate(date)
                .gender(GenderType.M)
                .build();
        userDto = new UserDto(10,"first", "last", date.toString(), "M");
    }

    @Test
    public void mapEntityToDto() {
        UserDto dto = userMapper.mapEntityToDto(userEntity);
        assertEquals(dto.getFirstName(), userEntity.getFirstName());
    }

    @Test
    public void mapDtoToEntity() {
        UserEntity entity = userMapper.mapDtoToEntity(userDto);
        assertEquals(entity.getFirstName(), userDto.getFirstName());
    }

}
