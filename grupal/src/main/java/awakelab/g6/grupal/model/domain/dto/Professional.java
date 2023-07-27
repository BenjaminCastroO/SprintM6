package awakelab.g6.grupal.model.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Professional {
  private int id;
  private String run;
  private String name;
  private String lastName;
  private String mail;
  private String telephone;
  private String position;
  private int userId;
}
