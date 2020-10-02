package com.example.evalfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity  {

    private Button btnRegistrar, btnComenzar;
    private EditText etMail, etPass;
    private String correo, clave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        btnRegistrar=findViewById(R.id.save);
        btnComenzar=findViewById(R.id.home3);

        etMail=findViewById(R.id.etMail);
        etPass=findViewById(R.id.etPass);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 correo=etMail.getText().toString();
                clave=etPass.getText().toString();

                Toast.makeText(getApplicationContext(), "DATOS GUARDADOS CORRECTAMENTE",
                        Toast.LENGTH_SHORT).show();

            }
        });
        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent comenzar= new Intent(getApplicationContext(), MainActivity.class);
                comenzar.putExtra("correo", correo);
                comenzar.putExtra("clave", clave);
                startActivity(comenzar);
            }
        });
    }


}