package com.diptech.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String certificateName;
    private String issuer;
    private String dateIssued;
    @ManyToOne
    @JoinColumn(name = "my_info_id")
    @JsonBackReference // Prevent infinite recursion in JSON
    private MyInfo myInfo;

}
