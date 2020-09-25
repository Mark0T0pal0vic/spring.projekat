package spring.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.projekat.model.Dokument;

@Repository
public interface DokumentRepository extends JpaRepository<Dokument, Long> {

}
