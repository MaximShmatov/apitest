package com.test.mshmatov.inttegration.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.mshmatov.BaseTest;
import com.test.mshmatov.inttegration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class RunRestControllerIT extends BaseTest {
    private final ObjectMapper objectMapper;
    private final MockMvc mockMvc;

//    @Test
//    void getUserRunsStat() throws Exception {
//        mockMvc.perform(get("/api/v1/runs/1/2022-06-01 00:00:00+03/2022-06-20 00:00:00+03"))
//                .andExpect(status().is2xxSuccessful());
//    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/api/v1/runs/1"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/v1/runs"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/api/v1/runs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RUN_DTO)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(put("/api/v1/runs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RUN_DTO)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/users/1"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void addRunStart() throws Exception {
        mockMvc.perform(post("/api/v1/runs/start")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RUN_START_DTO)))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void setRunFinish() throws Exception {
        mockMvc.perform(put("/api/v1/runs/finish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RUN_FINISH_DTO)))
                .andExpect(status().is2xxSuccessful());
    }

}
