package es.joseljg.estudiantesroo_2021_2022.repositories.tareas;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Callable;

import es.joseljg.estudiantesroo_2021_2022.clases.Curso;
import es.joseljg.estudiantesroo_2021_2022.repositories.CursoRepository;

public class TareaObtenerCursos implements Callable<LiveData<List<Curso>>> {
    @Override
    public LiveData<List<Curso>> call() throws Exception {
       try {
           LiveData<List<Curso>> cursos = CursoRepository.mcursoDAO.cogerTodosLosCursos();
           return cursos;
       }catch (Exception e)
       {
           return null;
       }
    }
}
