package com.company.beans;

import java.util.Objects;

public class Item {

    private int value;
    private int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getValue() == item.getValue() &&
                getWeight() == item.getWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getWeight());
    }
}
