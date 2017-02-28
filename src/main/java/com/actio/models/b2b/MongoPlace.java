package com.actio.models.b2b;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.TextScore;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Builder(builderMethodName = "of", buildMethodName = "create")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "places")
public final class MongoPlace {

    @Id
    private String id;

    @NotNull
    @Indexed(name = "sql_entity_id", unique = true)
    private Long sqlEntityId;

    @NotNull
    @TextIndexed(weight = 3)
    @Field(value = "name")
    private String name;

    @NotNull
    @GeoSpatialIndexed(name = "location")
    private double[] location;

    @TextIndexed(weight = 3)
    @Field(value = "place_tags")
    private Set<String> tags;

    @TextScore
    private Float score;

}