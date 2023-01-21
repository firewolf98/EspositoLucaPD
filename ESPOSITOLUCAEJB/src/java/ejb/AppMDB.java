/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author corsopd
 */
@MessageDriven(mappedName="jms/javaee7/Topic")
public class AppMDB implements MessageListener {
    
    @Inject
    private AppEJB aejb;
    
    @Inject
    private Event<App> evento;
    
    @Override
    public void onMessage(Message message) {
        try{
            App a=message.getBody(App.class);
            App a1=aejb.FindById(a.getId());
            a1.setDownload(a.getDownload());
            a1=aejb.updateApp(a1);
            evento.fire(a1);
        } catch (JMSException ex) {
            Logger.getLogger(AppMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
