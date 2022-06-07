package group.microservices.movieinfoservices.REPO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import group.microservices.movieinfoservices.dao.MovieInfo;

@Repository
public interface movieInfoRepository extends JpaRepository<MovieInfo, String>{

}
