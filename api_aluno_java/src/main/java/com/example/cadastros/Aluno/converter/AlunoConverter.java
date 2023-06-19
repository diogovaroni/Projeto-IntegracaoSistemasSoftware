package com.example.cadastros.Aluno.converter;

import com.example.cadastros.Aluno.dto.AlunoDto;
import com.example.cadastros.Aluno.entity.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoConverter {

    public AlunoDto mapEntityForDTO(Aluno ent) {

        AlunoDto aluno = new AlunoDto();
        aluno.setId(ent.getId());
        aluno.setNome(ent.getNome());
        aluno.setMatricula(ent.getMatricula());
        aluno.setId_mat(ent.getId_mat());



        return aluno;
    }

    public Aluno mapDTOForInsert(AlunoDto dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setMatricula(dto.getMatricula());
        aluno.setId_mat(dto.getId_mat());

        return aluno;

    }
    public Aluno mapDTOForUpdate(Aluno ent, AlunoDto dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome() != null ? dto.getNome() : ent.getNome());
        aluno.setMatricula(dto.getMatricula() != null ? dto.getMatricula() : ent.getMatricula());
        aluno.setId_mat(dto.getId_mat());

        return aluno;

    }
}
