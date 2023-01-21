/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author corsopd
 */
public class AppClient {
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        AppEJBRemote aejbr=(AppEJBRemote) ctx.lookup("java:global/ESPOSITOLUCAEJB/AppEJB!ejb.AppEJBRemote"); //modificato
        
        Scanner in=new Scanner(System.in);
        
        System.out.println("Inserisci tecnologia da ricercare");
        String tecnologia=in.nextLine();
        for(App a1: aejbr.FindByTecnologia(tecnologia)) {
            System.out.println(a1);
        }
        
        System.out.println("App su base volontaria");
        String v="Si";
        for(App a2: aejbr.FindByVolontarieta(v)){
            System.out.println(a2);
        }
    }
}
