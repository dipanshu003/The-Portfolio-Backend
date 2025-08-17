package com.diptech.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_info")
public class MyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String designation;
    @Column(length = 2000)
    private String profileSummary;
    private String email;
    private String phoneNumber;
    private String address;
    @OneToMany(mappedBy = "myInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Prevent infinite recursion in JSON
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "myInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Project> projects;

    @OneToMany(mappedBy = "myInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Skill> skills;


}
