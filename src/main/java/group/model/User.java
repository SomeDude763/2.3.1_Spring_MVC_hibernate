package group.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Имя не должно быть пустым, заправься борщом густым")
    @Size(min = 2,max = 50, message = "тут такое дело... " +
            "имя должно состоять как минимум из 2 и как максимум из 50 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$",message = "выйди и зайди заново, используя только буквы")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Фамилия не должна быть пустой, сделай бутерброд с колбасой")
    @Size(min = 2,max = 50, message = "ну что ж такое то," +
            " фамилия должна состоять как минимум из 2 и как максимум из 50 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я\\-]+$",message = "зайди и выйди заново, используя только буквы")
    private String surname;

    @Min(value = 0, message = "Возраст не может быть меньше 0, за меня идиота не держи")
    @Max(value = 150, message = "Возраст слишком большой, сооберись")
    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname=" + surname +
                ", age='" + age + '\'' +
                '}';
    }
}
