package spring.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import spring.projekat.model.Roba;

@Component
public interface RobaRepository extends JpaRepository<Roba, Long> {
	
	
}
