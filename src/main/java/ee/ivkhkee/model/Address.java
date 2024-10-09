package ee.ivkhkee.model;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private String House;
    private String room;

    public Address() {
    }

    public Address(String city, String street, String house, String room) {
        this.city = city;
        this.street = street;
        House = house;
        this.room = room;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return House;
    }

    public void setHouse(String house) {
        House = house;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(House, address.House) && Objects.equals(room, address.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, House, room);
    }
}
