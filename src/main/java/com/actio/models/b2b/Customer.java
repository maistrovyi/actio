package com.actio.models.b2b;

import com.actio.models.common.AbstractUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder(builderMethodName = "of", buildMethodName = "create")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "CUSTOMER")
public final class Customer extends AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long id;

}
