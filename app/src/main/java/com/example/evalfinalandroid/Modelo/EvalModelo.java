package com.example.evalfinalandroid.Modelo;

import com.example.evalfinalandroid.Presentador.InterfaceEvalPresentador;

public class EvalModelo implements InterfaceEvalModelo {

    private int cargoAccidentes, cargoEdad;
    private double cargoValor, cargoModelo, totalPoliza;
    private String correcto;

    private InterfaceEvalPresentador devuelvePresenter, traeValidación;

    public EvalModelo(InterfaceEvalPresentador devuelvePresenter, InterfaceEvalPresentador traeValidación) {
        this.devuelvePresenter = devuelvePresenter;
        this.traeValidación = traeValidación;
    }

    @Override
    public void vistaPresentador(String montoCalcular, String montoSueldo,
                                 String valor, String accid, String age, String modelo) {
        //calculo la divisa
        int monto = Integer.parseInt(montoCalcular);
        double dolares = (monto * 0.00127059);
        double euros = (monto * 0.00108149);
        double libras = (monto * 0.000984991);
        double yen = (monto * 0.134081);


        //calculo la multa
        double sueldo = Double.parseDouble(montoSueldo);
        double multaFinal = (sueldo * 0.10);


        //calculo la poliza
        double valorAuto = Double.parseDouble(valor);             //cargo valor auto
        cargoValor = (double) (valorAuto * 0.035);

        int accidentes = Integer.parseInt(accid);                 //cargo x accidentes
        if (accidentes >= 1 && accidentes <= 3) {
            cargoAccidentes = 17;
        } else if (accidentes > 3) {
            cargoAccidentes = (17 + ((accidentes - 3) * 21));
        }

        if (age.equals("A")) {                                   //cargo por edad
            cargoEdad = 360;
        } else if (age.equals("B")) {
            cargoEdad = 240;
        } else {
            cargoEdad = 430;
        }

        if (modelo.equals("AA")) {                              //cargo por modelo
            cargoModelo = (double) (valorAuto * 0.011);
        } else if (modelo.equals("BB")) {
            cargoModelo = (double) (valorAuto * 0.012);
        } else {
            cargoModelo = (double) (valorAuto * 0.015);
        }
        totalPoliza = (cargoAccidentes + cargoEdad) + (cargoValor + cargoModelo);

        devuelvePresenter.devuelvePresentador(dolares, euros, libras, yen, multaFinal, totalPoliza);
    }

    @Override       //recibo login ingresado y el registrado y los comparo
    public void validar(String mail, String pass, String nuevoMail, String nuevoPass) {

        if (mail.equals(nuevoMail) && pass.equals(nuevoPass)) {
            correcto = "verdadero";
        } else {
            correcto = "falso";
        }
        traeValidación.traeValidacionLogIn(correcto);      //envio resultado de la validacion
    }


}//END CLASS
