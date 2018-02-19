package main.eatogo;
public class foods {
    private int id;
    private int image;
    private String name,name2;
    public foods(int id, int image, String name,String name2){
        super();
        this.id = id;
        this.image = image;
        this.name = name;
        this.name2=name2;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name2 = name2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name) {
        this.name2 = name2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
