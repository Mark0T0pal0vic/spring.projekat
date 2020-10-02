package spring.projekat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.projekat.model.Roba;

@Repository
public interface RobaRepository extends CrudRepository<Roba, Long> {
	
	
}
