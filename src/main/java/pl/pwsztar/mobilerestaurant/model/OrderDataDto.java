package pl.pwsztar.mobilerestaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "dane_zamowienia", schema = "restauracja")
public class OrderDataDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zamowienia")
    private int id;

    @OneToOne()
    @JoinColumn(name = "id_dania", referencedColumnName = "id_dania")
    private FoodDto food;

    @Column(name = "ilosc")
    private int count;

    public OrderDataDto() {
        super();
    }

    public OrderDataDto(int id, FoodDto food, int count) {
        this.id = id;
        this.food = food;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FoodDto getFood() {
        return food;
    }

    public void setFood(FoodDto food) {
        this.food = food;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderDataDto{" +
          "id=" + id +
          ", food=" + food +
          ", count=" + count +
          '}';
    }
}