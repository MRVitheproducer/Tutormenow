package com.example.jobportal.Model;

public class Data {
    String title;
    String description;
    String skills;
    String salary;

    String id;
    String date;

    public Data(String title, String description, String skills, String salary, String id, String date){

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSkills() {
        return skills;
    }

    public String getSalary() {
        return salary;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
