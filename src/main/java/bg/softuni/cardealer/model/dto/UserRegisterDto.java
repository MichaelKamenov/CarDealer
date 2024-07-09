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

    public UserRegisterDto() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
