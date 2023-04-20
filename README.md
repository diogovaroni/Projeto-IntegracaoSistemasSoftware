WEB API - ASP.NET 5.0 - VS Code
ALUNO: DANIEL DE OLIVEIRA LAMBERG
ALUNO: DIOGO VARONI DE MOURA
ALUNO: GABRIEL TAVARES DOS SANTOS
TURMA: INTEGRAÇÃO DE SISTEMAS DE SOFTWARE - QUINTA-FEIRA - 19:00 - 21:50
DOCUMENTAÇÃO SOBRE O PROJETO DE WEB API
	O nosso sistema consiste em um cadastro de cursos em uma escola e a matrícula de alunos nesses cursos. Ao fazer a matrícula, será gerado um boleto que irá para o e-mail do aluno. A aplicação de cadastro de cursos fará uma integração com o banco de dados MySQL. 
	
Passo a passo
1° Criou-se o projeto no VS Code com o comando:
dotnet new webapi -n api_curso_cs 

2° Abriu-se o terminal no VS Code com o comando para acessar o projeto criado:
cd api_curso_ts

3° Dentro do projeto, criou-se os diretórios:
Models
Controllers
Data

4° Dentro da Model:
Criou-a classe “Curso.cs”

5° Dentro da Controller:
Criou-se a classe “CursoController.cs”

6° Dentro da Data:
Criou-se a classe “CursoContext.cs”

 7° Configurando o Banco de Dados:
Executou-se no terminal o comando: “dotnet add package MySQL.Data.EntityFrameworkCore"

 8° Em appsettings.json, configurou-se o caminho:
{
  "ConnectionStrings": {
    "DefaultConnection": "server=localhost;port=3306;database=cursos;user id=root;password=SENHA"
  },

9° No MYSQL, criou-se o banco:
create database cursos;
use cursos;
create table cursos(
id int,
nome varchar(40),
nivel varchar(50)
);
select * from cursos;

10° Para o funcionamento do “Startup.cs”, instalou o dotnet versão 5.0. No VS Code dotnet versão 6.0 o Startup não vem configurado.
Obs: Caso tenha somente a versão dotnet versão 6.0, realize os procedimentos:

Como executar o dotnet 5.0 no VS Code com a versão dotnet 6.0:

Para executar um projeto .NET 5.0 no Visual Studio Code com a versão do SDK .NET 6.0 instalada em seu computador, siga os seguintes passos:

Verifique se você tem o SDK .NET 5.0 instalado em seu computador. Se não tiver, baixe-o em https://dotnet.microsoft.com/download/dotnet/5.0.

Abra o Visual Studio Code e navegue até o diretório do projeto que você deseja executar.

Abra o terminal do Visual Studio Code e execute o seguinte comando para mudar para a versão 5.0 do SDK:
> dotnet new globaljson --sdk-version 5.0.100 

(Se atentar a versão final após o 5.0 no global.json em "sdk": {
    "version": "5.0."
  })
  
Em seguida, execute o seguinte comando para restaurar as dependências do projeto:

> dotnet restore

Agora, você pode executar o projeto com o seguinte comando:

> dotnet run
11° Será criado um arquivo chamado global.json

Verifique o seu SDK do dotnet:
{
  "sdk": {
    "version": "5.0.408"
  }
}

Atualize o final “5.0. “pois ao executar o comando dotnet new globaljson --sdk-version 5.0.100 irá trazer a versão 5.0.100 e conforme você instalar o dotnet 5, verifique a versão da sua SDK com o comando: dotnet restore
12° Instalou-se o Swashbuckle com o comando:

dotnet add package Swashbuckle.AspNetCore

13° Após o comando executado, no navegador de internet digitou o seguinte caminho:

https://localhost:5001/swagger/index.html

14° Com isso é possível testar a API


