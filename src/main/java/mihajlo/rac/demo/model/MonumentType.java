package mihajlo.rac.demo.model;




public class MonumentType {

    private int id;

    private String name;

    public MonumentType() {
    }

    public MonumentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
