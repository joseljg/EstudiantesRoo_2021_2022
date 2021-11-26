package es.joseljg.estudiantesroo_2021_2022.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import es.joseljg.estudiantesroo_2021_2022.clases.Curso;
import es.joseljg.estudiantesroo_2021_2022.repositories.CursoRepository;

public class CursoViewModel extends AndroidViewModel {

    private CursoRepository mRepository;
    private LiveData<List<Curso>> mAllCursos;


    public CursoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CursoRepository(application);
        mAllCursos = mRepository.getAllCursos();
    }

    public boolean insertarCurso(Curso c)
    {
        boolean insercionOK = mRepository.insertarCurso(c);
        return insercionOK;
    }

    public boolean borrarCurso(Curso c)
    {
        boolean borrarOK = mRepository.borrarCurso(c);
        return borrarOK;
    }

    public boolean actualizarCurso(Curso c)
    {
        boolean actualizarOK = mRepository.actualizarCurso(c);
        return actualizarOK;
    }

}
