package com.test.mshmatov.web.rest;

import com.test.mshmatov.dto.AverageSpeedStatDto;
import com.test.mshmatov.dto.UserStatDto;
import com.test.mshmatov.services.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/stat")
public class StatRestController extends BaseController {
    private static final String REGEXP = "(\\d{4}-\\d{2}-\\d{2})[A-Z]+(\\d{2}:\\d{2}:\\d{2}).([0-9+-:]+)";
    private final StatService statService;

    @GetMapping("/runs")
    public List<AverageSpeedStatDto> getUserRunsStat(
            @RequestParam(name = "userId")
            @NotNull
            Integer userId,

            @RequestParam(name = "fromDatetime")
            @Pattern(regexp = REGEXP)
            String fromDatetime,

            @RequestParam(name = "toDatetime")
            @Pattern(regexp = REGEXP)
            String toDatetime) {
        return statService.getUserRunsStat(userId, fromDatetime, toDatetime);
    }

    @GetMapping("/user")
    public UserStatDto getUserStat(
            @RequestParam(name = "userId")
            @NotNull
            Integer userId,

            @RequestParam(name = "fromDatetime")
            @Pattern(regexp = REGEXP)
            String fromDatetime,

            @RequestParam(name = "toDatetime")
            @Pattern(regexp = REGEXP)
            String toDatetime) {
        return statService.getUserStat(userId, fromDatetime, toDatetime);
    }
}
