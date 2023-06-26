import { PrismaClient } from "@prisma/client";
import { Curso } from "../models/curso.model";

const prisma = new PrismaClient();

let cursos : Curso[] = [];

export class CursoRepository{
    async list(): Promise<Curso[]> {
        return await prisma.curso.findMany();
    }

    async create(curso: Curso): Promise<Curso> {        
        await prisma.curso.create({
            data:{
                nome : curso.nome,
                nivel : curso.nivel,
            }, 
        })
        return curso;
    }

    async find(idCurso: number): Promise<Curso | null> {
        return await prisma.curso.findUnique({
            where: {
            idCurso: idCurso,
            },
        });
    }

    async delete(id: number): Promise<Curso | null> {        
            const curso = await prisma.curso.delete({
            where: {
                idCurso: id,
            },
        });
        return curso;
    }
    
    async update(curso: Curso | null): Promise<Curso | null> {
        try {
            const cursoAlterado = await prisma.curso.update({
                where: { idCurso: curso?.idCurso,
                },
                    data: {
                    nome: curso?.nome,
                    nivel: curso?.nivel,
                },
            });
            return cursoAlterado;
        }catch {
            return null;
        }
    }
}



