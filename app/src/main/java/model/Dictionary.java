package model;

public class Dictionary {
    public Dictionary(String name, String meaning, String imageName) {
        this.name = name;
        this.meaning = meaning;
        this.imageName = imageName;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    private String meaning;
    private String imageName;
}
