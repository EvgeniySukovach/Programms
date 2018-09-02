package com.esdnepr.services.DTO;


import com.esdnepr.DAO.Model.Product;
import com.esdnepr.DAO.Model.User;

import java.util.Date;
import java.util.Set;

public class OrderDTO {
    private User user;
    private Set<Product> products;
    private String status;
    private Date date;

    public OrderDTO() {
    }

    public OrderDTO(User user, Set<Product> products, String status, Date date) {
        this.user = user;
        this.products = products;
        this.status = status;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
