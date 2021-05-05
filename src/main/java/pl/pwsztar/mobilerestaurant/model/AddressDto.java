package pl.pwsztar.mobilerestaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "adres", schema = "restauracja")
public class AddressDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adresu")
    private int id;

    @Column(name = "ulica")
    private String street;

    @Column(name = "numer_mieszkania")
    private int homeNumber;

    @Column(name = "miasto")
    private String city;

    @Column(name = "kod_pocztowy")
    private String postNumber;

    public AddressDto() {
        super();
    }

    public AddressDto(int id, String street, int homeNumber, String city, String postNumber) {
        this.id = id;
        this.street = street;
        this.homeNumber = homeNumber;
        this.city = city;
        this.postNumber = postNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
          "id=" + id +
          ", street='" + street + '\'' +
          ", homeNumber=" + homeNumber +
          ", city='" + city + '\'' +
          ", postNumber='" + postNumber + '\'' +
          '}';
    }
}
