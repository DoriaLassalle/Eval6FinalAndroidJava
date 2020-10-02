package com.example.evalfinalandroid.Presentador;

import com.example.evalfinalandroid.Modelo.EvalModelo;
import com.example.evalfinalandroid.Modelo.InterfaceEvalModelo;
import com.example.evalfinalandroid.Vista.InterfaceEvalVista;

public class EvalPresentador implements InterfaceEvalPresentador {

    private InterfaceEvalVista devuelveVista, traeValidacion;
    private InterfaceEvalModelo enviaModelo, envioDatos, llevarRegistro;

    public EvalPresentador(InterfaceEvalVista devuelveVista, InterfaceEvalVista traeValidacion) {
           this.devuelveVista = devuelveVista;
           this.traeValidacion= traeValidacion;

           enviaModelo = new EvalModelo(this, this);
           envioDatos=new EvalModelo(this, this);
           llevarRegistro=new EvalModelo(this, this);
    }

    //van al modelo vienen de la vista
    @Override
    public void vistaPresentador(String montoCalcular, String montoSueldo, String valor,
                                 String accid,String age,String modelo) {
        enviaModelo.vistaPresentador(montoCalcular, montoSueldo, valor, accid, age, modelo);
    }

    @Override
    public void validar(String mail, String pass, String nuevoMail, String nuevoPass) {
        envioDatos.validar(mail, pass, nuevoMail, nuevoPass);
    }


    //vuelven del modelo, van a la vista
    @Override
    public void devuelvePresentador(double dolares, double euros, double libras, double yen,
                                    double multaFinal, double totalPoliza) {
        devuelveVista.devuelvePresentador(dolares, euros, libras, yen, multaFinal, totalPoliza);
    }

    @Override
    public void traeValidacionLogIn(String correcto) {
        traeValidacion.traeValidacionLogIn(correcto);
    }

}
