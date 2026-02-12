package at.spengergasse.spring_thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot application startet ein framework und sucht alle klassen die mit speziellen annotations versehen sind (zB diese hier)
//und erstelle von diesen klassen instanzen
//sie findet aber nur klassen die im selben package oder in einem untergeordneten package liegen
//system öffnet und erstellt automatisch eine datenbankverbindung zu einer in-memory datenbank
//konfigurationsdatei: application.properties (in resources) -> hier können wir die datenbankverbindung konfigurieren
//dort kann auch port geändert werden mit zB server.port=8081
@SpringBootApplication
public class SpringThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafApplication.class, args);
    }

}
