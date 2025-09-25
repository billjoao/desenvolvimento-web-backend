package com.example.prova.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(length = 200, nullable = false)
    private String titulo;
    @Column(nullable = false)
    private Integer duraçao;



    @ManyToOne
    @JoinColumn(name = "diretor_id")
    @ToString.Exclude
    private Diretor diretor;


}
