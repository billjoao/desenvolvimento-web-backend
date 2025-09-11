package com.example.ex.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(nullable = false)
    private int anoIngresso;
    @Column(nullable = false)
    private int idCurso;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Cursos cursos;

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Aluno() {
    }

    public Aluno(int id, String nome, int anoIngresso, int idCurso) {
        this.id = id;
        this.nome = nome;
        this.anoIngresso = anoIngresso;
        this.idCurso = idCurso;
    }

}
