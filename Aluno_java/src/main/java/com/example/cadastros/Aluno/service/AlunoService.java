package com.example.cadastros.Aluno.service;

import com.example.cadastros.Aluno.converter.AlunoConverter;
import com.example.cadastros.Aluno.dto.AlunoDto;
import com.example.cadastros.Aluno.entity.Aluno;
import com.example.cadastros.Aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoConverter converter;

    public Aluno findById(Long id) {

        Aluno aluno = repository.getOne(id);

        return aluno;
    }

    public AlunoDto create(AlunoDto dto) {

        Aluno aluno = converter.mapDTOForInsert(dto);
        repository.save(aluno);
        return converter.mapEntityForDTO(aluno);
    }

    public AlunoDto update(Long id, AlunoDto dto) {
        Aluno alunoOld = findById(id);

        converter.mapDTOForUpdate(alunoOld, dto);
        repository.save(alunoOld);
        return converter.mapEntityForDTO(alunoOld);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);

    }
}
