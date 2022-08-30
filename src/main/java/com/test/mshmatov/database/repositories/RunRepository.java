package com.test.mshmatov.database.repositories;

import com.test.mshmatov.database.entities.RunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface RunRepository extends JpaRepository<RunEntity, Integer> {

    Optional<RunEntity> findById(Integer id);

    List<RunEntity> getAllBy();

    void removeById(Integer id);

    boolean existsById(Integer id);

    Optional<RunEntity> findByIdAndUserEntityId(Integer runId, Integer userId);

    @Query("select r from RunEntity r " +
            "where r.userEntity.id = :userId " +
            "and r.startDatetime >= :fromDatetime " +
            "and r.finishDatetime <= :toDatetime")
    List<RunEntity> findAllByUserAndStartDateRange(Integer userId, OffsetDateTime fromDatetime, OffsetDateTime toDatetime);

}
