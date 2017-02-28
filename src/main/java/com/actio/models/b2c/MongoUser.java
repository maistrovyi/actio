package com.actio.models.b2c;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
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
@Document(collection = "users")
public class MongoUser {

    @Id
    private String id;

    @NotNull
    @Indexed(name = "sql_entity_id", unique = true)
    private Long sqlEntityId;

    @NotNull
    @TextIndexed(weight = 3)
    @Field(value = "firstName")
    private String firstName;

    @NotNull
    @TextIndexed(weight = 3)
    @Field(value = "lastName")
    private String lastName;

    @NotNull
    @TextIndexed(weight = 3)
    @Field(value = "login")
    private String login;

    @NotNull
    @TextIndexed(weight = 3)
    @Field(value = "email")
    private String email;

    @TextIndexed(weight = 3)
    @Field(value = "user_tags")
    private Set<String> tags;

    @TextScore
    private Float score;

}