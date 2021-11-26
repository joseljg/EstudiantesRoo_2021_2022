package es.joseljg.estudiantesroo_2021_2022.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import es.joseljg.estudiantesroo_2021_2022.clases.Curso;
import es.joseljg.estudiantesroo_2021_2022.dao.DAOCurso;
import es.joseljg.estudiantesroo_2021_2022.repositories.tareas.TareaActualizarCurso;
import es.joseljg.estudiantesroo_2021_2022.repositories.tareas.TareaBorrarCurso;
import es.joseljg.estudiantesroo_2021_2022.repositories.tareas.TareaInsertarCurso;
import es.joseljg.estudiantesroo_2021_2022.repositories.tareas.TareaObtenerCursos;
import es.joseljg.estudiantesroo_2021_2022.roomdatabase.InstitutoRoomDatabase;

public class CursoRepository {
    public static DAOCurso mcursoDAO;
    public LiveData<List<Curso>> mAllCursos;

    public CursoRepository(Application application) {
        InstitutoRoomDatabase db = InstitutoRoomDatabase.getDatabase(application);
        mcursoDAO = db.cursoDAO();
        mAllCursos = mcursoDAO.cogerTodosLosCursos();
    }
    //-------------------------------------------------------------
    public LiveData<List<Curso>> getAllCursos() {
        return mAllCursos;
    }
    //-------------------------------------------------------------
    public static boolean insertarCurso(Curso c) {
        FutureTask t = new FutureTask(new TareaInsertarCurso(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }

    //---------------------------------------------------------------------------

    public static LiveData<List<Curso>> obtenerCursos()
    {
        LiveData<List<Curso>> cursosDevueltos = null;
        FutureTask t = new FutureTask (new TareaObtenerCursos());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            cursosDevueltos= (LiveData<List<Curso>>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cursosDevueltos;
    }
    //---------------------------------------------------------------------------
    public static boolean   borrarCurso(Curso c) {
        FutureTask t = new FutureTask(new TareaBorrarCurso(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }
    //---------------------------------------------------------------------------

    public static boolean actualizarCurso(Curso c) {
        FutureTask t = new FutureTask(new TareaActualizarCurso(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try {
            actualizadoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return actualizadoOK;
        }
    }

    //-----------------------------------------------------------------------------------------


}
