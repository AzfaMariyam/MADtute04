package com.example.datahandlingt4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Database.DBHandler;

public class MainActivity extends AppCompatActivity {

    private Button selectall, add, signin, update, delete;
    private TextView usern, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usern = findViewById(R.id.editText);
        pw = findViewById(R.id.editText3);

        selectall = findViewById(R.id.selecta);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler newDb = new DBHandler(getApplicationContext());
                long newID = newDb.addInfo(usern.getText().toString(), pw.getText().toString());
                Toast.makeText(MainActivity.this, "Added user  User id  = " +newID, Toast.LENGTH_LONG).show();

                usern.setText(null);
                pw.setText(null);
            }
        });


        selectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler newDb = new DBHandler(getApplicationContext());
                List newID = newDb.readAllInfo();
            }
        });
    }
}