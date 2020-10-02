package com.example.evalfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evalfinalandroid.Presentador.EvalPresentador;
import com.example.evalfinalandroid.Presentador.InterfaceEvalPresentador;
import com.example.evalfinalandroid.Vista.InterfaceEvalVista;

public class MultaActivity extends AppCompatActivity implements InterfaceEvalVista {

    private EditText nombre, rut, sueldo;
    private TextView precioMulta;
    private Button  btnBack, btnCalc, btnClear;
    private String montoSueldo;

    private InterfaceEvalPresentador enviaPresentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multa);

        nombre=findViewById(R.id.nombre);
        rut=findViewById(R.id.rut);
        sueldo=findViewById(R.id.sueldo);
        precioMulta=findViewById(R.id.aPagar);
        btnBack=findViewById(R.id.back);
        btnCalc=findViewById(R.id.calcular);
        btnClear=findViewById(R.id.clear);

        enviaPresentador=new EvalPresentador(this, this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver= new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(volver);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre.setText("");
                rut.setText("");
                sueldo.setText("");
                precioMulta.setText("");
                nombre.requestFocus();

            }
        });
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombre.getText().toString().isEmpty() || rut.getText().toString().isEmpty() ||
                        sueldo.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "COMPLETE TODOS LOS DATOS",
                            Toast.LENGTH_SHORT).show();
                } else {
                    montoSueldo = sueldo.getText().toString();

                    enviaPresentador.vistaPresentador(montoSueldo, montoSueldo, montoSueldo,
                            montoSueldo, montoSueldo, montoSueldo);
                }
            }
        });

    }
    @Override
    public void devuelvePresentador(double dolares, double euros, double libras, double yen,
                                    double multaFinal, double totalPoliza) {
        precioMulta.setText(String.format("%.2f",multaFinal));
    }

    @Override
    public void traeValidacionLogIn(String correcto) {

    }

}