package com.diptech.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String projectName;
    @Column(length = 2000)
    private String projectDesc;
    @Lob
    private String projectImg;

    @ManyToOne
    @JoinColumn(name = "my_info_id")
    @JsonBackReference
    private MyInfo myInfo;

}
