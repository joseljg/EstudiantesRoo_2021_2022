package es.joseljg.estudiantesroo_2021_2022.repositories.tareas;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesroo_2021_2022.clases.Curso;
import es.joseljg.estudiantesroo_2021_2022.repositories.CursoRepository;

public class TareaActualizarCurso implements Callable<Boolean> {

    private Curso c;

    public TareaActualizarCurso(Curso c) {
        this.c = c;
    }


    @Override
    public Boolean call() throws Exception {
        try {
            CursoRepository.mcursoDAO.update(c);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
