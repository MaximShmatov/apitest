package com.test.mshmatov.database.repositories;

import com.test.mshmatov.database.entities.RunsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RunsRepository  extends JpaRepository<RunsEntity, Integer> {

    Optional<RunsEntity> findById(Integer id);

    List<RunsEntity> getAllBy();

    void removeById(Integer id);

    boolean existsById(Integer id);
}
