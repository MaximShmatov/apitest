package com.test.mshmatov.services;

import com.test.mshmatov.database.entities.UserEntity;
import com.test.mshmatov.database.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<UserEntity> findById(Integer id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> getAll() {
        return userRepository.getAllBy();
    }

    public int deleteById(Integer id) {
        return userRepository.removeById(id);
    }

    public UserEntity update(UserEntity user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }

    public UserEntity create(UserEntity user) {
        user.setId(null);
        return userRepository.save(user);
    }
}
