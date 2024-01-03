package com.example.foodapp.Domain;

public class Foods {
    private int id;
    private String Description;
    private boolean BestFood;
    private int Id;
    private int LocationId;
    private double Price;
    private String ImagePath;
    private int PriceId;
    private double Star;
    private int TimeId;
    private int TimeValue;
    private String Title;
    private int numberInCart;

    //int id, String description, boolean bestFood, int id1, int locationId, double price, String imagePath, int priceId, double star, int timeId, int timeValue, String title, int numberInCart
    public Foods() {
//        this.id = id;
//        Description = description;
//        BestFood = bestFood;
//        Id = id1;
//        LocationId = locationId;
//        Price = price;
//        ImagePath = imagePath;
//        PriceId = priceId;
//        Star = star;
//        TimeId = timeId;
//        TimeValue = timeValue;
//        Title = title;
//        this.numberInCart = numberInCart;
    }
    @Override
    public String toString(){
        return Title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int locationId) {
        LocationId = locationId;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public int getPriceId() {
        return PriceId;
    }

    public void setPriceId(int priceId) {
        PriceId = priceId;
    }

    public double getStar() {
        return Star;
    }

    public void setStar(double star) {
        Star = star;
    }

    public int getTimeId() {
        return TimeId;
    }

    public void setTimeId(int timeId) {
        TimeId = timeId;
    }

    public int getTimeValue() {
        return TimeValue;
    }

    public void setTimeValue(int timeValue) {
        TimeValue = timeValue;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isBestFood() {
        return BestFood;
    }

    public void setBestFood(boolean bestFood) {
        BestFood = bestFood;
    }
}
