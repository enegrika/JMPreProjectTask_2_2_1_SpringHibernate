package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne (optional = false, mappedBy = "cars")
    private User user;

    public Car(long id, String model, int series) {
        this.id = id;
        this.model = model;
        this.series = series;
    }

    public Car() {}

    public long getCar_id() {
        return id;
    }

    public void setCar_id(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
