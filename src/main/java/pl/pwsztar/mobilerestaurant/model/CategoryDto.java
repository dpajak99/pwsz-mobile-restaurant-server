package pl.pwsztar.mobilerestaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "kategoria", schema = "restauracja")
public class CategoryDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kategorii")
    private int id;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "opis")
    private String desc;

    public CategoryDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", desc='" + desc + '\'' +
          '}';
    }
}