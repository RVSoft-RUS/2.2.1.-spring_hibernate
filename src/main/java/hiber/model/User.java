package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "userId")
   private Long userId;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @PrimaryKeyJoinColumn
   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
//      this.car = car;
   }

   public Long getId() {
      return userId;
   }

   public void setId(Long id) {
      this.userId = id;
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

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      User user = (User) o;

      if (!userId.equals(user.userId)) return false;
      if (!firstName.equals(user.firstName)) return false;
      if (!lastName.equals(user.lastName)) return false;
      return email.equals(user.email);
   }

   @Override
   public int hashCode() {
      int result = userId.hashCode();
      result = 31 * result + firstName.hashCode();
      result = 31 * result + lastName.hashCode();
      result = 31 * result + email.hashCode();
      return result;
   }

   @Override
   public String toString() {
      return "User{" +
              "userId=" + userId +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
