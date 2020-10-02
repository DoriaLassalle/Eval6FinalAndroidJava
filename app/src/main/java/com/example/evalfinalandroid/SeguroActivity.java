package com.example.evalfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evalfinalandroid.Presentador.EvalPresentador;
import com.example.evalfinalandroid.Presentador.InterfaceEvalPresentador;
import com.example.evalfinalandroid.Vista.InterfaceEvalVista;

public class SeguroActivity extends AppCompatActivity implements InterfaceEvalVista {

    private EditText propietario, precioVhe, siniestros;
    private RadioGroup grupo1, grupo2;
    private RadioButton edadA, edadB, edadC;
    private RadioButton city, sedan, suv;
    private Button btnCalcular, btnLimpiar, btnVolver;
    private TextView precioPoliza;
    private String valor, accid, age, modelo;
    ;

    private InterfaceEvalPresentador enviaPresentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seguro);

        propietario = findViewById(R.id.propietario);
        precioVhe = findViewById(R.id.valor);
        siniestros = findViewById(R.id.siniestros);
        precioPoliza = findViewById(R.id.mostrarPrecio);

        grupo1 = findViewById(R.id.radioGroup1);
        edadA = findViewById(R.id.edadA);
        edadB = findViewById(R.id.edadB);
        edadC = findViewById(R.id.edadC);
        grupo2 = findViewById(R.id.radioGroup2);
        city = findViewById(R.id.modeloA);
        sedan = findViewById(R.id.modeloB);
        suv = findViewById(R.id.modeloC);

        btnCalcular = findViewById(R.id.calcSeguro2);
        btnLimpiar = findViewById(R.id.clear2);
        btnVolver = findViewById(R.id.back2);

        enviaPresentador = new EvalPresentador(this, this);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                propietario.setText("");
                precioVhe.setText("");
                siniestros.setText("");
                precioPoliza.setText("");
                grupo1.clearCheck();
                grupo2.clearCheck();
                propietario.requestFocus();

            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volverHome = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(volverHome);
            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                precioPoliza.setText("");
                if (propietario.getText().toString().isEmpty() ||
                        precioVhe.getText().toString().isEmpty() ||
                        siniestros.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "COMPLETAR TODOS LOS DATOS",
                            Toast.LENGTH_SHORT).show();

                } else if (grupo1.getCheckedRadioButtonId() == -1 || grupo2.getCheckedRadioButtonId() == -1) {

                    Toast.makeText(getApplicationContext(), "SELECCIONAR OPCIONES",
                            Toast.LENGTH_SHORT).show();

                } else {
                    valor = precioVhe.getText().toString();
                    accid = siniestros.getText().toString();

                    int seleccion1 = grupo1.getCheckedRadioButtonId();
                    if (seleccion1 == edadA.getId()) {
                        age = "A";
                    } else if (seleccion1 == edadB.getId()) {
                        age = "B";
                    } else {
                        age = "C";
                    }

                    int seleccion2 = grupo2.getCheckedRadioButtonId();
                    if (seleccion2 == city.getId()) {
                        modelo = "AA";
                    } else if (seleccion2 == suv.getId()) {
                        modelo = "BB";
                    } else {
                        modelo = "CC";
                    }

                    enviaPresentador.vistaPresentador(valor, valor, valor, accid, age, modelo);
                }
            }
        });
    }

    @Override
    public void devuelvePresentador(double dolares, double euros, double libras, double yen,
                                    double multaFinal, double totalPoliza) {
        precioPoliza.setText(propietario.getText().toString() + ", el Precio de tu Póliza es de: " +
                String.format("%.2f", totalPoliza) + " pesos.");
    }

    @Override
    public void traeValidacionLogIn(String correcto) {

    }
}