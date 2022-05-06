package br.ufmg.coltec.e04_actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button btnParaTerceiraTela = findViewById(R.id.btn_paraTerceraTela);

        btnParaTerceiraTela.setOnClickListener((view) -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);

        });


    }
}