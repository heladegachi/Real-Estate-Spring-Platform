package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.AnnoncePosition;

public interface AnnPositionService {

	List<AnnoncePosition> retrieveAllAnnoncePositions();

	AnnoncePosition addAnnoncePosition(AnnoncePosition r);

	AnnoncePosition updateAnnoncePosition(AnnoncePosition r);

	AnnoncePosition getAnnoncePosByAnnId(Long annonceId);

}
