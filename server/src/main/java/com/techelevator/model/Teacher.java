package com.techelevator.model;

public class Teacher {

    private int teacherId;
    private String teacherFirstName;
    private String teacherLastName;
    private String teacherGender;
    private String teacherEmail;
    private int teacherPhoneNumber;
    private String subject;
    private String period;



    public Teacher(){}

    public Teacher(int teacherId, String teacherFirstName, String teacherLastName, String teacherGender, String teacherEmail, int teacherPhoneNumber){
        this.teacherId = teacherId;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.teacherGender = teacherGender;
        this.teacherEmail = teacherEmail;
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public Teacher(String teacherFirstName, String subject, String period) { //this is for the specific data pull of a teachers schedule - what period they teach their subjects.
        this.teacherFirstName = teacherFirstName;
        this.subject = subject;
        this.period = period;
    }


    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public int getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(int teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherFirstName='" + teacherFirstName + '\'' +
                ", teacherLastName='" + teacherLastName + '\'' +
                ", teacherGender='" + teacherGender + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", teacherPhoneNumber=" + teacherPhoneNumber +
                '}';
    }
}
