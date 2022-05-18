package br.ufmg.coltec.e04_actionbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuCompat;
import androidx.core.view.MenuItemCompat;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnupdade = findViewById(R.id.btn_update);
        btnupdade.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        }
        );

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);

        //busca pelo searchView
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            public boolean onQueryTextSubmit(String s){
                Toast.makeText(SecondActivity.this, "Buscar o texto " + s, Toast.LENGTH_SHORT).show();
                return true;
            }
            public boolean onQueryTextChange(String s){
                return true;
            }
        });

        //compartilhamento
        MenuItem item2 = menu.findItem(R.id.action_share);
        ShareActionProvider shareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item2);

        String url = "https://api.whatsapp.com/send?phone="+31999999;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));

        //Intent intent=new Intent(Intent.ACTION_SEND);
        //intent.setType("text/*");
        //intent.putExtra(Intent.EXTRA_TEXT,"Texto para compartilhar");
        shareProvider.setShareIntent(i);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id){
            case R.id.action_refresh:
                Toast.makeText(this,"Atualizando...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                //dialog
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setIcon(R.drawable.ic_launcher_foreground);
                alertBuilder.setTitle("Info");
                alertBuilder.setMessage("App - Teste Action Bar.Desenvolvido por Samuel.");
                alertBuilder.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(),"Tchau",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = alertBuilder.create();
                dialog.show();
                break;
                case R.id.action_exit:
                //sair
                this.finishAffinity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}