package com.techelevator.model;

public class StudentGrade {

    private String letterGrade;
    private int studentId;
    private int classId;

    public StudentGrade(){}

    public StudentGrade(String letterGrade, int studentId, int classId){
        this.letterGrade = letterGrade;
        this.studentId = studentId;
        this.classId = classId;
    }


    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
