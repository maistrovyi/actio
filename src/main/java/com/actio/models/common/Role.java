package com.actio.models.common;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder(builderMethodName = "of", buildMethodName = "create")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ROLE")
public final class Role implements Serializable {

    private static final long serialVersionUID = -7383317484452637847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", updatable = false)
    private Long id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", columnDefinition = "VARCHAR(255)", nullable = false)
    private RoleType type;

    @Getter
    public enum RoleType {

        ROLE_ADMIN("ADMIN"),
        ROLE_CONSUMER("CONSUMER"),
        ROLE_USER("USER");

        private String name;

        RoleType(String name) {
            this.name = name;
        }

    }

}
