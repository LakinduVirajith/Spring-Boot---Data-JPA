package com.spring.boot.data.jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
        @AttributeOverride(name = "guardianName", column = @Column(name = "name")),
        @AttributeOverride(name = "guardianEmail", column = @Column(name = "email")),
        @AttributeOverride(name = "guardianMobile", column = @Column(name = "mobile"))
})
public class Guardian {

    private String name;

    private String email;

    private String mobile;
}
