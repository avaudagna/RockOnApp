package com.alan.rockonapp.adapter.model;

/**
 * Created by alan on 21/09/15.
 */
public class Venue {
    /*
    "venue":{
         "id":101004,
         "name":"Teatro Gran Rex",
         "location":{
            "city":"Buenos Aires",
            "country":"Argentina",
            "street":"Avenida Corrientes 857",
            "latitude":"-34.6035",
            "longitude":"-58.3789"
         }
     */
    private String name;
    //inside location
    private String city;
    private String country;
    private String street;
    private String latitude;
    private String longitude;

    public Venue setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }


    public Venue setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCity() {
        return city;
    }


    public Venue setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountry() {
        return country;
    }


    public Venue setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getStreet() {
        return street;
    }


    public Venue setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }


    public Venue setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }
}
