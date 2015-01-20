package com.epam.bb.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Order extends BaseEntity {
    private Souvenir souvenir;
    private List<Souvenir> boughtProducts;
    private Date dateTime;
    private boolean paid;
    private Category category;
    private BigDecimal totalPrice;
    private int quantity;

    public Order() {
    }

    public void add(Souvenir souvenir) {
        boughtProducts.add(souvenir);
    }

    public Souvenir getProduct() {
        return souvenir;
    }

    public void setProduct(Souvenir product) {
        this.souvenir = souvenir;
    }

    public List<Souvenir> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<Souvenir> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (paid != order.paid) return false;
        if (boughtProducts != null ? !boughtProducts.equals(order.boughtProducts) : order.boughtProducts != null)
            return false;
        if (category != null ? !category.equals(order.category) : order.category != null) return false;
        if (dateTime != null ? !dateTime.equals(order.dateTime) : order.dateTime != null) return false;
        if (souvenir != null ? !souvenir.equals(order.souvenir) : order.souvenir != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (souvenir != null ? souvenir.hashCode() : 0);
        result = 31 * result + (boughtProducts != null ? boughtProducts.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (paid ? 1 : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + souvenir +
                ", boughtProducts=" + boughtProducts +
                ", dateTime=" + dateTime +
                ", paid=" + paid +
                ", category=" + category +
                '}';
    }
}
