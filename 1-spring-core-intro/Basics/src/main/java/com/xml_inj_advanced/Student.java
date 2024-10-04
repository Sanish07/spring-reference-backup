package com.xml_inj_advanced;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {

    private int studentId;

    private String studentName;

    private float cgpa;

    private List<String> subjects;

    private Set<Integer> referrals;

    private Map<String, Integer> scores;

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Set<Integer> getReferrals() {
        return referrals;
    }

    public void setReferrals(Set<Integer> referrals) {
        this.referrals = referrals;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", cgpa=" + cgpa +
                ", subjects=" + subjects +
                ", referrals=" + referrals +
                ", scores=" + scores +
                '}';
    }
}
