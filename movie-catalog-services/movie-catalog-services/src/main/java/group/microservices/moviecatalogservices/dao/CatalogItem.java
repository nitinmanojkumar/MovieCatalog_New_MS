package group.microservices.moviecatalogservices.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movielist")
public class CatalogItem {

	@Column(name="production")
	private String production;
	
	@Id
	@Column(name="movieid")
	private String movieid;
	
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

	
	
	
}
