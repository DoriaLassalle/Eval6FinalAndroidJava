package com.example.evalfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evalfinalandroid.Presentador.EvalPresentador;
import com.example.evalfinalandroid.Presentador.InterfaceEvalPresentador;
import com.example.evalfinalandroid.Vista.InterfaceEvalVista;

public class MainActivity extends AppCompatActivity implements InterfaceEvalVista {
    private EditText email, password;
    private Button btnEntrar, btnAbout, btnRegistrarse;
    public int intentos = 0;
    private String accesoPerm;

    private InterfaceEvalPresentador envioDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnEntrar = findViewById(R.id.entrar);
        btnAbout = findViewById(R.id.about);
        btnRegistrarse = findViewById(R.id.registrarse);

        envioDatos=new EvalPresentador(this, this);

        final String nuevoMail=getIntent().getStringExtra("correo");
        final String nuevoPass=getIntent().getStringExtra("clave");

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irAbout = new Intent(getApplicationContext(), About.class);
                startActivity(irAbout);
            }
        });
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrar = new Intent(getApplicationContext(), Registro.class);
                startActivity(registrar);
            }
        });

        while (intentos == 0) {
            btnEntrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (intentos < 3) {
                        if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "COMPLETE AMBOS CAMPOS",
                                    Toast.LENGTH_SHORT).show();

                        } else if (!email.getText().toString().contains("@")) {
                            Toast.makeText(getApplicationContext(), "INGRESE UN EMAIL VÁLIDO",
                                    Toast.LENGTH_SHORT).show();

                        } else if (password.getText().toString().length() < 8 || password.getText().
                                toString().length() > 8) {
                            Toast.makeText(getApplicationContext(), "Su contraseña debe tener 8 dígitos",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            String mail=email.getText().toString();
                            String pass=password.getText().toString();

                            envioDatos.validar(mail, pass, nuevoMail, nuevoPass);

                            if(accesoPerm.equals("si")) {
                                Intent irHome = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(irHome);
                            }else {
                                String msg="DATOS INCORRECTOS O NO SE HA REGISTRADO";
                                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                            }
                        }
                        intentos++;

                    } else {
                        Toast.makeText(getApplicationContext(), "CUENTA BLOQUEADA POR SEGURIDAD!",
                                Toast.LENGTH_SHORT).show();
                    }

                }//END ON CLICK
            });

            intentos++;
        }//END WHILE

    } //END ON CREATE

    @Override
    public void traeValidacionLogIn(String correcto){
        if(correcto.equals("verdadero")){
            accesoPerm="si";
        }else {
            accesoPerm="no";
        }

    }@Override
    public void devuelvePresentador(double dolares, double euros, double libras, double yen, double multaFinal, double totalPoliza) {

    }

}// END CLASS