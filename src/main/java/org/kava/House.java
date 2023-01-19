package org.kava;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class House {
    @Id
    private String address;

    private int area;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    public House() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", area=" + area +
                '}';
    }
}
