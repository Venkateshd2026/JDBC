package com.venki.UsingForiegnKey;

import java.util.Objects;

public class address {

    int id;
    int houseno;
    String streetname;
    String city;
    String state;
    String country;
    int pincode;

    public address() {
        super();
    }

    public address(int id, int houseno, String streetname, String city,
                   String state, String country, int pincode) {

        super();

        this.id = id;
        this.houseno = houseno;
        this.streetname = streetname;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHouseno() {
        return houseno;
    }

    public void setHouseno(int houseno) {
        this.houseno = houseno;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                city,
                country,
                houseno,
                id,
                pincode,
                state,
                streetname
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        address other = (address) obj;

        return Objects.equals(city, other.city)
                && Objects.equals(country, other.country)
                && houseno == other.houseno
                && id == other.id
                && pincode == other.pincode
                && Objects.equals(state, other.state)
                && Objects.equals(streetname, other.streetname);
    }

    @Override
    public String toString() {

        return "address [id=" + id
                + ", houseno=" + houseno
                + ", streetname=" + streetname
                + ", city=" + city
                + ", state=" + state
                + ", country=" + country
                + ", pincode=" + pincode + "]";
    }
}
