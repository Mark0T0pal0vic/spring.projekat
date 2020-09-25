package spring.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import spring.projekat.model.Stavka_Dokumenta;

@Component
public interface Stavka_DokumentaRepository extends JpaRepository<Stavka_Dokumenta, Long>{

}
