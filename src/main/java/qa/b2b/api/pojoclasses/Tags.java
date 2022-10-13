package qa.b2b.api.pojoclasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value = {"String","Integer"})
public class Tags {
    private Integer id;
    private String name;

    public Tags(){
    }
}
