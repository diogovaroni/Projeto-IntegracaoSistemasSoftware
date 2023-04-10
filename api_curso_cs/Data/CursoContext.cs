using api_curso_cs.Models;
using Microsoft.EntityFrameworkCore;

namespace api_curso_cs.Data
{
    public class CursoContext : DbContext
    {
        public CursoContext(DbContextOptions<CursoContext> options) : base(options)
        {
        }

        public DbSet<Curso> Cursos { get; set; }
    }
}