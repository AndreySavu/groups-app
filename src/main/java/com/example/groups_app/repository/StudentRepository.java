package com.example.groups_app.repository;

import com.example.groups_app.model.Student;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByUniversityGroupIdOrderByFullNameAsc(@Param("groupId") Long groupId);
}