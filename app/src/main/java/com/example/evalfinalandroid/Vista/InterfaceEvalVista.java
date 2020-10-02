package com.example.evalfinalandroid.Vista;

public interface InterfaceEvalVista {

                     //recibo del presentador que viene del modelo con resultados para mostrar
    void devuelvePresentador(double dolares, double euros, double libras, double yen,
                             double multaFinal, double totalPoliza);

    void traeValidacionLogIn(String correcto);

}
