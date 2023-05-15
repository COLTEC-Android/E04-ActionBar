package br.ufmg.coltec.e04_actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private void leaveApp(AlertDialog.Builder builder){

        AlertDialog alerta;

        builder.setTitle("Sair");
        builder.setMessage("Quer sair do Aplicativo?");
        builder.setPositiveButton("Sim, app chato do caramba", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("Não, esse app é mt legal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(SecondActivity.this, "Gostamos de você tbm :D", Toast.LENGTH_SHORT).show();
            }
        });

        alerta = builder.create();
        alerta.show();
    }

    private void aboutApp(AlertDialog.Builder builder){
        AlertDialog alerta;

        builder.setTitle("Sobre:");
        builder.setMessage("Aplicativo sobre ActionBar e suas funcionalidades");
        builder.setPositiveButton("Beleza!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //faz algo quando clica
            }
        });

        alerta = builder.create();
        alerta.show();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        switch(id){
            case R.id.actionRefresh: Toast.makeText(this, "Atualizando", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionAbout:  aboutApp(builder);

                return true;
            case R.id.actionLeave: leaveApp(builder);

                return true;

            default: return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Implementa o Menu na tela
        getMenuInflater().inflate(R.menu.second_menu, menu);

        //Busca pelo SearchView
        MenuItem item = menu.findItem(R.id.actionFind);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SecondActivity.this, "Buscando o texto: " + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //Recupera Share Provider
        MenuItem shareItem = menu.findItem(R.id.actionShare);
        ShareActionProvider shareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        // criar intent que será exibida pelo provider
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Texto para Compartilhar");

        // exibe a intent
        shareProvider.setShareIntent(intent);



        return super.onCreateOptionsMenu(menu);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Mostrar o UpNavigation na ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Button btnGoToThird = findViewById(R.id.goToThird);

        btnGoToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, TerceiraActivity.class));
            }
        });
    }
}