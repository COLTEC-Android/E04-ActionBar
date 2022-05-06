package br.ufmg.coltec.teste;

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
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_segundaTela = this.findViewById(R.id.button1);

        btn_segundaTela.setOnClickListener((view) -> {
            Intent segundaTela = new Intent(MainActivity.this, SegundaTela.class);
            startActivity(segundaTela);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(MainActivity.this, "Buscar o texto: " + s, Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider shareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        intent.putExtra(Intent.EXTRA_TEXT, "Texto para Compartilhar");

        shareProvider.setShareIntent(intent);

            return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_search:
                Toast.makeText(this, "Clicou no search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_refresh:
                Toast.makeText(this, "Clicou no refresh", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Clicou no settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_exit:
                finish();
                System.exit(0);
                return true;
            case R.id.action_about:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

                alertBuilder.setIcon(R.drawable.ic_launcher_foreground);
                alertBuilder.setTitle("E04-ActionBar");
                alertBuilder.setMessage("informações do aplicativo e Desenvolvedor: Gabriel Vieira Coltec - UFMG, Atividades E04 Android Studio ActionBar");

                alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(), "Você saiu de About", Toast.LENGTH_LONG).show();
                    }
                });


                AlertDialog dialog = alertBuilder.create();
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}