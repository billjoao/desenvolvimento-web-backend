package com.example.prova.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(length = 200, nullable = false)
    private String nome;

     @OneToMany(mappedBy = "diretor", fetch = FetchType.EAGER)

    private List<Filme> filmes;
}
