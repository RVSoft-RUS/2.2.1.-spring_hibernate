package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "name")
    private String name;

    @Column(name = "series")
    private int series;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "car")
    private User owner;

    public Car() {
    }
//    public Car(Long id, String firstName, int series) {
//        this.carId = id;
//        this.name = firstName;
//        this.series = series;
////        this.owner = owner;
//    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", name='" + name + '\'' +
                ", series=" + series +
                ", owner=" + owner +
                '}';
    }
}
