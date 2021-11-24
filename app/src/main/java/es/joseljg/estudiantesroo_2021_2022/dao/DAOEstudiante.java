package es.joseljg.estudiantesroo_2021_2022.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.joseljg.estudiantesroo_2021_2022.clases.Estudiante;

@Dao
public interface DAOEstudiante {

    @Insert
    void insert(Estudiante estudiante);

    @Delete
    void delete(Estudiante estudiante);

    @Query("DELETE FROM estudiantes")
    void deleteAll();

    @Update
    void update(Estudiante estudiante);

    @Query("SELECT * FROM estudiantes ORDER BY dni ASC")
    LiveData<List<Estudiante>> cogerTodosLosEstudiantes();

    @Query("SELECT * FROM estudiantes WHERE dni LIKE :dni1")
    LiveData<Estudiante> cogerEstudiante(String dni1);

}
