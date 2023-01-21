/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Scanner;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author corsopd
 */
public class JMSProducer {
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic=(Destination) ctx.lookup("jms/javaee7/Topic");
        
        try(JMSContext jmsc=cf.createContext()) {
            App a=new App();
            Scanner in=new Scanner(System.in);
            System.out.println("Id dell'app da aggiornare");
            int id=in.nextInt();
            a.setId(id);
            //Il numero di download va inserito in double, esempio: 6600000 -> 6.6
            System.out.println("Nuovo numero di download");
            double d=in.nextDouble();
            a.setDownload(d);
            jmsc.createProducer().send(topic,a);
        }
    }
}
