package br.ufmg.coltec.e04_actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TerceiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle("Terceira Tela");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}