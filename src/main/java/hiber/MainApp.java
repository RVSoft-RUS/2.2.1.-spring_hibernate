package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      Car car = new Car();
      car.setName("Lada");
      car.setSeries(21099);
      User user1 = new User("Vasya", "Pupkin", "v@mail.ru");
      user1.setCar(car);
      userService.add(user1);

      car = new Car();
      car.setName("Renault");
      car.setSeries(10);
      user1 = new User("Kolya", "Zhukov", "k@mail.ru");
      user1.setCar(car);
      userService.add(user1);

      car = new Car();
      car.setName("Toyota");
      car.setSeries(155);
      user1 = new User("Misha", "Dolboyobov", "m@mail.ru");
      user1.setCar(car);
      userService.add(user1);



      List<User> users = userService.listUsers();
//      userService.delete(users.get(1));
//      users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }
      user1 = userService.findUserByCarSeries(10);
      System.out.println(user1);
      System.out.println("Id = "+user1.getId());
      System.out.println("First Name = "+user1.getFirstName());
      System.out.println("Last Name = "+user1.getLastName());
      System.out.println("Email = "+user1.getEmail());
      context.close();
   }
}
