package pl.pwsztar.mobilerestaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "credencials", schema = "restauracja")
public class CredencialsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencials")
    private int id;

    @Column(name = "token")
    private int token;

    @Column(name = "password")
    private String password;

    public CredencialsDto() {
        super();
    }

    public CredencialsDto(int id, int token, String password) {
        this.id = id;
        this.token = token;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CredencialsDto{" +
          "id=" + id +
          ", token=" + token +
          ", password='" + password + '\'' +
          '}';
    }
}
