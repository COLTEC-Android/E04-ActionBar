package br.ufmg.coltec.teste;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button btn_terceiraTela = this.findViewById(R.id.button2);

        btn_terceiraTela.setOnClickListener((view) -> {
            Intent terceiraTela = new Intent(SegundaTela.this, TerceiraTela.class);
            startActivity(terceiraTela);
        });

    }
}