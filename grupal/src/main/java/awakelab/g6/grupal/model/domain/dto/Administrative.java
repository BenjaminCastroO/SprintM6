package awakelab.g6.grupal.model.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Administrative {
  private int id;
  private String run;
  private String name;
  private String lastName;
  private String mail;
  private String area;
  private int userId;
}
