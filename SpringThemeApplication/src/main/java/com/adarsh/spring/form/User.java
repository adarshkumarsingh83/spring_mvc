package com.adarsh.spring.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    @NotNull(message = "First Name Can't be Null")
    @NotEmpty(message = "First Name Can't be Empty")
    @Size(min = 3, max = 30, message = "First Name must be with in 3 to 30 Character")
    @Pattern(regexp = "^[A-Z|a-z]*([A-Z|a-z])*", message = "Invalid First Name")
    private String firstName;

    @NotNull(message = "Last Name Can't be Null")
    @NotEmpty(message = "Last Name Can't be Empty")
    @Size(min = 3, max = 30, message = "Last Name must be with in 3 to 30 Character")
    @Pattern(regexp = "^[A-Z|a-z]*([A-Z|a-z])*", message = "Invalid Middle Name")
    private String lastName;

    @NotNull(message = "Email Can't be Null")
    @Size(min = 8, max = 30, message = "Invalid Email character length")
    @Email(message = "Invalid Email")
    private String email;

    @NotNull(message = "User Phone Number Can't be Null")
    @Size(min = 10, max = 12, message = "User Phone must be with in 10 to 12 digit")
    @Pattern(regexp = "^([0-9])*", message = "Invalid User Phone Number")
    private String telephone;


    public User() {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
