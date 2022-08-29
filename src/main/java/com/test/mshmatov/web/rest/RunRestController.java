package com.test.mshmatov.web.rest;

import com.test.mshmatov.dto.RunDto;
import com.test.mshmatov.services.RunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/runs")
public class RunRestController {
    private final RunService runService;

    @GetMapping("/{id}")
    public RunDto findById(@PathVariable Integer id) {
        return runService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
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
}
