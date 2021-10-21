package com.example.vidasaludable.exercise;


public class FileModelExercise {
    String title, vurl, duration, description;

    public FileModelExercise() {

    }

    public FileModelExercise(String title, String vurl, String duration, String description) {
        this.title = title;
        this.vurl = vurl;
        this.duration = duration;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
