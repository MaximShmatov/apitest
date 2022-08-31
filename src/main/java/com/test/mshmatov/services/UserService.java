package com.test.mshmatov.services;

import com.test.mshmatov.database.entities.UserEntity;
import com.test.mshmatov.database.repositories.UserRepository;
import com.test.mshmatov.dto.UserDto;
import com.test.mshmatov.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<UserDto> findById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::mapEntityToDto);
    }

    public List<UserDto> getAll() {
        return Optional.ofNullable(userRepository.getAllBy())
                .map(users -> users.stream().map(userMapper::mapEntityToDto).toList())
                .orElse(List.of());
    }

    @Transactional
    public boolean deleteById(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.removeById(id);
            return true;
        }
        return false;
    }

    public Optional<UserDto> update(UserDto user) {
        UserDto updatedUser = null;
        if (userRepository.existsById(user.getId())) {
            updatedUser = userMapper.mapEntityToDto(
                    userRepository.save(userMapper.mapDtoToEntity(user))
            );
        }
        return Optional.ofNullable(updatedUser);
    }

    public UserDto create(UserDto user) {
        UserEntity userEntity = userMapper.mapDtoToEntity(user);
        userEntity.setId(null);
        return userMapper.mapEntityToDto(userRepository.save(userEntity));
    }
}
