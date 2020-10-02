package com.example.evalfinalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evalfinalandroid.Presentador.EvalPresentador;
import com.example.evalfinalandroid.Presentador.InterfaceEvalPresentador;
import com.example.evalfinalandroid.Vista.InterfaceEvalVista;

public class DivisaActivity extends AppCompatActivity implements InterfaceEvalVista {

     private EditText monto;
     private TextView usd, eur, gbp, jpy;
     private Button limpiar;
     private ImageButton convert, home;
     private String montoCalcular;

     private InterfaceEvalPresentador enviaPresentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.divisa);

        monto= findViewById(R.id.monto);
        usd= findViewById(R.id.dolar);
        eur= findViewById(R.id.euro);
        gbp= findViewById(R.id.libra);
        jpy= findViewById(R.id.yen);

        home=findViewById(R.id.home);
        convert=findViewById(R.id.convertir);
        limpiar=findViewById(R.id.limpiar);

        enviaPresentador=new EvalPresentador(this, this);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volverHome = new Intent (getApplicationContext(), HomeActivity.class);
                startActivity(volverHome);
            }
        });
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monto.setText("");
                usd.setText("");
                eur.setText("");
                gbp.setText("");
                jpy.setText("");
                monto.requestFocus();
            }
        });
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (monto.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Debe ingresar un monto a calcular",
                            Toast.LENGTH_SHORT).show();
                }else{
                    montoCalcular=monto.getText().toString();

                    enviaPresentador.vistaPresentador(montoCalcular, montoCalcular, montoCalcular,
                            montoCalcular, montoCalcular,montoCalcular);
                }
            }
        });
    }
    @Override
    public void devuelvePresentador(double dolares, double euros, double libras, double yen,
                                    double multaFinal, double totalPoliza) {
        usd.setText(String.format("%.2f", dolares));
        eur.setText(String.format("%.2f",euros));
        gbp.setText(String.format("%.2f",libras));
        jpy.setText(String.format("%.2f",yen));
    }

    @Override
    public void traeValidacionLogIn(String correcto) {

    }

}