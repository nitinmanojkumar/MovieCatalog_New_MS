package group.microservices.movieinfoservices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import group.microservices.movieinfoservices.REPO.movieInfoRepository;
import group.microservices.movieinfoservices.dao.MovieInfo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/movieInfo")
public class MovieInfoController {

	@Autowired
	movieInfoRepository repo;
	
	@RequestMapping(method = RequestMethod.GET, value="/{movieid}")
	public Optional<MovieInfo> getMovieInfo(@PathVariable(value="movieid") String movieid) {
		return repo.findById(movieid);
	}
	
	
	
}
