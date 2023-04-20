Como executar o dotnet 5.0 no VS Code com a versão dotnet 6.0:

Para executar um projeto .NET 5.0 no Visual Studio Code com a versão do SDK .NET 6.0 instalada em seu computador, siga os seguintes passos:

Verifique se você tem o SDK .NET 5.0 instalado em seu computador. Se não tiver, baixe-o em https://dotnet.microsoft.com/download/dotnet/5.0.

Abra o Visual Studio Code e navegue até o diretório do projeto que você deseja executar.

Abra o terminal do Visual Studio Code e execute o seguinte comando para mudar para a versão 5.0 do SDK:

> dotnet new globaljson --sdk-version 5.0.100 (Se atentar a versão final após o 5.0 no global.json em "sdk": {
    "version": "5.0."
  })

Em seguida, execute o seguinte comando para restaurar as dependências do projeto:

> dotnet restore

Agora, você pode executar o projeto com o seguinte comando:

> dotnet run