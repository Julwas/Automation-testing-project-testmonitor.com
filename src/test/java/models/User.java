package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    @SerializedName(value = "admin")
    @JsonProperty("admin")
    @EqualsAndHashCode.Exclude
    private boolean admin;

    @SerializedName(value = "id")
    @JsonProperty("id")
    private int userId;

}
