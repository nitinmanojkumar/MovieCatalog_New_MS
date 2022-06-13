package group.microservices.moviecatalogservices.SERVICES;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.microservices.moviecatalogservices.REPO.MovieCatalogREPO;
import group.microservices.moviecatalogservices.dao.CatalogItem;
import group.microservices.moviecatalogservices.dao.CustomResponseClass;

//STORED PROCEDURE
@Service
public class MovieCatalog_SERVICE {

	@Autowired
	private MovieCatalogREPO repo;

	public List<CatalogItem> findAllProductions() {
		// using the stored procedure GetAllProducts
		return repo.GetAllProducts();
	}
	
	public CatalogItem findMovieList(String movieid) {
		// using the stored procedure GetAllProducts
		return repo.getProductionname(movieid);
	}
	
	public List<CustomResponseClass> findOnlyMovies(List<Object> list) {
		List<CustomResponseClass> res=new ArrayList<CustomResponseClass>();
		CustomResponseClass objt;
		int i=1;
		for(Object var:list) {
			objt=new CustomResponseClass();
			objt.setId((String) var);
			objt.setMsg(i+"hey");
			res.add(objt);i++;
		}
		return res;
	}

}
