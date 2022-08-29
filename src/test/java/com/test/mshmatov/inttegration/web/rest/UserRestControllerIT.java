package com.test.mshmatov.inttegration.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.mshmatov.dto.UserDto;
import com.test.mshmatov.inttegration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserRestControllerIT {
    private static final UserDto USER_DTO = UserDto.builder()
            .id(1)
            .firstName("first")
            .lastName("last")
            .birthDate(LocalDate.now().toString())
            .gender("M")
            .build();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final MockMvc mockMvc;

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(USER_DTO)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(put("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(USER_DTO)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/users/1"))
                .andExpect(status().is2xxSuccessful());
    }
}
