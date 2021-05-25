package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long car_id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;
    //
    // optional=false - НЕ РАБОТАЕТ,,, ПОТОМУ что Хибернейт вначале создает Таблицу Cars
    // и только потом таблицу USERS, то есть если у нас нет Юзера (а его нет без создания машины )
    // а параметр optional говорит JPA, является ли значение в этом поле обязательным или нет.
    // по умолчанию - TRUE, то есть ЭТО ПОЛЕ ОБЯЗАТЕЛЬНО
    @OneToOne(mappedBy = "carObj")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    public long getCar_id() {
        return car_id;
    }

    public void setCar_id(long id) {
        this.car_id = id;
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

    public void setSeries(Integer series) {
        this.series = series;
    }


}

//http://java-online.ru/hibernate-entities.xhtml