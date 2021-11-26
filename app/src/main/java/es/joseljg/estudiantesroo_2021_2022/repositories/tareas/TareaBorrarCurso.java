package es.joseljg.estudiantesroo_2021_2022.repositories.tareas;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesroo_2021_2022.clases.Curso;
import es.joseljg.estudiantesroo_2021_2022.repositories.CursoRepository;

public class TareaBorrarCurso implements Callable<Boolean> {

    private Curso c;

    public TareaBorrarCurso(Curso c) {
        this.c = c;
    }


    @Override
    public Boolean call() throws Exception {
        try {
            CursoRepository.mcursoDAO.delete(c);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
