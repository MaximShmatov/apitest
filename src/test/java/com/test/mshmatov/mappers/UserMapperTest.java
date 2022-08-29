package com.test.mshmatov.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.test.mshmatov.BaseTest;
import com.test.mshmatov.database.entities.UserEntity;
import com.test.mshmatov.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class UserMapperTest extends BaseTest {
    private final UserMapper userMapper;

    @Test
    public void mapEntityToDto() {
        UserDto dto = userMapper.mapEntityToDto(USER_ENTITY);
        assertEquals(dto.getFirstName(), USER_ENTITY.getFirstName());
    }

    @Test
    public void mapDtoToEntity() {
        UserEntity entity = userMapper.mapDtoToEntity(USER_DTO);
        assertEquals(entity.getFirstName(), USER_DTO.getFirstName());
    }

}
