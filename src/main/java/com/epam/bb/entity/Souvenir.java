package com.epam.bb.entity;

import java.sql.Date;

public class Souvenir extends BaseEntity {
    private String name;
    private Manufacturer manufacturer;
    private Model model;
    private String material;
    private boolean authenticity;
    private String color;
    private String country;
    private Date releaseDate;
    private Price price;

    public Souvenir() {
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isAuthenticity() {
        return authenticity;
    }

    public void setAuthenticity(boolean authenticity) {
        this.authenticity = authenticity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Souvenir souvenir = (Souvenir) o;

        if (authenticity != souvenir.authenticity) return false;
        if (color != null ? !color.equals(souvenir.color) : souvenir.color != null) return false;
        if (country != null ? !country.equals(souvenir.country) : souvenir.country != null) return false;
        if (manufacturer != null ? !manufacturer.equals(souvenir.manufacturer) : souvenir.manufacturer != null)
            return false;
        if (material != null ? !material.equals(souvenir.material) : souvenir.material != null) return false;
        if (model != null ? !model.equals(souvenir.model) : souvenir.model != null) return false;
        if (name != null ? !name.equals(souvenir.name) : souvenir.name != null) return false;
        if (price != null ? !price.equals(souvenir.price) : souvenir.price != null) return false;
        if (releaseDate != null ? !releaseDate.equals(souvenir.releaseDate) : souvenir.releaseDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (authenticity ? 1 : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", model=" + model +
                ", material='" + material + '\'' +
                ", authenticity=" + authenticity +
                ", color='" + color + '\'' +
                ", country='" + country + '\'' +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                '}';
    }
}
