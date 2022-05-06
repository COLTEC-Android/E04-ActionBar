package br.ufmg.coltec.e04_actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnParaSegundaTela = findViewById(R.id.btn_paraSegundaTela);

        btnParaSegundaTela.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

        });
    }

}