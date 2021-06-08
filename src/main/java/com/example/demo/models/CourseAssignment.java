package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import com.example.demo.enums.AssignmentStatus;
import com.example.demo.models.Student;
import com.example.demo.models.Course;

@Entity
@Table(name = "course_assignment")
public class CourseAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String assignedOn;
    private String assignedBy;
    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;
    private String lastStatusChangedOn;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public CourseAssignment(){}

    public CourseAssignment(String assignedOn, String assignedBy, AssignmentStatus status,String lastStatusChangedOn){
        this.assignedOn= LocalDateTime.now().toString();
        this.assignedBy= assignedBy;
        this.status= status;
        this.lastStatusChangedOn= LocalDateTime.now().toString();
    }

    public CourseAssignment(Long id,String assignedOn, String assignedBy, AssignmentStatus status,String lastStatusChangedOn){
        this.id = id;
        this.assignedBy= assignedBy;
        this.status= status;
        this.lastStatusChangedOn= LocalDateTime.now().toString();
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }

    public String getLastStatusChangedOn() {
        return lastStatusChangedOn;
    }

    public void setLastStatusChangedOn(String lastStatusChangedOn) {
        this.lastStatusChangedOn = lastStatusChangedOn;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
