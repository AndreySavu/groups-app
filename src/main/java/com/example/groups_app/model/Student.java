package com.example.groups_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fullName;
    @Column
    private LocalDate admissionDate;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group universityGroup;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setGroup(Group universityGroup) {
        this.universityGroup = universityGroup;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public Group getUniversityGroup() {
        return universityGroup;
    }
}
