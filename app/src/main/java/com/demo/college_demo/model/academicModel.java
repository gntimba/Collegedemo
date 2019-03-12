package com.demo.college_demo.model;

import java.util.Map;

public class academicModel {
    private String subject;
    private Double average;
    private Map marks;

    public String getSubject() {
        return subject;
    }

    public Double getAverage() {
        return average;
    }

    public Map getMarks() {
        return marks;
    }

    public academicModel(String subject, Double average, Map marks) {
        this.subject = subject;
        this.average = average;
        this.marks = marks;
    }
}
