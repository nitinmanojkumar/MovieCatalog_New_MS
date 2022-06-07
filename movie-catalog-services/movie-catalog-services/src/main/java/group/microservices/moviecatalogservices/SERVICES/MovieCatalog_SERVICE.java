package group.microservices.moviecatalogservices.SERVICES;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group.microservices.moviecatalogservices.REPO.MovieCatalogREPO;
import group.microservices.moviecatalogservices.dao.CatalogItem_toREPO;
import group.microservices.moviecatalogservices.dao.ResponseClass;

//STORED PROCEDURE
@Service
public class MovieCatalog_SERVICE {

	@Autowired
	private MovieCatalogREPO repo;

	public List<CatalogItem_toREPO> findAllProductions() {
		// using the stored procedure GetAllProducts
		return repo.GetAllProducts();
	}
	
	public CatalogItem_toREPO findMovieList(String movieid) {
		// using the stored procedure GetAllProducts
		return repo.getProductionname(movieid);
	}
	
	public List<ResponseClass> findOnlyMovies(List<Object> list) {
		List<ResponseClass> res=new ArrayList<ResponseClass>();
		ResponseClass objt;
		int i=1;
		for(Object var:list) {
			objt=new ResponseClass();
			objt.setId((String) var);
			objt.setMsg(i+"hey");
			res.add(objt);i++;
		}
		return res;
	}

}
