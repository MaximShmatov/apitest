package com.test.mshmatov.web.rest;

import com.test.mshmatov.dto.RunDto;
import com.test.mshmatov.dto.RunFinishDto;
import com.test.mshmatov.dto.RunStartDto;
import com.test.mshmatov.services.RunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/runs")
public class RunRestController extends BaseController {
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
    public RunDto create(@RequestBody @Validated RunDto run) {
        return runService.create(run);
    }

    @PutMapping
    public RunDto update(@RequestBody @Validated RunDto run) {
        return runService.update(run)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Integer id) {
        if (!runService.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/start")
    @ResponseStatus(HttpStatus.CREATED)
    public RunDto addRunStart(@RequestBody @Validated RunStartDto runStart) {
        return runService.addRunStart(runStart)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/finish")
    public RunDto setRunFinish(@RequestBody @Validated RunFinishDto runFinish) {
        return runService.setRunFinish(runFinish)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
