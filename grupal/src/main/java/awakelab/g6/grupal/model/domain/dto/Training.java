package awakelab.g6.grupal.model.domain.dto;

import lombok.*;
import java.sql.Time;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Training {
  private int id;
  private String name;
  private String place;
  private Date date;
  private Time time;
  private String detail ;
  private float duration;
  private int quantity;
  private Customer customer;
}
