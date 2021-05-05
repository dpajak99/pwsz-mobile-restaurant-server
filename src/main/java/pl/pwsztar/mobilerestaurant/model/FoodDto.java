package pl.pwsztar.mobilerestaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "danie", schema = "restauracja")
public class FoodDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dania")
    private int id;

    @OneToOne()
    @JoinColumn(name = "id_kategorii", referencedColumnName = "id_kategorii")
    private CategoryDto categoryDto;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "opis")
    private String description;

    @Column(name = "cena")
    private int prize;

    public FoodDto() {
        super();
    }

    public FoodDto(int id, CategoryDto categoryDto, String name, String description, int prize) {
        this.id = id;
        this.categoryDto = categoryDto;
        this.name = name;
        this.description = description;
        this.prize = prize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "FoodDto{" +
          "id=" + id +
          ", categoryDto=" + categoryDto +
          ", name='" + name + '\'' +
          ", description='" + description + '\'' +
          ", prize=" + prize +
          '}';
    }
}
