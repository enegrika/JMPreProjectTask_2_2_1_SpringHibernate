package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;


   /// SOLUTION
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "fk_car_id")
   private Car carObj;

   public Car getCarObj() {
      return carObj;
   }

   public void setCarObj(Car car) {
      this.carObj = car;
   }

   public User() {}
   
   public User(String firstName, String lastName, String email, Car carObj) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.carObj = carObj;
   }


   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public String toString() {
      return "User_" +
              "id = " + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", CarModel=" + carObj.getModel() + " series: " + carObj.getSeries() +
              ' ';
   }

}
