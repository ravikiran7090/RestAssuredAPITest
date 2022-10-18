package practice.pojoclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
//@JsonIgnoreProperties(value = {"status"})
public class PetStorePojo {

    private int id;
    private Category1 category;
    private String name;
    private List photoUrls;
    private List tags;
    private String status;

    public PetStorePojo() {
    }

}
