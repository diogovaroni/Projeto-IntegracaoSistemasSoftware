from flask import Flask, request
import pika
import mysql.connector

app = Flask(__name__)

# Configurações do RabbitMQ
rabbitmq_host = 'localhost'
rabbitmq_queue = 'FILA - Aluno'

# Configurações do MySQL
mysql_host = 'localhost'
mysql_user = 'root'
mysql_password = ''
mysql_database = 'Alunos'

@app.route('/alunos', methods=['GET'])
def get_alunos():
    try:
        connection = mysql.connector.connect(
            host=mysql_host,
            user=mysql_user,
            password=mysql_password,
            database=mysql_database
        )

        cursor = connection.cursor()
        cursor.execute('SELECT * FROM Aluno')
        alunos = cursor.fetchall()

        response = []
        for aluno in alunos:
            aluno_dict = {
                'id': aluno[0],
                'nome': aluno[1],
                'email': aluno[2]
            }
            response.append(aluno_dict)

        return {'alunos': response}
    except mysql.connector.Error as error:
        return str(error)
    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()

@app.route('/alunos', methods=['POST'])
def create_aluno():
    try:
        data = request.json
        aluno = {
            'id': data['id'],
            'nome': data['nome'],
            'email': data['email']
        }
        # Adicionar aluno ao banco de dados MySQL
        connection = mysql.connector.connect(
            host=mysql_host,
            user=mysql_user,
            password=mysql_password,
            database=mysql_database
        )

        cursor = connection.cursor()
        query = "INSERT INTO Aluno (id, nome, email) VALUES (%s, %s, %s)"
        values = (aluno['id'], aluno['nome'], aluno['email'])
        cursor.execute(query, values)
        connection.commit()

        # Enviar aluno para a fila RabbitMQ
        connection = pika.BlockingConnection(pika.ConnectionParameters(host=rabbitmq_host))
        channel = connection.channel()
        channel.queue_declare(queue=rabbitmq_queue)

        channel.basic_publish(exchange='', routing_key=rabbitmq_queue, body=str(aluno))
        connection.close()

        return 'Aluno cadastrado com sucesso!'
    except mysql.connector.Error as error:
        return str(error)
    except pika.exceptions.AMQPError as error:
        return str(error)

if __name__ == '__main__':
    app.run()
