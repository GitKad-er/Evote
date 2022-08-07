package com.projet.evote.dtos;

import com.projet.evote.customannotation.PasswordMatches;
import com.projet.evote.customannotation.ValidEmail;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private List<String> str_role;

    // standard getters and setters

    public String getStr_role() {
        return str_role.get(0);
    }

    public void setStr_role(List<String> str_role) {
        this.str_role = str_role;
    }
}
