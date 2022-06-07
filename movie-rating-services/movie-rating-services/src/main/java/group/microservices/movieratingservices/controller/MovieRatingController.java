package group.microservices.movieratingservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import group.microservices.movieratingservices.REPO.RatingInfoRepository;
import group.microservices.movieratingservices.dao.MovieRating;

@RestController
@RequestMapping("/movieRating")
public class MovieRatingController {

	@Autowired
	RatingInfoRepository repo;
	
	@RequestMapping(method=RequestMethod.GET ,value="/{movieid}")
	public Optional<MovieRating> getMovieRating(@PathVariable(value="movieid") String movieid) {
		movieid=movieid.toLowerCase();
		return repo.findById(movieid);
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/getAllRatings")
	public List<MovieRating> getRatings_AllMovies() {
		return repo.findAll();
	}
	
	
}
