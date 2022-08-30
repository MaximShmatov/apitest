package com.test.mshmatov.web.rest;

import com.test.mshmatov.dto.AverageSpeedStatDto;
import com.test.mshmatov.dto.RunDto;
import com.test.mshmatov.dto.RunFinishDto;
import com.test.mshmatov.dto.RunStartDto;
import com.test.mshmatov.services.RunService;
import com.test.mshmatov.services.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/runs")
public class RunRestController {
    private final RunService runService;
    private final StatService statService;

    @GetMapping("/{id}")
    public RunDto findById(@PathVariable Integer id) {
        return runService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @GetMapping("/stat/{userId}/{fromDatetime}/{toDatetime}")
    public List<AverageSpeedStatDto> getUserRunsStat(
            @PathVariable Integer userId,
            @PathVariable OffsetDateTime fromDatetime,
            @PathVariable OffsetDateTime toDatetime) {
        return statService.getUserRunsStat(userId, fromDatetime, toDatetime);
    }

    @GetMapping
    public List<RunDto> getAll() {
        return runService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RunDto create(@RequestBody RunDto run) {
        return runService.create(run);
    }

    @PutMapping
    public RunDto update(@RequestBody RunDto run) {
        return runService.update(run)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        if (!runService.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/start")
    @ResponseStatus(HttpStatus.CREATED)
    public RunDto addRunStart(@RequestBody RunStartDto runStart) {
        return runService.addRunStart(runStart)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/finish")
    public RunDto setRunFinish(@RequestBody RunFinishDto runFinish) {
        return runService.setRunFinish(runFinish)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
