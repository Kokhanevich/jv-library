package kokhanevych.spring.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import kokhanevych.spring.security.annotations.PasswordMatches;
import kokhanevych.spring.security.annotations.ValidEmail;

@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String password;
    private String repeatPassword;
    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    public UserDto() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
