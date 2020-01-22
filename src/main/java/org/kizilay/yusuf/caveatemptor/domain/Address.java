package org.kizilay.yusuf.caveatemptor.domain;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;


@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
    private long addressId;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "CITY")
    private String city;

    public Address() {
    }

    public Address(String street, String zipCode, String city) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
