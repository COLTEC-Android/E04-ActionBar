package br.ufmg.coltec.e04_actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle("Segunda Tela");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button btn2 = findViewById(R.id.btnSegActivity);
        btn2.setOnClickListener((view -> {
            Intent intent = new Intent(SegundaActivity.this, TerceiraActivity.class);
            startActivity(intent);
        }));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem buscar = menu.findItem(R.id.atcBuscar);
        SearchView searchView = (SearchView) buscar.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(SegundaActivity.this, "Voce pesquisou: " + s, Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.atcAtualizar:
                Toast.makeText(SegundaActivity.this, "Aplicativo Atualizado!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.atcBuscar:

                break;
            case R.id.atcCompartilhar:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.setPackage("com.whatsapp");
                intent.putExtra(Intent.EXTRA_TEXT,"Texto a ser compartilhado");
                try {
                    this.startActivity(intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    ex.printStackTrace();
                    Toast.makeText(SegundaActivity.this, "Erro ao abrir o Whatsapp!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.atcConfiguracoes:
                Toast.makeText(SegundaActivity.this, "Clicou nas cofnigurações", Toast.LENGTH_SHORT).show();
                break;
            case R.id.atcSobre:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setIcon(R.drawable.about);
                alertDialog.setTitle("Sobre o aplicativo.");
                alertDialog.setMessage("Autor: Rafael Assunção \nAplicativo E04 - Action Bar\nData Criaçao 05/05/22");
                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(SegundaActivity.this, "OK", Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
                break;
            case R.id.atcSair:
                finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }
}
