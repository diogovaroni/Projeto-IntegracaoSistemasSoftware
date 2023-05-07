package com.example.cadastros.Aluno.repository;

import com.example.cadastros.Aluno.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AlunoRepository extends JpaRepository<Aluno, Long> {
}
