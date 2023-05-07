package com.example.cadastros.Aluno.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {

    @ApiModelProperty(value = "Id do registro", example = "1")
    private Long id;

    @ApiModelProperty(value = "Nome do Aluno", example = "José dos Santos")
    @NotBlank
    @Size(max = 255)
    private String nome;


    @ApiModelProperty(value = "Nome do Aluno", example = "1234")
    @NotBlank
    @Size(max = 10)
    private String matricula;

    @ApiModelProperty(value = "Id da matricula", example = "2")
    private Long id_mat;









}
