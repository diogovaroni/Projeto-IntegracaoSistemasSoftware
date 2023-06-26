import { Router } from "express";
import { CursoController } from "../controllers/curso.controller";


const router: Router = Router();

//Produto
router.get("/curso", new CursoController().list);
router.get("/curso/:idCurso", new CursoController().find);
router.post("/curso", new CursoController().create);
router.delete("/curso/:idCurso", new CursoController().delete);
router.put("/curso", new CursoController().update);

export { router };


