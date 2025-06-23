package com.anth.applicationtracker.model;

import jakarta.persistence.*;
import com.anth.applicationtracker.model.ERole;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private ERole name;

    protected Role() {
    }
    public Role(ERole name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public ERole getName() {
        return name;
    }
    public void setName(ERole name) {
        this.name = name;
    }
}
