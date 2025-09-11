package com.example.ex.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ex.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {
    
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Aluno inserir(Aluno aluno) {
        entityManager.persist(aluno); 
        return aluno;
    }

    @Transactional
    public Aluno editar(Aluno aluno) {
        entityManager.merge(aluno); 
        return aluno;
    }

    public List<Aluno> listarTodos() {
        String jpql = "SELECT c FROM Aluno c";
        return entityManager.createQuery(
                jpql, Aluno.class).getResultList();
    }

    public Aluno obterPorId(int id) {
        return entityManager.find(Aluno.class, id);
    }

    @Transactional
    public void excluir(int id) {
        Aluno categoriaCurso = entityManager.find(Aluno.class, id); 
        excluir(categoriaCurso);
    }
    
    @Transactional
    public void excluir(Aluno categoriaCurso) {
        entityManager.remove(categoriaCurso);
    }

    public List<Aluno> obterPorNome(String nome) {
        String jpql = "SELECT c FROM Aluno c WHERE c.nome LIKE :nome";
        return entityManager.createQuery(jpql, Aluno.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }
}
