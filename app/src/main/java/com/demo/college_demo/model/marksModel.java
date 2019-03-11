package com.demo.college_demo.model;

public class marksModel {
    private String subject;
    private String date;
    private double marks;

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public double getMarks() {
        return marks;
    }

    public marksModel(String subject, String date, double marks) {
        this.subject = subject;
        this.date = date;
        this.marks = marks;
    }
}
