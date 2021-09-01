package com.fresure.payload.request;

import com.fresure.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.validation.constraints.*;

@Getter
@Setter
public class SignupRequest extends User {
    @NotNull
    @Size(min = 3, max = 20)
    private String username;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Size(min = 6, max = 40)
    private String password;

    private Set<String> roles;

}
