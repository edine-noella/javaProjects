package com.example.demo.models;
import com.example.demo.enums.BedType;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="bed")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bed_id")
    private Long id;
    @Column(name="bed_number")
    private String bedNumber;
    @Enumerated(EnumType.STRING)
    @Column(name="bed_type")
    private BedType type;
    @ManyToMany(mappedBy = "beds", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<Student>();
    public Bed() {
    }

    public Bed(String bedNumber, BedType type) {
        this.bedNumber = bedNumber;
        this.type = type;
    }

    public Bed(String bedNumber) {
        this.bedNumber = bedNumber;
    }
    public Bed(Long id, String bedNumber, BedType type) {
        this.id = id;
        this.bedNumber = bedNumber;
        this.type = type;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBedNumber() {
        return bedNumber;
    }
    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }
    public BedType getType() {
        return type;
    }
    public void setType(BedType type) {
        this.type = type;
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
