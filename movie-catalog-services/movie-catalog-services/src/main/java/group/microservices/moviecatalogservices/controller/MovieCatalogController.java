package group.microservices.moviecatalogservices.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import group.microservices.moviecatalogservices.REPO.MovieCatalogREPO;
import group.microservices.moviecatalogservices.SERVICES.MovieCatalog_SERVICE;
import group.microservices.moviecatalogservices.dao.CatalogItem;
import group.microservices.moviecatalogservices.dao.CatalogItem_toREPO;
import group.microservices.moviecatalogservices.dao.MovieInfo;
import group.microservices.moviecatalogservices.dao.MovieRating;
import group.microservices.moviecatalogservices.dao.ResponseClass;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	MovieCatalogREPO repo;
	@Autowired
	// Below service class has a method that calls the STORED PROC defined in the
	// REPO interface
	MovieCatalog_SERVICE service;

	// Get all the movies Rating
	@RequestMapping(method = RequestMethod.GET, value = "/getRatings")
	public List<CatalogItem> getRatings_OfAll_Movies() {
		RestTemplate template = new RestTemplate();
		List<CatalogItem_toREPO> allMovies = repo.findAll();
		List<CatalogItem> movieCatalogwithRatings = new ArrayList<CatalogItem>();
		System.out.println(allMovies.size());
		for (CatalogItem_toREPO var : allMovies) {
			System.out.println(var.getMovieid());
			MovieInfo movieinfo = template.getForObject("http://localhost:7778/movieInfo/" + var.getMovieid(),
					MovieInfo.class);
			MovieRating movierating = template.getForObject("http://localhost:7779/movieRating/" + var.getMovieid(),
					MovieRating.class);
			movieCatalogwithRatings.add(new CatalogItem(var.getProduction(), movieinfo.getMoviename(),
					movieinfo.getMoviedesc(), String.valueOf(movierating.getRatings()), var.getMovieid()));

		}
		return movieCatalogwithRatings;

	}

	// http://localhost:7777/catalog/getAllMovies
	@RequestMapping("/getAllMovies")
	public List<CatalogItem_toREPO> getMovies() {
		return repo.findAll();

	}

	// http://localhost:7777/catalog/getMovies?productionName=Walt Disney
	@RequestMapping("/getMovies")
	public List<CatalogItem_toREPO> getMoviesByProduction(@RequestParam("productionName") String productionName) {
		return repo.findAllByProduction(productionName);
	}

	// http://localhost:7777/catalog/getProduction/{movieid}
	@RequestMapping("/getProduction/{movieid}")
	public ResponseEntity<CatalogItem_toREPO> getMovieByProduction(@PathVariable(value = "movieid") String movieid) {
		return new ResponseEntity<CatalogItem_toREPO>(repo.findById(movieid).get(), HttpStatus.OK);
	}

	// GET Production name using MYSQL Query
	// http://localhost:7777/catalog/getProduction/{movieid}

	@RequestMapping("/getProductionname/{movieid}")
	public ResponseEntity<CatalogItem_toREPO> getProductionByMovieid(@PathVariable(value = "movieid") String movieid) {
		return new ResponseEntity<CatalogItem_toREPO>(service.findMovieList(movieid), HttpStatus.OK);
	}

	// STORED PROCEDURE
	// http://localhost:7777/catalog/getAllProductions
	@RequestMapping("/getAllProductions")
	@Transactional(readOnly = false)
	public ResponseEntity<List<CatalogItem_toREPO>> getAllProductions() {
		// service.findCarsAfterYear() --> method invokes the STORED PROC
		return new ResponseEntity<List<CatalogItem_toREPO>>(service.findAllProductions(), HttpStatus.OK);
	}

	// http://localhost:7777/catalog/getMovieAlone?productionName=Walt Disney
	@RequestMapping(method = RequestMethod.GET, value = "/getMovieAlone")
	public ResponseEntity<List<ResponseClass>> getMovieAlone(@RequestParam("productionName") String productionName) {
		List<ResponseClass> obj = new ArrayList<ResponseClass>();
		obj = service.findOnlyMovies(repo.returnOnlyMovies(productionName));
		return new ResponseEntity<List<ResponseClass>>(obj, HttpStatus.OK);
	}

}



//@RequestMapping(method = RequestMethod.GET, value = "/{userid}")
//public List<CatalogItem> getCatalog(@PathVariable(value = "userid") String userid) {
//	RestTemplate template = new RestTemplate();
//	List<MovieRating> movierating = Arrays.asList(new MovieRating("1234", 4), new MovieRating("5678", 5));
//	return movierating.stream().map(rating -> {
//		MovieInfo movieinfo = template.getForObject("http://localhost:7778/movieInfo/" + rating.getMovieid(),
//				MovieInfo.class);
//		return new CatalogItem(movieinfo.getName(), "Desc", rating.getRatings());
//	}).collect(Collectors.toList());
//}
