package home.cletus.rds.entity;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
