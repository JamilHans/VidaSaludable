package com.example.vidasaludable.alimentos.fragments;

public class comidatipica {
    String image, titleFood, titleg, titlekcal;

    public comidatipica(String image, String titleFood, String titleg, String titlekcal) {
        this.image = image;
        this.titleFood = titleFood;
        this.titleg = titleg;
        this.titlekcal = titlekcal;
    }

    public comidatipica() {
    }

    @Override
    public String toString() {
        return "comidatipica{" +
                "image='" + image + '\'' +
                ", titleFood='" + titleFood + '\'' +
                ", titleg='" + titleg + '\'' +
                ", titlekcal='" + titlekcal + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitleFood() {
        return titleFood;
    }

    public void setTitleFood(String titleFood) {
        this.titleFood = titleFood;
    }

    public String getTitleg() {
        return titleg;
    }

    public void setTitleg(String titleg) {
        this.titleg = titleg;
    }

    public String getTitlekcal() {
        return titlekcal;
    }

    public void setTitlekcal(String titlekcal) {
        this.titlekcal = titlekcal;
    }
}
