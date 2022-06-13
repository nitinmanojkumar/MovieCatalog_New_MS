package group.microservices.moviecatalogservices.REPO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import group.microservices.moviecatalogservices.dao.CatalogItem;

//Method needs NO further modification should alone be provided here
@Repository
public interface MovieCatalogREPO extends JpaRepository<CatalogItem, String>, MovieREPOCustomQuery {

	// Calling existing stored procedure in mysql
	@Procedure
	List<CatalogItem> GetAllProducts();

	// Query that doesnt need any implementation
	@Query(value = "select * from movielist n where n.movieid = ?1",nativeQuery = true)
	CatalogItem getProductionname(String movieid);
	
	// Query that doesnt need any implementation however if we want to enhance we still can do it in the SERVICE package
	@Query(value = "select movieid from movielist n where n.production = ?1",nativeQuery = true)
	List<Object> returnOnlyMovies(String productionName);

}
