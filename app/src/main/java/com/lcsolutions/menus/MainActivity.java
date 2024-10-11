package com.lcsolutions.menus;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edtMenu,edtContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMenu = findViewById(R.id.edtMenu);
        edtContext = findViewById(R.id.edtContext);

        registerForContextMenu(edtMenu);
        registerForContextMenu(edtContext);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if (v == edtMenu){
            menu.setHeaderTitle("Contextual");
            menuInflater.inflate(R.menu.my_option_menu, menu);
        } else if (v == edtContext) {
            menu.setHeaderTitle("Editmenu ");
            menuInflater.inflate(R.menu.my_option_menu,menu);
        }

        //menuInflater.inflate(R.menu.my_option_menu, menu);

        //MenuInflater menuInflater = getMenuInflater();



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.mnuOpcion1){
            edtContext.setText("Se presiono la opcion uno del menu");
        }
        if(item.getItemId() == R.id.mnuOpcion2){
            edtContext.setText("Se presiono la opcion dos del menu");
        }
        if(item.getItemId() == R.id.mnuOpcion3){
            edtContext.setText("Se presiono la opcion tres del menu");
        }

        return true;

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        if(item.getItemId()== R.id.mnuItem1){
            edtContext.setText("Se presiono el menu opcion 1");
        }
        if(item.getItemId()== R.id.mnuItem2){
            edtContext.setText("Se presiono el menu opcion 2");
        }
        if(item.getItemId()== R.id.mnuItem4){
            edtContext.setText("Se presiono el menu opcion3");
        }
        if(item.getItemId() == R.id.item_copiar){
            Toast.makeText(this, "Se presiono copiar", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

}