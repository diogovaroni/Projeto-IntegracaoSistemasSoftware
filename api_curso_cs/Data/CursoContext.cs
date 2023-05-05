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

        //Método que cria a tabela 'cursos' no MySQL as colunas especificadas
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
        
            modelBuilder.Entity<Curso>(entity =>
            {
                entity.HasKey(e => e.Id);

                entity.Property(e => e.Nome)
                    .IsRequired()
                    .HasMaxLength(50);

                entity.Property(e => e.Nivel)
                    .IsRequired()
                    .HasMaxLength(20);

                entity.Property(e => e.Id)
                    .IsRequired()
                    .ValueGeneratedOnAdd();

                entity.HasIndex(e => e.Id)
                    .IsUnique();

                entity.HasCheckConstraint("CK_Cursos_Nivel", "Nivel IN ('Básico', 'Intermediário', 'Avançado')");
            });
        }

    }
}