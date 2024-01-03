package com.example.foodapp.Domain;

public class Category {
    private int id;
    private String ImagePath;
    private String Name;

    public Category(int id, String imagePath, String name) {
        this.id = id;
        ImagePath = imagePath;
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
