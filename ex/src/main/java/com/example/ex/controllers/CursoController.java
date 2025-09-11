package com.example.ex.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex.models.Cursos;

@RestController
@RequestMapping("/cursos")
public class CursoController {

     ArrayList<Cursos> produtos = new ArrayList<>();

    @PostMapping("")
    public String inserir(@RequestBody Cursos produto) {
        produtos.add(produto);
        return "Cursos inserido com sucesso!";
    }

    @GetMapping("")
    public ArrayList<Cursos> listarTodos() {
        return produtos;
    }

}
