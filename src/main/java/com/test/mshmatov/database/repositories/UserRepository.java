package com.test.mshmatov.database.repositories;

import com.test.mshmatov.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findById(Integer id);

    List<UserEntity> getAllBy();

    void removeById(Integer id);

    boolean existsById(Integer id);

}
