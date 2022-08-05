package org.academiadecodigo.firstapp.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.academiadecodigo.firstapp.persistence.model.Account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The {@link Account} data transfer object
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountDto {

    //public static final String moneyRegex = "^\\$?0*[1-9]\\d*(\\.\\d{0,2})?|\\d*(\\.0[1-9])|\\d*(\\.[1-9]\\d?)?$?";

    private Integer id;

    //@Pattern(regexp = moneyRegex, message = "Amount is not valid")
    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String name;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 64)
    private String title;

    @NotNull(message = "Suggestion is mandatory")
    @NotBlank(message = "Suggestion is mandatory")
    @Size(min = 3, max = 64)
    private String suggestion;

    @NotNull(message = "Picture url is mandatory")
    @NotBlank(message = "Picture url is mandatory")
    @Size(min = 3, max = 64)
    private String picUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the id of the account DTO
     *
     * @return the account DTO id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the account DTO
     *
     * @param id the account DTO id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the account DTO balance
     *
     * @return the account DTO balance
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the account DTO balance
     *
     * @param name the account DTO balance to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", name=" + name +
                ", title=" + title +
                ", suggestion=" + suggestion +
                ", picUrl=" + picUrl +
                '}';
    }


}
