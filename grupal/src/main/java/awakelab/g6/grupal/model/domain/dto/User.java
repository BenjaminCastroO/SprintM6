package awakelab.g6.grupal.model.domain.dto;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
  private int id;
  private String name;
  private String username;
  private String password;
}
