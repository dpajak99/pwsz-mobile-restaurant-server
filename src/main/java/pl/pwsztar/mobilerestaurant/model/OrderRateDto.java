package pl.pwsztar.mobilerestaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "ocena_zamowienia", schema = "restauracja")
public class OrderRateDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oceny_zamowienia")
    private int id;

    @Column(name = "skala")
    private int points;

    @Column(name = "uwagi")
    private String comments;

    public OrderRateDto() {
        super();
    }

    public OrderRateDto(int id, int points, String comments) {
        this.id = id;
        this.points = points;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "OcenaZamowieniaIdentity{" +
          "id=" + id +
          ", points=" + points +
          ", comments='" + comments + '\'' +
          '}';
    }
}
