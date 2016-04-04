package com.oatkachenko.model.dto;

import com.oatkachenko.model.entity.User;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

/**
 * Created by Home on 25.03.2016.
 */
public class TaskDto {

    @NotEmpty(message = "*обязательное поле")
    private String title;

    @NotEmpty(message = "*обязательное поле")
    private String description;

    @NumberFormat
    private Long categoryId;

    private User customer;

    @NotNull(message = "*обязательное поле")
    private Double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
