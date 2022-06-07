package group.microservices.movieratingservices.REPO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import group.microservices.movieratingservices.dao.MovieRating;

@Repository
public interface RatingInfoRepository extends JpaRepository<MovieRating, String>{

}
