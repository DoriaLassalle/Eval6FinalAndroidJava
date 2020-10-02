package com.example.evalfinalandroid.Modelo;

public interface InterfaceEvalModelo {

                    //recibo del presentador, que viene con los datos de la vista
    void vistaPresentador(String montoCalcular, String montoSueldo,
                          String valor,String accid,String age,String modelo);

    void validar(String mail, String pass, String nuevoMail, String nuevoPass);


}
