package com.example.groups_app.controller;

import com.example.groups_app.model.Group;
import com.example.groups_app.model.Student;
import com.example.groups_app.repository.GroupRepository;
import com.example.groups_app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/groups/{groupId}/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public String getStudents(@PathVariable Long groupId, Model model) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Неверный group id:" + groupId));

        List<Student> students = studentRepository.findByUniversityGroupIdOrderByFullNameAsc(groupId);
        model.addAttribute("students", students);
        model.addAttribute("group", group);
        return "student/list";
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@PathVariable Long groupId, @RequestParam String fullName) {
        Student student = new Student();
        student.setFullName(fullName);
        student.setAdmissionDate(LocalDate.now());
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Неверный group id:" + groupId));
        student.setGroup(group);
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{studentId}/delete")
    public ResponseEntity deleteStudent(@PathVariable Long studentId) {
        studentRepository.deleteById(studentId);
        return ResponseEntity.ok().build();
    }
}
