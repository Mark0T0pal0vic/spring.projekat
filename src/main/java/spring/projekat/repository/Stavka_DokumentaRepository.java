package spring.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.projekat.model.Stavka_Dokumenta;

@Repository
public interface Stavka_DokumentaRepository extends JpaRepository<Stavka_Dokumenta, Long>{

}
