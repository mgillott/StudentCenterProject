package com.techelevator.model;

public class Schedule {

    private String periodName;
    private String subjectName;
    private String teacherFirstName;
    private String teacherLastName;

    public Schedule(){}

    public Schedule(String periodName, String subjectName, String teacherFirstName, String teacherLastName){
        this.periodName = periodName;
        this.subjectName = subjectName;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }
}
