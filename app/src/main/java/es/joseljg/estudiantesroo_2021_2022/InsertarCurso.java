package es.joseljg.estudiantesroo_2021_2022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import es.joseljg.estudiantesroo_2021_2022.clases.Curso;
import es.joseljg.estudiantesroo_2021_2022.viewModel.CursoViewModel;

public class InsertarCurso extends AppCompatActivity {

    private EditText edt_ins_curso = null;
    private EditText edt_ins_descripcion = null;
    CursoViewModel mCursoViewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_curso);
        edt_ins_curso = (EditText) findViewById(R.id.edt_ins_curso);
        edt_ins_descripcion = (EditText) findViewById(R.id.edt_ins_descripcion);
        mCursoViewModel = new ViewModelProvider(this).get(CursoViewModel.class);
    }

    public void addCurso(View view) {
        String nombrec = String.valueOf(edt_ins_curso.getText());
        String descripcionc = String.valueOf(edt_ins_descripcion.getText());
        //---------------------------------------------------------------------
        boolean error = false;
        if(nombrec.isEmpty())
        {
            edt_ins_curso.setError("debes escribir un id del curso");
            error = true;
        }
        if(descripcionc.isEmpty())
        {
            edt_ins_descripcion.setError("debes escribir la descripcion");
            error = true;
        }
        if(error)
        {
            return;
        }
        //----------------------------------------------------------------------
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("de verdad quieres guardar el curso?");
        alerta1.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Curso c = new Curso(nombrec, descripcionc);
                boolean insercionOK = mCursoViewModel.insertarCurso(c);
                mostrarToast(insercionOK);
            }
        });
        alerta1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alerta1.show();
        //----------------------------------------------------------------------
    }

    private void mostrarToast(boolean insercionOK) {
        if(insercionOK)
        {
            Toast.makeText(this,"curso guardado correctamente", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"no se pudo guardar el curso", Toast.LENGTH_LONG).show();
        }
    }
}