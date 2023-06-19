package com.example.cadastros.Aluno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity(name = "Aluno")
@Table(name = "aluno")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 300)
    private String nome;

    @Column(name = "matricula", nullable = false, length = 10)
    private String matricula;

    @Column(name= "id_matricula", nullable = false, updatable = false)
    private Long id_mat;
}
