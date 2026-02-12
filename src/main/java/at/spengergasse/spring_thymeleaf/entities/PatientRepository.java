package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//interface wird automatisch von springboot implementiert, esmuss nur unten das angegeben werden was unten steht
@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {//jpaRepository<EntityKlasse, Typ des Primärschlüssels>
    //anwendung macht auch automatisch methoden mit save, findAll, deleteById, findById, etc.
    //wichtig ist das @Repository
}
