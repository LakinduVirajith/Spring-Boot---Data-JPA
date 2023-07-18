package com.spring.boot.data.jpa.entity;

import jakarta.persistence.*;
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
        uniqueConstraints = {
                @UniqueConstraint(name = "studentId_unique", columnNames = "studentId"),
                @UniqueConstraint(name = "emailId_unique", columnNames = "emailId")
        }
)
public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private String emailId;

    private String guardianName;

    private String guardianEmail;

    private String guardianMobile;
}
