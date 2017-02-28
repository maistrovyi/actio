package com.actio.models.b2b;

import com.actio.models.common.AbstractUser;
import com.actio.models.common.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "customer")
public final class Customer extends AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Builder(builderMethodName = "of", buildMethodName = "create")
    public Customer(String firstName, String lastName, String login, String password, String email, Role role) {
        super(firstName, lastName, login, password, email, role);
    }

}