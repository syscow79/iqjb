/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import javax.persistence.Embeddable;

/**
 *
 * @author oracle
 */
@Embeddable
public class Address {
    private String zip;
    private String city;
    private String street;

    public Address() {
    }

    public Address(String zip, String city, String street) {
        this.zip = zip;
        this.city = city;
        this.street = street;
    }

    
    
    
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
    
    
}
