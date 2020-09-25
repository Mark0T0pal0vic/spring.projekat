package spring.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.projekat.model.Roba;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long> {
	
	
}
