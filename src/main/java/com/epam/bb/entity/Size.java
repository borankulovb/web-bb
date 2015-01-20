package com.epam.bb.entity;

public class Size {
    private int weight;
    private int length;
    private int height;

    public Size() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (height != size.height) return false;
        if (length != size.length) return false;
        if (weight != size.weight) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weight;
        result = 31 * result + length;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "Size{" +
                "weight=" + weight +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
