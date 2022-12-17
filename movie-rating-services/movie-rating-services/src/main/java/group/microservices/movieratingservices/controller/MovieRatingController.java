package group.microservices.movieratingservices.controller;

import java.util.List;
import java.util.Optional;

import group.microservices.movieratingservices.dao.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import group.microservices.movieratingservices.REPO.RatingInfoRepository;
import group.microservices.movieratingservices.dao.MovieRating;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

	@RequestMapping(method=RequestMethod.GET ,value="/getAllUserRatings")
	public UserRating getAllUserRatings() {
		List<MovieRating> ratings=repo.findAll();
		UserRating userRating=new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
	
}
