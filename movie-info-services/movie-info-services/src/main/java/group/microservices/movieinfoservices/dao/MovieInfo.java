package group.microservices.movieinfoservices.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name="newmovielist")
@NoArgsConstructor
public class MovieInfo {

	@Id
	private String movieid;
	private String moviename;
	private String moviedesc;
	
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getMoviedesc() {
		return moviedesc;
	}
	public void setMoviedesc(String moviedesc) {
		this.moviedesc = moviedesc;
	}
	
	
	
}
