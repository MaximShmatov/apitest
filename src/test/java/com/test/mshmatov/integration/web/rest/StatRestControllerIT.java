package com.test.mshmatov.integration.web.rest;

import com.test.mshmatov.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class StatRestControllerIT {
    private static final String uri= "/api/v1/stat/%s?userId=3&fromDatetime=2022-06-01T00:00:00+03&toDatetime=2022-06-20T00:00:00+03";
    private final MockMvc mockMvc;

    @Test
    void getUserRunsStat() throws Exception {
        mockMvc.perform(get(String.format(uri, "runs")))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getUserStat() throws Exception {
        mockMvc.perform(get(String.format(uri, "user")))
                .andExpect(status().is2xxSuccessful());
    }
}
