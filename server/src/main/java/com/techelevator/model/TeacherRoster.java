package com.techelevator.model;

public class TeacherRoster {

    private String studentName;
    private String studentLastName;
    private String gender;
    private String grade;

    public TeacherRoster(){}

    public TeacherRoster(String studentName, String studentLastName, String gender, String grade){
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.gender = gender;
        this.grade = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
