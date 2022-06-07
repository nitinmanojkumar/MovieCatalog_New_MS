package group.microservices.moviecatalogservices.REPO;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.microservices.moviecatalogservices.dao.CatalogItem_toREPO;
import group.microservices.moviecatalogservices.dao.ResponseClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//@Repository
public class MovieREPOCustomerQueryIMPLEMENTATION implements MovieREPOCustomQuery {

	@Autowired
	MovieCatalogREPO repo;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CatalogItem_toREPO> findAllByProduction(String productionName) {
		List<CatalogItem_toREPO> allItems = repo.findAll();
		List<CatalogItem_toREPO> allMoviesByProduction = new ArrayList<>();
		for (CatalogItem_toREPO movie : allItems) {
			if (movie.getMovieid().equalsIgnoreCase(productionName)) {
				allMoviesByProduction.add(movie);
			}
		}
		return allMoviesByProduction;
	}


}
