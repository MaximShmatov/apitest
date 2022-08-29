package com.test.mshmatov.mappers;

import com.test.mshmatov.BaseTest;
import com.test.mshmatov.database.entities.RunEntity;
import com.test.mshmatov.dto.RunDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class RunMapperTest extends BaseTest {
    private final RunMapper runMapper;

    @Test
    public void mapEntityToDto() {
        RunDto dto = runMapper.mapEntityToDto(RUN_ENTITY);
        assertEquals(dto.getDistance(), RUN_DTO.getDistance());
    }

    @Test
    public void mapDtoToEntity() {
        RunEntity entity = runMapper.mapDtoToEntity(RUN_DTO);
        assertEquals(entity.getUserEntity().getLastName(), RUN_ENTITY.getUserEntity().getLastName());
    }

}
