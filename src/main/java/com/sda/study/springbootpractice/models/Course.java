package com.sda.study.springbootpractice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Course model
 *
 * @author Vinod John
 * @Date 22.02.2023
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Course extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    private int durationInDays;

    @OneToOne(cascade = CascadeType.MERGE)
    private School school;

    private boolean isActive;
}
