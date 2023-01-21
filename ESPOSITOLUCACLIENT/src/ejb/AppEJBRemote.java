/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author corsopd
 */
@Remote
public interface AppEJBRemote {
    public void createApp(App a);
    public void deleteApp(App a);
    public App updateApp(App a);
    public App FindById(int id);
    public List<App> FindByVolontarieta(String volontarieta);
    public List<App> FindByTecnologia(String tecnologia);
    public List<App> FindAll();
}
