package spring.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import spring.projekat.model.Dokument;

@Component
public interface DokumentRepositroy extends JpaRepository<Dokument, Long> {

}
