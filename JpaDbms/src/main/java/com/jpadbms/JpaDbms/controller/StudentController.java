package com.jpadbms.JpaDbms.controller;

import com.jpadbms.JpaDbms.model.Student;
import com.jpadbms.JpaDbms.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @PostMapping(value = "/saveData")
    public String saveData(@RequestBody Student student)
    {
        studentRepo.save(student);
        return  "Record inserted successfully";
    }

    @GetMapping(value = "/showAllData")
    public List<Student> showAllData()
    {
        List<Student> list =studentRepo.findAll();
        return list;
    }

    @GetMapping(value = "/getById/{id}")
    public Student getById(@PathVariable Integer id)
    {
        return studentRepo.findById(id);
    }

    @GetMapping(value = "/getByName/{name}")
    public List<Student> getByName(@PathVariable String name)
    {
        List<Student> list =  studentRepo.findByName(name);
        return list;
    }
    @GetMapping(value = "/getByCity/{city}")
    public List<Student> getByCity(@PathVariable String city)
    {
        List<Student> list = studentRepo.findByCity(city);
        return  list;
    }
    @GetMapping(value = "/getByIdAndName")
    public List<Student> getByIdAndName(@PathVariable Integer id,String name)
    {
        List<Student> list = studentRepo.findByIdAndName(id,name);
        return  list;
    }
    @GetMapping(value = "/deleteById/{id}")
    public String deleteById(@PathVariable Integer id)
    {
        studentRepo.delete(id);
        return  "deleted successfully";
    }

    @GetMapping (value = "/updateById/{id}/{name}")
    public String updateById(@PathVariable Integer id,@PathVariable String name)
    {
        Student student=studentRepo.findById(id);
        student.setName(name);
        studentRepo.save(student);
        return "updated successfully";
    }
    @PostMapping (value = "/uploadImage")
    public String uploaImage(@RequestParam MultipartFile file)
    {
        File f=new File("F:\\images\\"+file.getOriginalFilename());

        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "image uploaded";
    }
}

