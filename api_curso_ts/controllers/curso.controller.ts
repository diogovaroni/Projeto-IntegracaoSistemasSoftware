import { Request, Response } from "express";
import { Curso } from "../models/curso.model";
import { CursoRepository } from "../data/curso.repository";
import { RabbitMQService } from "../service/rabbitmq.services";

const repository = new CursoRepository();
const service = new RabbitMQService();

export class CursoController {
    async list(request: Request, response: Response) {
        const cursos = await repository.list();
        return response.status(200).json({
          message: "Cursos cadastrados: ",
          data: cursos,
        });
    }

    async create(request: Request, response: Response){
      let curso : Curso = request.body;            
            
      curso = await repository.create(curso);
      // Serializa o objeto curso para JSON
      service.enviar(JSON.stringify(curso));

      // Envia apenas o nome do curso para o RabbitMQ
      //service.enviar(curso.nome);

    
      return response.status(201).json({
        message : "Curso cadastrado.",
          data : curso,
        });
    }

    async find(request: Request, response: Response) {
        const idCurso = Number.parseInt(request.params.idCurso);
    
        const curso = await repository.find(idCurso);
    
        if (!curso) {
          return response.status(404).json({ message: "Curso não encontrado" });
        }
    
        return response.status(200).json({
          message: "Curso: ",
          data: curso,
        });
    }

    async delete(request: Request, response: Response) {
        const idCurso = Number.parseInt(request.params.id);
        let cursos = await repository.delete(idCurso);
        return response.status(200).json({
          message: "OK",
          data: cursos,
        });
    }

    async update(request: Request, response: Response) {
      try {
          let curso: Curso | null = request.body;
          curso = await repository.update(curso);
  
          if (!curso) {
              return response.status(404).json({ message: "Curso não encontrado" });
          }
  
          return response.status(200).json({
              message: "Curso atualizado",
              data: curso,
          });
      } catch (error) {
          console.error(error);
          return response.status(500).json({ message: "Erro ao atualizar o curso" });
      }
  }
  

}








