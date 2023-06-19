package com.example.cadastros.Aluno.controller;

import com.example.cadastros.Aluno.converter.AlunoConverter;
import com.example.cadastros.Aluno.dto.AlunoDto;
import com.example.cadastros.Aluno.entity.Aluno;
import com.example.cadastros.Aluno.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoConverter alunoConverter;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AlunoDto> findById(@PathVariable Long id) {
        Aluno obj = alunoService.findById(id);
        return ResponseEntity.ok().body(alunoConverter.mapEntityForDTO(obj));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AlunoDto> create(@RequestBody @Valid AlunoDto dto) {
        AlunoDto alunoDto = alunoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(alunoDto);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AlunoDto> update(@PathVariable Long id, @Valid @RequestBody AlunoDto dto) {
        AlunoDto alunoDto = alunoService.update(id, dto);
        return ResponseEntity.ok().body(alunoDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
