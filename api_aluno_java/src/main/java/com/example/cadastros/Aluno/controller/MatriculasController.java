package com.example.cadastros.Aluno.controller;


import com.example.cadastros.Aluno.dto.AlunosDto;
import com.example.cadastros.Aluno.dto.MatriculasDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "alunos")
public class MatriculasController {
    private ResponseEntity alterarMatriculas(@RequestBody MatriculasDto matriculasDto){

        return new ResponseEntity(HttpStatus.OK);
    }

}
