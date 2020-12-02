package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.VisitReelleEntity;
import tn.esprit.spring.entity.VisiteVirtuelleEntity;
import tn.esprit.spring.repository.VisiteReelleRepo;
import tn.esprit.spring.repository.VisiteVirtuelleRepository;

@Service

public class VisiteVirtuelleServiceImpl implements VisiteVirtuelleService{
	
	@Autowired
	VisiteVirtuelleRepository VisiteVirtuelleRepo;
	
	private static final Logger L=LogManager.getLogger(VisiteVirtuelleServiceImpl .class);

	@Override
	public List<VisiteVirtuelleEntity> retrieveAllVisitesVirtuelles() {
		List<VisiteVirtuelleEntity> VisitesVirtuelles= (List<VisiteVirtuelleEntity>) VisiteVirtuelleRepo.findAll();
		L.info(VisitesVirtuelles.toString());
		return VisitesVirtuelles;
		
	}

	@Override
	public VisiteVirtuelleEntity addVisiteVirtuelle(VisiteVirtuelleEntity V1) {
		return VisiteVirtuelleRepo.save(V1);
	}

	@Override
	public void deleteVisiteVirtuelle(Long id) {
		VisiteVirtuelleRepo.deleteById(id);
		
	}

	@Override
	public VisiteVirtuelleEntity updateVisiteVirtuelle(VisiteVirtuelleEntity V1) {
		return VisiteVirtuelleRepo.save(V1);
	}

	@Override
	public VisiteVirtuelleEntity retrieveVisiteVirtuelle(Long id) {
		return VisiteVirtuelleRepo.findById(id).orElse(null);
	}

}
