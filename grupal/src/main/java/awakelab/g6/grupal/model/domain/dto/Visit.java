package awakelab.g6.grupal.model.domain.dto;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Visit {
    private int id;
    private Date date;
    private Time time;
    private String place;
    private boolean done;
    private String detail;
    private Professional professional;
    private Customer customer;


}
