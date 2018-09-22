package com.vanessamartin.web.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vanessamartin.web.languages.models.Language;
import com.vanessamartin.web.languages.repositories.LanguageRepo;

@Service
public class LanguageService {
	private final LanguageRepo lanRepo;
	
	public LanguageService(LanguageRepo languageRepository) {
		this.lanRepo = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return lanRepo.findAll();
	}
	
	public Language create(Language lan) {
		return lanRepo.save(lan);
	}
	
	public Language findLan(Long id) {
		Optional<Language> optionalLan = lanRepo.findById(id);
		if (optionalLan.isPresent()) {
			return optionalLan.get();
		}
		else {
			return null;
		}
	}
	
	public Language updateLan(Language updatedLan) {
		System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  edit service1");
	
		Optional<Language> optionalLan = lanRepo.findById(updatedLan.getId());
		System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  edit service2");
		if(optionalLan.isPresent()) {
			Language lan = optionalLan.get();
			lan.setName(updatedLan.getName());
			lan.setCreator(updatedLan.getCreator());
			lan.setCurrentVersion(updatedLan.getCurrentVersion());
			return lanRepo.save(lan);
		} else {
			return null;
		}
	}
	
	public void deleteLan(Long id) {
		System.out.println("Deleting");
		lanRepo.deleteById(id);
	}

}
