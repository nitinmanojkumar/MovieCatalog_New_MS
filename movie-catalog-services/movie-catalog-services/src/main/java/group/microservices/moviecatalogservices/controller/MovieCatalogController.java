package group.microservices.moviecatalogservices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import group.microservices.moviecatalogservices.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import group.microservices.moviecatalogservices.REPO.MovieCatalogREPO;
import group.microservices.moviecatalogservices.SERVICES.MovieCatalog_SERVICE;
import org.springframework.web.reactive.function.client.WebClient;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	MovieCatalogREPO repo;

	@Autowired// Below service class has a method that calls the STORED PROC defined in the REPO interface
	MovieCatalog_SERVICE service;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	// Get all the movies Rating
	@Value("${spring.data.ratingservice}")
	String ratingservice;
	@Value("${spring.data.movieinfoservice}")
	String movieinfoservice;


	@RequestMapping(method = RequestMethod.GET, value = "/getRatings")
	public List<CustomCatalogItem> getRatings_OfAll_Movies() {
		System.out.println(ratingservice);
		System.out.println(movieinfoservice);
		List<CatalogItem> allMovies = repo.findAll();
		List<CustomCatalogItem> movieCatalogwithRatings = new ArrayList<CustomCatalogItem>();
		System.out.println(allMovies.size());
		for (CatalogItem var : allMovies) {
			System.out.println(var.getMovieid());
			MovieInfo movieinfo = restTemplate.getForObject("http://"+movieinfoservice+":7778/movieInfo/" + var.getMovieid(),
					MovieInfo.class);
			MovieRating movierating = restTemplate.getForObject("http://"+ratingservice+":7779/movieRating/" + var.getMovieid(),
					MovieRating.class);
			movieCatalogwithRatings.add(new CustomCatalogItem(var.getProduction(), var.getMovieid(), movieinfo.getMoviename(),
					movieinfo.getMoviedesc(), String.valueOf(movierating.getRatings())));

		}
		return movieCatalogwithRatings;

	}

	// Get all the movies Rating
	@RequestMapping(method = RequestMethod.GET, value = "/getRatingsWebClient")
	public List<CustomCatalogItem> getRatings_OfAll_Movies_webClient() {

		List<CatalogItem> allMovies = repo.findAll();
		List<CustomCatalogItem> movieCatalogwithRatings = new ArrayList<CustomCatalogItem>();
		System.out.println(allMovies.size());

		return allMovies.stream().map(var -> {

			MovieInfo movieinfo=webClientBuilder.build()
					.get()
					.uri("http://"+movieinfoservice+":7778/movieInfo/" + var.getMovieid())
					.retrieve()
					.bodyToMono(MovieInfo.class)
					.block();

			MovieRating movierating=webClientBuilder.build()
					.get()
					.uri("http://"+ratingservice+":7779/movieRating/" + var.getMovieid())
					.retrieve()
					.bodyToMono(MovieRating.class)
					.block();

			return new CustomCatalogItem(var.getProduction(), movieinfo.getMoviename(),
					movieinfo.getMoviedesc(), String.valueOf(movierating.getRatings()), var.getMovieid());
		}).collect(Collectors.toList());

//		for (CatalogItem_toREPO var : allMovies) {
//			System.out.println(var.getMovieid());

//			MovieInfo movieinfo = restTemplate.getForObject("http://localhost:7778/movieInfo/" + var.getMovieid(),
//					MovieInfo.class);
//			MovieRating movierating = restTemplate.getForObject("http://localhost:7779/movieRating/" + var.getMovieid(),
//					MovieRating.class);

//			MovieInfo movieinfo=webClientBuilder.build()
//					.get()
//					.uri("http://localhost:7778/movieInfo/" + var.getMovieid())
//					.retrieve()
//					.bodyToMono(MovieInfo.class)
//					.block();
//
//			MovieRating movierating=webClientBuilder.build()
//					.get()
//					.uri("http://localhost:7779/movieRating/" + var.getMovieid())
//					.retrieve()
//					.bodyToMono(MovieRating.class)
//					.block();
//
//			movieCatalogwithRatings.add(new CatalogItem(var.getProduction(), movieinfo.getMoviename(),
//					movieinfo.getMoviedesc(), String.valueOf(movierating.getRatings()), var.getMovieid()));
//
//		}
//		return movieCatalogwithRatings;

	}

	// Get all the movies Rating
	@RequestMapping(method = RequestMethod.GET, value = "/getRatingsWebClient1")
	public ListCatalogItem getRatings_OfAll_Movies_webClient1() {

		ListOfUserRating allMovieRatings= restTemplate.getForObject("http://"+ratingservice+":7779/movieRating/getAllUserRatings",
				ListOfUserRating.class);
		ListCatalogItem listCatalogItem=new ListCatalogItem();
		List<CustomCatalogItem> movieCatalogwithRatings = new ArrayList<CustomCatalogItem>();

		movieCatalogwithRatings=allMovieRatings.getUserRating().stream().map(var -> {

			MovieInfo movieinfo=webClientBuilder.build()
					.get()
					.uri("http://"+movieinfoservice+":7778/movieInfo/" + var.getMovieid())
					.retrieve()
					.bodyToMono(MovieInfo.class)
					.block();

			CatalogItem catalogItem=webClientBuilder.build()
					.get()
					.uri("http://localhost:7777/catalog/getProduction/" + var.getMovieid())
					.retrieve()
					.bodyToMono(CatalogItem.class)
					.block();

			return new CustomCatalogItem(catalogItem.getProduction(), movieinfo.getMoviename(),
					movieinfo.getMoviedesc(), String.valueOf(var.getRatings()), var.getMovieid());
		}).collect(Collectors.toList());
		listCatalogItem.setListCatalogItem(movieCatalogwithRatings);
		return listCatalogItem;
	}

	// http://localhost:7777/catalog/getAllMovies
	@RequestMapping("/getAllMovies")
	public List<CatalogItem> getMovies() {
		return repo.findAll();
	}

	// http://localhost:7777/catalog/getMovies?productionName=Walt Disney
	@RequestMapping("/getMovies")
	public List<CatalogItem> getMoviesByProduction(@RequestParam("productionName") String productionName) {
		return repo.findAllByProduction(productionName);
	}

	// http://localhost:7777/catalog/getProduction/{movieid}
	@RequestMapping("/getProduction/{movieid}")
	public ResponseEntity<CatalogItem> getMovieByProduction(@PathVariable(value = "movieid") String movieid) {
		return new ResponseEntity<CatalogItem>(repo.findById(movieid).get(), HttpStatus.OK);
	}

	// GET Production name using MYSQL Query
	// http://localhost:7777/catalog/getProduction/{movieid}

	@RequestMapping("/getProductionname/{movieid}")
	public ResponseEntity<CatalogItem> getProductionByMovieid(@PathVariable(value = "movieid") String movieid) {
		return new ResponseEntity<CatalogItem>(service.findMovieList(movieid), HttpStatus.OK);
	}

	// STORED PROCEDURE
	// http://localhost:7777/catalog/getAllProductions
	@RequestMapping("/getAllProductions")
	@Transactional(readOnly = false)
	public ResponseEntity<List<CatalogItem>> getAllProductions() {
		// service.findCarsAfterYear() --> method invokes the STORED PROC
		return new ResponseEntity<List<CatalogItem>>(service.findAllProductions(), HttpStatus.OK);
	}

	// http://localhost:7777/catalog/getMovieAlone?productionName=Walt Disney
	@RequestMapping(method = RequestMethod.GET, value = "/getMovieAlone")
	public ResponseEntity<List<CustomResponseClass>> getMovieAlone(@RequestParam("productionName") String productionName) {
		List<CustomResponseClass> obj = new ArrayList<CustomResponseClass>();
		obj = service.findOnlyMovies(repo.returnOnlyMovies(productionName));
		return new ResponseEntity<List<CustomResponseClass>>(obj, HttpStatus.OK);
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
