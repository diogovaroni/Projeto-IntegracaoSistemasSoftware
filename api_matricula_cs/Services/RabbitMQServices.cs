using System.Text;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;

namespace api_matricula_cs_.Services;

public class RabbitMQService : BackgroundService
{
protected override Task ExecuteAsync(CancellationToken stoppingToken)
{
    ConnectionFactory factory = new ConnectionFactory
    {
        HostName = "localhost"
    };
    var connection = factory.CreateConnection();
    var channel = connection.CreateModel();

    var cursosConsumer = new EventingBasicConsumer(channel);
    cursosConsumer.Received += (model, message) =>
    {
        var body = message.Body.ToArray();
        var mensagem = Encoding.UTF8.GetString(body);
        Console.WriteLine($"Mensagem da fila 'FILA - Cursos': {mensagem}");
    };

    var alunosConsumer = new EventingBasicConsumer(channel);
    alunosConsumer.Received += (model, message) =>
    {
        var body = message.Body.ToArray();
        var mensagem = Encoding.UTF8.GetString(body);
        Console.WriteLine($"Mensagem da fila 'FILA - Aluno': {mensagem}");
    };

    channel.BasicConsume(
        queue: "FILA - Cursos",
        autoAck: true,
        consumer: cursosConsumer
    );

    channel.BasicConsume(
        queue: "FILA - Aluno",
        autoAck: true,
        consumer: alunosConsumer
    );

    return Task.CompletedTask;
}
    
    
}