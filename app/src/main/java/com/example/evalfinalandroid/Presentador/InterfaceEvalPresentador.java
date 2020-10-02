package com.example.evalfinalandroid.Presentador;

public interface InterfaceEvalPresentador {

                    //llevo al modelo, vengo de la vista
    void vistaPresentador(String montoCalcular, String montoSueldo,
                          String valor,String accid,String age,String modelo);

    void validar(String mail, String pass, String nuevoMail, String nuevoPass);


                  //devuelvo al presentador para la vista, vengo del modelo
    void devuelvePresentador(double dolares, double euros, double libras, double yen,
                             double multaFinal, double totalPoliza);

    void traeValidacionLogIn(String correcto);

}
