package pl.pwsztar.mobilerestaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "klient", schema = "restauracja")
public class ClientDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_klienta")
    private int id;

    @OneToOne()
    @JoinColumn(name = "id_adresu", referencedColumnName = "id_adresu")
    private AddressDto address;

    @OneToOne()
    @JoinColumn(name = "id_credencials", referencedColumnName = "id_credencials")
    private CredencialsDto credencials;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String surname;

    @Column(name = "telefon_komorkowy")
    private String phoneNumber;

    @Column(name = "adres_email")
    private String email;

    public ClientDto() {
        super();
    }

    public ClientDto(int id, AddressDto address, CredencialsDto credencials, String name, String surname, String phoneNumber, String email) {
        this.id = id;
        this.address = address;
        this.credencials = credencials;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public CredencialsDto getCredencials() {
        return credencials;
    }

    public void setCredencials(CredencialsDto credencials) {
        this.credencials = credencials;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
          "id=" + id +
          ", address=" + address +
          ", credencials=" + credencials +
          ", name='" + name + '\'' +
          ", surname='" + surname + '\'' +
          ", phoneNumber='" + phoneNumber + '\'' +
          ", email='" + email + '\'' +
          '}';
    }
}
