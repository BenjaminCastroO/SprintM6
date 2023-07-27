package awakelab.g6.grupal.model.domain.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CheckList {
    private int id;
    private Visit visit;
    private String detail;
    private String status;

}
