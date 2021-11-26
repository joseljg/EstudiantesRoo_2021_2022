package es.joseljg.estudiantesroo_2021_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertarCurso(View view) {
        Intent intent = new Intent(this,InsertarCurso.class);
        startActivity(intent);
    }
}