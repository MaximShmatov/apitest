package com.test.mshmatov.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "runs")
public class RunsEntity implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userId;

    @Column(name = "start_latitude", nullable = false)
    private Float startLatitude;

    @Column(name = "start_longitude", nullable = false)
    private Float startLongitude;

    @Column(name = "start_datetime", nullable = false)
    private OffsetDateTime startDatetime;

    @Column(name = "finish_latitude")
    private Float finishLatitude;

    @Column(name = "finish_longitude")
    private Float finishLongitude;

    @Column(name = "finish_datetime")
    private OffsetDateTime finishDatetime;

    @Column(name = "distance")
    private Integer distance;
}
