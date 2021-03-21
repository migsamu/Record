package org.iesfm.record;

import java.util.List;
import java.util.Objects;

public class Member {

    private String name;
    private String surname;
    private String nif;
    private int zipCode;
    private List<Order> orders;

    public Member(String name, String surname, String nif, int zipCode, List<Order> orders) {
        this.name = name;
        this.surname = surname;
        this.nif = nif;
        this.zipCode = zipCode;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return zipCode == member.zipCode && Objects.equals(name, member.name) && Objects.equals(surname, member.surname) && Objects.equals(nif, member.nif) && Objects.equals(orders, member.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, nif, zipCode, orders);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nif='" + nif + '\'' +
                ", zipCode=" + zipCode +
                ", orders=" + orders +
                '}';
    }

}
