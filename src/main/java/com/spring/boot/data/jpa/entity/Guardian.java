package com.spring.boot.data.jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "guardianName")),
        @AttributeOverride(name = "email", column = @Column(name = "guardianEmail")),
        @AttributeOverride(name = "mobile", column = @Column(name = "guardianMobile"))
})
public class Guardian {

    private String name;

    private String email;

    private String mobile;
}
