package qa.b2b.api.pojoclasses;


public class Category1 {
    private int id;
    private String name;

    public Category1() {
    }

    public Category1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
