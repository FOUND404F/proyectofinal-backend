package com.example.proyectofinalmaster.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private LocalDate create_at;
    private LocalDate updated_at;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Skilled> skilleds = new ArrayList<>();

    public Tags() {
    }

    public Tags(String nombre, LocalDate create_at, LocalDate updated_at) {
        this.name = nombre;
        this.create_at = create_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public List<Skilled> getSkilleds() {
        return skilleds;
    }

    public void setSkilleds(List<Skilled> skilleds) {
        this.skilleds = skilleds;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_at=" + create_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
