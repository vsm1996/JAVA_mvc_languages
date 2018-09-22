package com.vanessamartin.web.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.vanessamartin.web.languages.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long> {
	List<Language> findAll();
	List<Language> findByNameContaining(String search);
	List<Language> findByCreatorContaining(String search);
}
