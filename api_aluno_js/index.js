const express = require('express');
const bodyParser = require('body-parser');
const axios = require('axios');
const https = require('https');

const app = express();
const PORT = 3000;

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.post('/alunos', async (req, res) => {
  const { id, idCurso, nome, email } = req.body;

  // Usando Axios para fazer a integração com a API em C# para verificar se o curso foi cadastrado
  try {
    const response = await
    axios.get(`http://localhost:5000/api/curso/${idCurso}`, {
        httpsAgent: new https.Agent({
        rejectUnauthorized: false
        })
    });
    if (!response.data) {
      throw new Error('Curso não encontrado');
    }

    // Se o curso foi cadastrado, cria o objeto aluno
    const aluno = { id, idCurso, nome, email };

    // Retorna o aluno criado
    res.status(201).json(aluno);
  } catch (error) {
    // Se o curso não foi cadastrado, retorna o erro
    res.status(400).json({ message: error.message });
  }
});

app.get('/alunos', (req, res) => {
  // Aqui você pode criar um array para armazenar os alunos cadastrados
  // ou simplesmente retornar um array vazio, já que os alunos não precisam ser guardados em banco de dados
  const alunos = [];

  // Retorna o array com os alunos cadastrados
  res.status(200).json(alunos);
});

app.get('/alunos/:id', (req, res) => {
  const id = req.params.id;

  // Aqui você pode buscar o aluno pelo ID no array criado no passo 9 ou simplesmente retornar um aluno padrão
  //const aluno = { id: 1, idCurso: 1, nome: 'João', email: 'joao@gmail.com' };

  // Retorna o aluno encontrado ou um erro caso não exista um aluno com o ID informado
  if (aluno.id === id) {
    res.status(200).json(aluno);
  } else {
    res.status(404).json({ message: 'Aluno não encontrado' });
  }
});

app.listen(PORT, () => {
  console.log(`API de cadastro de alunos rodando na porta ${PORT}`);
});

