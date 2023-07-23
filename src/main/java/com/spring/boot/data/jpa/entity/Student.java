package com.spring.boot.data.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "student_table",
        uniqueConstraints = @UniqueConstraint(name = "emailId_unique", columnNames = "email_id")
)
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}
