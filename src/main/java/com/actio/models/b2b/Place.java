package com.actio.models.b2b;

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
@Table(name = "PLACE")
public final class Place implements Serializable {

    private static final long serialVersionUID = -6796867355867404250L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLACE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGTITUDE")
    private Double longtitude;

    @Column(name = "ADDRESS")
    private String address;

    private Customer customer;

}
