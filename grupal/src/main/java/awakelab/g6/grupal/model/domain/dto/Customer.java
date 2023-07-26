package awakelab.g6.grupal.model.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
  private int id;
  private String rut;
  private String name;
  private String lastName;
  private String mail;
  private String telephone;
  private String afp;
  private String healthcare;
  private String direction;
  private String district;
  private int age;
  private int userId;
}
