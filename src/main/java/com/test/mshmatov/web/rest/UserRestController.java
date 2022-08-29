package com.test.mshmatov.web.rest;

import com.test.mshmatov.database.entities.UserEntity;
import com.test.mshmatov.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/users")
public class UserRestController extends BaseController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable Integer id) {
        return userService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create(@RequestBody UserEntity user) {
        return userService.create(user);
    }
//
//    @PutMapping
//    public User update(@RequestBody User user) {
//        return userService.update(User user)
//          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Integer id) {
//        if (!userService.delete(id)) {
//          throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        };
//    }
//
//    private final ParentEntityService parentEntityService;
//    private final SecurityService securityService;
//    private final UserService userService;
//
//    public ParentEntityController(ParentEntityService parentEntityService,
//                                  SecurityService securityService,
//                                  UserService userService) {
//        this.parentEntityService = parentEntityService;
//        this.securityService = securityService;
//        this.userService = userService;
//    }
//
//    @GetMapping(value = "parents")
//    public Page<ParentDto> getAllParents() {
//        return DtoMapper.INSTANCE.toDto(parentEntityService.getAllByProjectMagic());
//    }
//
//    @GetMapping(value = "projects/{projectId}/parents")
//    public Page<? extends ParentDto> getAllParents(@PathVariable(value = "projectId") long projectId) {
//        Page<ParentEntity> entities = parentEntityService.getAllByProjectMagic(projectId);
//        if (securityService.hasPermission(projectId, ParentEntity.PROJECT_OBJECT, Action.update)) {
//            return DtoMapper.INSTANCE.toDtoWithSum(entities);
//        } else {
//            return DtoMapper.INSTANCE.toDto(entities);
//        }
//    }
//
//    @PostMapping(value = "projects/{projectId}/parents")
//    public ParentDto addParent(@PathVariable(value = "projectId") long projectId, @RequestBody ParentEntity parentEntity) {
//        parentEntity.setProjectId(projectId);
//        return DtoMapper.INSTANCE.toDto(parentEntityService.create(parentEntity));
//    }
//
//    @PostMapping(value = "projects/{projectId}/parents/{id}/activate")
//    @PreAuthorize("hasPermission(#projectId,'Project','update')")
//    public ParentDto setActive(@PathVariable(value = "projectId") long projectId, @RequestBody ParentEntity parentEntity) {
//        parentEntity.setProjectId(projectId);
//        return DtoMapper.INSTANCE.toDto(parentEntityService.create(parentEntity));
//    }

}
