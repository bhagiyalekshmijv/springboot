package com.example.studentrecord.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.repository.query.Param;
import com.example.studentrecord.models.StudentModel;
import com.example.studentrecord.repository.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/create")
    public String createAction(Model model) {
        model.addAttribute("message", "Enter The Student Details");
        return "create";
    }

    @PostMapping("/create")
    public String createActionProcess(StudentModel studentData, Model model) {
        studentRepository.save(studentData);
        model.addAttribute("message", "The Student " + studentData.getName() + " has been created successfully");
        return "create";
    }

    @GetMapping("/all")
    public String getAllStudents(Model model, @Param("keyword") String keyword) {
        List<StudentModel> students;
        if (keyword != null && !keyword.isEmpty()) {
            students = studentRepository.findAllByKeyword(keyword);
        } else {
            students = studentRepository.findAll();
        }
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable Integer id, Model model) {
        Optional<StudentModel> optionalStudentDetails = studentRepository.findById(id);
        if (optionalStudentDetails.isPresent()) {
            model.addAttribute("studentDetails", optionalStudentDetails.get());
            return "update";
        }
        return "redirect:/all"; // Handle not found case
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Integer id, StudentModel studentData) {
        Optional<StudentModel> optionalStudentDetails = studentRepository.findById(id);
        if (optionalStudentDetails.isPresent()) {
        	StudentModel studentDetails = optionalStudentDetails.get();
        	studentDetails.setName(studentData.getName());
        	studentDetails.setStudentClass(studentData.getStudentClass());
        	studentDetails.setAge(studentData.getAge());
        	studentRepository.save(studentDetails);
        }
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id, Model model) {
        Optional<StudentModel> optionalStudentDetails = studentRepository.findById(id);
        if (optionalStudentDetails.isPresent()) {
            model.addAttribute("studentDetails", optionalStudentDetails.get());
            return "delete";
        }
        return "redirect:/all"; // Handle not found case
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
    	studentRepository.deleteById(id);
        return "redirect:/all";
    }
}