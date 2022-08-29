package com.test.mshmatov.inttegration.web.rest;

import com.test.mshmatov.inttegration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserRestControllerIT {
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
                        .content("{\"firstName\":\"Userfirstname\"," +
                                "\"lastName\":\"Userlastname\"," +
                                "\"birthDate\":\"05.25.1991\"," +
                                "\"gender\":\"W\"}"))
//                        .param("id", "")
//                        .param("firstName", "Userfirstname")
//                        .param("lastName", "Userlastname")
//                        .param("birthDate", "05.25.1991")
//                        .param("gender", "W"))
                .andExpect(status().is2xxSuccessful());
    }
//
//    @Test
//    void delete() throws Exception {
//        mockMvc.perform(delete("/api/v1/users"))
//                .andExpect(status().is2xxSuccessful());
//    }
}
