import express from 'express';
import { router } from '../config/routes';

const app = express();

app.use(express.json());
app.use(router);

app.listen(3000, () => {
    console.clear(); //Sempre limpa o console antes de mostrar a aplicação rodando
    console.log("Aplicação rodando na porta 3000");
});
