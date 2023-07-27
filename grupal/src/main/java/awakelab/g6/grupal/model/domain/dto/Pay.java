package awakelab.g6.grupal.model.domain.dto;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pay {
    private int id;
    private Date payDay;
    private float amount;
    private Customer customer;


}
