/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.enterprise.event.Observes;

/**
 *
 * @author corsopd
 */
public class Notify {
    public void PrintEvent(@Observes App a) {
        System.out.println("Numero di download aggiornato");
        double x=(a.getAbitanti()*60)/100;
        if(a.getDownload()>=x) {
            System.out.println("Raggiunta percentuale di utilizzo del 60%");
        }
    }
}
