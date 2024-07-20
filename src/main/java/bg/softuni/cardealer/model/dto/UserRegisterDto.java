package bg.softuni.cardealer.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDto {


    @NotNull
    @Size(min = 2, max = 40)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 40)
    private String lastName;
    @NotNull
    @Size(min = 2, max = 30)
    private String email;
    @NotNull
    @Size(min = 2, max = 40)
    private String password;

   public UserRegisterDto() {}

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
