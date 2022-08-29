package com.test.mshmatov.database.repositories;

import com.test.mshmatov.database.entities.RunEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RunRepository extends JpaRepository<RunEntity, Integer> {

    Optional<RunEntity> findById(Integer id);

    List<RunEntity> getAllBy();

    void removeById(Integer id);

    boolean existsById(Integer id);
}
