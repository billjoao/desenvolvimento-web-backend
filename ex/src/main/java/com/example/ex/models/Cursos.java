package com.example.ex.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nomeCurso;

    @OneToMany(mappedBy = "cursos")
    private List<Aluno> alunos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Cursos() {
    }

    public Cursos(int id, String nomeCurso) {
        this.id = id;
        this.nomeCurso = nomeCurso;
    }

}
