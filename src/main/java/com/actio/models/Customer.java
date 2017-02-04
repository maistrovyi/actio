package com.actio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder(builderMethodName = "of", buildMethodName = "create")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = -4733624093341899333L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLACE_ID")
    private Long id;

}
