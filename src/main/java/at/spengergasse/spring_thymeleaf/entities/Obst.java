package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Obst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bezeichnung;
    private float gewicht;
    private float preis;
    private LocalDate haltbarBis;

    //getter and setter
    public String getBezeichnung() {
        return bezeichnung;
    }
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    public float getGewicht() {
        return gewicht;
    }
    public void setGewicht(float gewicht) {
        this.gewicht = gewicht;
    }
    public float getPreis() {
        return preis;
    }
    public void setPreis(float preis) {
        this.preis = preis;
    }
    public LocalDate getHaltbarBis() {
        return haltbarBis;
    }
    public void setHaltbarBis(LocalDate haltbarBis) {
        this.haltbarBis = haltbarBis;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
