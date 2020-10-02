package spring.projekat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.projekat.model.Dokument;

@Repository
public interface DokumentRepository extends CrudRepository<Dokument, Long> {

}
