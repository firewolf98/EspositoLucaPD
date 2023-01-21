/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author corsopd
 */
@Entity
@NamedQueries({
    @NamedQuery(name="FindById",query="SELECT a FROM App a WHERE a.id= :id"),
    @NamedQuery(name="FindByVolontarieta",query="SELECT a FROM App a WHERE a.volontarieta= :volontarieta"),
    @NamedQuery(name="FindByTecnologia",query="SELECT a FROM App a WHERE a.tecnologia= :tecnologia"),
    @NamedQuery(name="FindAll",query="SELECT a FROM App a")
})
public class App implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String paese;
    private double abitanti;
    private String nome;
    private String tecnologia; //Bluetooth,Geolocalizzazione,Apple/Google,Db-3t
    private String volontarieta;
    private double download; //6440000 -> 6,44 milioni
 
    public App(String paese,double abitanti,String nome,String tecnologia,String volontarieta,double download) {
        this.paese=paese;
        this.abitanti=abitanti;
        this.nome=nome;
        this.tecnologia=tecnologia;
        this.volontarieta=volontarieta;
        this.download=download;
    }
    
    public App() {
        
    }
    
    public int getId() {
        return id;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public void setAbitanti(double abitanti) {
        this.abitanti = abitanti;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public void setVolontarieta(String volontarieta) {
        this.volontarieta = volontarieta;
    }

    public void setDownload(double download) {
        this.download = download;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPaese() {
        return paese;
    }

    public double getAbitanti() {
        return abitanti;
    }

    public String getNome() {
        return nome;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public String getVolontarieta() {
        return volontarieta;
    }

    public double getDownload() {
        return download;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof App)) {
            return false;
        }
        App other = (App) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "App{" + "id=" + id + ", paese=" + paese + ", abitanti=" + abitanti + ", nome=" + nome + ", tecnologia=" + tecnologia + ", volontarieta=" + volontarieta + ", download=" + download + '}';
    }
    
}
