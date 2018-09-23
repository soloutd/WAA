/*
 * Created on Nov 16, 2017
 */
package edu.mum.cs545.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 345561L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    @Column(name = "street")
    private String street;
    
    @NotBlank
    @Column(name = "city")
    private String city;
    
    @NotBlank
    @Column(name = "zipcode")
    private String zipcode;
    
    @NotBlank
    @Column(name = "state")
    private String state;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getZipcode() {
        return zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    

}
