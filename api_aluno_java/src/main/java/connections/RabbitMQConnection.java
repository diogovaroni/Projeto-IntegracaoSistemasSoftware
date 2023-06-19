package connections;

import constantes.RabbitmqConstantes;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {
    private static final String NOME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;

    }

    private Queue fila(String nomeFila){
        return new Queue(nomeFila, true,false,false);
    }

    private DirectExchange trocadireta(){
      return new DirectExchange(NOME_EXCHANGE);
    }
    private Binding relacionamento( Queue fila, DirectExchange troca){
      return   new Binding(fila.getName(), Binding.DestinationType.QUEUE,troca.getName(),fila.getName(),null);
    }

    @PostConstruct
    private void adiciona() {
        Queue filaAlunos = this.fila(RabbitmqConstantes.fila_alunos);
        Queue filamatriculas = this.fila(RabbitmqConstantes.fila_matricula);

        DirectExchange troca = this.trocadireta();

        Binding ligacaoAlunos = this.relacionamento(filaAlunos, troca);
        Binding ligacaoMatriculas = this.relacionamento(filamatriculas, troca);

        //criando as filas
        this.amqpAdmin.declareQueue(filaAlunos);
        this.amqpAdmin.declareQueue(filamatriculas);

        this.amqpAdmin.declareExchange(troca);

        this.amqpAdmin.declareBinding(ligacaoAlunos);
        this.amqpAdmin.declareBinding(ligacaoMatriculas);
    }
}
