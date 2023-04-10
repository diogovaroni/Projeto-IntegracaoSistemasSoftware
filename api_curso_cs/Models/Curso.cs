using System.ComponentModel.DataAnnotations;

namespace api_curso_cs.Models
{
    public class Curso
    {
        public int Id { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public string Nivel { get; set; }
    }
}