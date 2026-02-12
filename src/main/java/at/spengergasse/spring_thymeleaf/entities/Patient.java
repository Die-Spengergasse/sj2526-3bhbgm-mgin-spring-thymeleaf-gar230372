package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

//entity klasse
//in-memory datenbank erstellt automatisch eine tabelle mit dem namen der klasse (hier: patient) und spalten mit den namen der attribute (hier: id, name, birth)
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK; automatisch generiert
    private int id;

    private String name;
    private LocalDate birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}
