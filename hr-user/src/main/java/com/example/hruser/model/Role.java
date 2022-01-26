package com.example.hruser.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_role")
public class Role implements Serializable {
    private  static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;


    public Role() {
    }

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
}
