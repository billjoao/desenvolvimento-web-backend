package com.example.ex.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ex.models.Cursos;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class CursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cursos inserir(Cursos cursos) {
        entityManager.persist(cursos); 
        return cursos;
    }

    @Transactional
    public Cursos editar(Cursos cursos) {
        entityManager.merge(cursos); 
        return cursos;
    }

    public List<Cursos> listarTodos() {
        String jpql = "SELECT c FROM Cursos c";
        return entityManager.createQuery(
                jpql, Cursos.class).getResultList();
    }

    public Cursos obterPorId(int id) {
        return entityManager.find(Cursos.class, id);
    }

    @Transactional
    public void excluir(int id) {
        Cursos categoriaCurso = entityManager.find(Cursos.class, id); 
        excluir(categoriaCurso);
    }
    
    @Transactional
    public void excluir(Cursos categoriaCurso) {
        entityManager.remove(categoriaCurso);
    }

}
