package br.ufmg.coltec.e04_actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.atcAtualizar:

                break;
            case R.id.atcBuscar:
                break;
            case R.id.atcCompartilhar:
                break;
            case R.id.atcConfiguracoes:
                break;
            case R.id.atcSobre:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setIcon(R.drawable.about);
                alertDialog.setTitle("Sobre o aplicativo.");
                alertDialog.setMessage("Autor: Rafael Assunção Ladeira Torga");
                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                break;
            case R.id.atcSair:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}