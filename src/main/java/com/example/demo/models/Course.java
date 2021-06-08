package com.example.demo.models;
import com.example.demo.enums.BedType;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private Long id;
    @Column(name="course_name")
    private String courseName;
    @Column(name="course_hours")
    private String nbrHours;

    @OneToMany(mappedBy = "course", fetch =FetchType.LAZY )
    private Set<CourseAssignment> students = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getNbrHours() {
        return nbrHours;
    }

    public void setNbrHours(String nbrHours) {
        this.nbrHours = nbrHours;
    }

    public Course() {
    }

    public Course(String courseName, String nbrHours) {
        this.courseName= courseName;
        this.nbrHours = nbrHours;
    }

    public Set<CourseAssignment> getStudents() {
        return students;
    }

    public void setStudents(Set<CourseAssignment> students) {
        this.students = students;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }
    public Course(Long id, String courseName, String nbrHours) {
        this.id = id;
        this.courseName = courseName;
        this.nbrHours = nbrHours;
    }

}
