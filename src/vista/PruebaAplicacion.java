/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import datos.ModeloTabla;

/**
 *
 * @author krOzer
 */
public class PruebaAplicacion {

    public static void main(String[] args) {
        ModeloTabla mt = new ModeloTabla();
        interfaz v1 = new interfaz(mt);

        Thread t1 = new Thread(v1);
        t1.start();

        Thread t2 = new Thread(v1);
        t2.start();

        Thread t3 = new Thread(v1);
        t3.start();

        Thread t4 = new Thread(v1);
        t4.start();

    }
}
