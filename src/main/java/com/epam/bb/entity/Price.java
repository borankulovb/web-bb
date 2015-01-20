package com.epam.bb.entity;

import java.math.BigDecimal;
import java.util.Currency;

public class Price {
    private BigDecimal price;
    private Currency currency;

    public Price() {
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Price(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        if (!super.equals(o)) return false;

        Price price1 = (Price) o;

        if (price != null ? !price.equals(price1.price) : price1.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                ", currency=" + currency +
                '}';
    }
}