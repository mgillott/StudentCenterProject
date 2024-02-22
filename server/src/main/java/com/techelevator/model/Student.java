package com.techelevator.model;

import java.util.List;
import java.util.Map;

public class Student {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String enrollmentDate;

    private Map<String, String> studentSchedule;

    public Student(){
    }

    public Student(int id, String firstName, String middleName, String lastName, String dateOfBirth, String gender, String enrollmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.enrollmentDate = enrollmentDate;
    }

    public Student(int id, String firstName, String middleName, String lastName, String dateOfBirth, String gender, String enrollmentDate, Map<String, String> studentSchedule) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.enrollmentDate = enrollmentDate;
        this.studentSchedule = studentSchedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Map<String, String> getStudentSchedule() {
        return studentSchedule;
    }

    public void setStudentSchedule(Map<String, String> studentSchedule) {
        this.studentSchedule = studentSchedule;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                '}';
    }
}
