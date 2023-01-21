/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author corsopd
 */

@Singleton
@Startup
@DataSourceDefinition(
        className="org.apache.derby.jdbc.EmbeddedDataSource",
        name="jdbc/EsameDS",
        user="APP",
        password="APP",
        databaseName="EsameDB",
        properties={"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    
    @Inject
    private AppEJB aejb;
    private App a1,a2,a3;
    
    @PostConstruct
    public void createDB() {
        a1=new App("Australia",24.99,"COVIDSafe","Bluetooth","Si",6.44);
        a2=new App("Austria",8.859,"StoppCorona","Google/Apple","Si",0.6);
        a3=new App("Italia",60.36,"Immuni","Google/Apple","Si",2.2);
        
        aejb.createApp(a1);
        aejb.createApp(a2);
        aejb.createApp(a3);
    }
    
    @PreDestroy
    public void cleanDB() {
        aejb.deleteApp(a1);
        aejb.deleteApp(a2);
        aejb.deleteApp(a3);
    }
}
