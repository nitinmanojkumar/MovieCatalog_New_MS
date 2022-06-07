package group.microservices.moviecatalogservices.dao;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

public class CatalogItem {

	private String production;
	private String movieid;
	private String moviename;
	private String moviedesc;
	private String rating;
	
		
	public CatalogItem() {
		super();
	}
	public CatalogItem(String production, String movieid, String moviename, String moviedesc, String rating) {
		super();
		this.production = production;
		this.movieid = movieid;
		this.moviename = moviename;
		this.moviedesc = moviedesc;
		this.rating = rating;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	
	
	
	
	
}
