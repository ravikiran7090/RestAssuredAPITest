package qa.b2b.api.parcer.pojolib;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PojoLib {

    private String name;
    private String empId;
    private String emailId;
    private long contactNumber;

    public PojoLib(){}

}
