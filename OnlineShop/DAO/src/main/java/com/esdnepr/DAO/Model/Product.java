package com.esdnepr.DAO.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "CATEGORY", nullable = false)
    private String category;
    @Column(name = "PARAMETER", nullable = false)
    private String parameter;
    @Column(name = "COUNT", nullable = false)
    private int count;
    @Column(name = "PRICE", nullable = false)
    private Double price;
    @JsonIgnore
    @ManyToMany
    private Set<Order> orders = new HashSet<>();

    public Product() {
    }
    public Product(Long id, String name, String category, String parameter, int count, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.parameter = parameter;
        this.count = count;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", parameter='" + parameter + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getParameter() {
        return parameter;
    }
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, parameter, price);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(name, product.name)&&
                Objects.equals(category, product.category)&&
                Objects.equals(parameter, product.parameter)&&
                Objects.equals(price, product.price);
    }
}
