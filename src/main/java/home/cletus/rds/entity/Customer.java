package home.cletus.rds.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @ApiModelProperty(notes = "name of the customer")
    private String name;

    @ApiModelProperty(notes = "user age")
    @Column(name = "age")
    private Integer age;

    @Column(name = "money")
    private Long money;
}
