package org.kizilay.yusuf.caveatemptor.resource;

import org.kizilay.yusuf.caveatemptor.domain.Address;

public class AddressResource extends BaseResource<Address> {

    private String street;

    private String zipCode;

    private String city;

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

    @Override
    public Address toDomain() {
        return new Address(this.street, this.zipCode, this.city);
    }
}
