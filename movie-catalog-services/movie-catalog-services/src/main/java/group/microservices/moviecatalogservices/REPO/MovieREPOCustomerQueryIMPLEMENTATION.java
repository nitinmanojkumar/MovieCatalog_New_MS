package group.microservices.moviecatalogservices.REPO;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import group.microservices.moviecatalogservices.dao.CatalogItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//@Repository
public class MovieREPOCustomerQueryIMPLEMENTATION implements MovieREPOCustomQuery {

	@Autowired
	MovieCatalogREPO repo;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CatalogItem> findAllByProduction(String productionName) {
		List<CatalogItem> allItems = repo.findAll();
		List<CatalogItem> allMoviesByProduction = new ArrayList<>();
		for (CatalogItem movie : allItems) {
			if (movie.getMovieid().equalsIgnoreCase(productionName)) {
				allMoviesByProduction.add(movie);
			}
		}
		return allMoviesByProduction;
	}


}
