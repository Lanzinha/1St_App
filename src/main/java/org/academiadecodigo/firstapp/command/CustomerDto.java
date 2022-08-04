package org.academiadecodigo.firstapp.command;

import org.academiadecodigo.firstapp.persistence.model.Customer;

import javax.validation.constraints.*;

/**
 * The {@link Customer} data transfer object
 */
public class CustomerDto {

    private Integer id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String name;


/*    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number contains invalid characters")
    @Size(min = 9, max = 16)
    private String phone;*/

    /**
     * Gets the id of the customer DTO
     *
     * @return the customer DTO id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the customer DTO
     *
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the first name of the customer DTO
     *
     * @return the customer DTO first name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the first name of the customer DTO
     *
     * @param name the first name to set
     */
    public void setName(String name) {
        this.name = name;
    }

/*    *//**
     * Gets the email of the customer DTO
     *
     * @return the customer DTO email
     *//*
    public String getEmail() {
        return email;
    }

    *//**
     * Sets the email of the customer DTO
     *
     * @param email the email to set
     *//*
    public void setEmail(String email) {
        this.email = email;
    }

    *//**
     * Gets the phone of the customer DTO
     *
     * @return the customer DTO phone
     *//*
    public String getPhone() {
        return phone;
    }

    *//**
     * Sets the phone of the customer DTP
     *
     * @param phone the phone to set
     *//*
    public void setPhone(String phone) {
        this.phone = phone;
    }*/

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "CustomerForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
