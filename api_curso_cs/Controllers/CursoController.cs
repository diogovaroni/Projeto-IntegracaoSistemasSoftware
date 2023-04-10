using System.Collections.Generic;
using System.Linq;
using api_curso_cs.Data;
using api_curso_cs.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace api_curso_cs.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class CursoController : ControllerBase
    {
        private readonly CursoContext _context;

        public CursoController(CursoContext context)
        {
            _context = context;
        }

        [HttpGet]
        // GET: api/Curso
        public ActionResult<List<Curso>> GetAll()
        {
            return _context.Cursos.ToList();
        }

        // GET: api/Curso/id 
        [HttpGet("{id}")]
        public ActionResult<Curso> GetById(int id)
        {
            var curso = _context.Cursos.Find(id);

            if (curso == null)
            {
                return NotFound();
            }

            return curso;
        }

        [HttpPost]
        public ActionResult<Curso> Post(Curso curso)
        {
            _context.Cursos.Add(curso);
            _context.SaveChanges();

            return CreatedAtAction(nameof(GetById), new { id = curso.Id }, curso);
        }

        //Criar Método PUT


        //Criar Método DELETE
    }
}