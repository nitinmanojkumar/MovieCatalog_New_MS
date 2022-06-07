package group.microservices.movieratingservices.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="newratings")
@NoArgsConstructor
@Getter
@Setter
public class MovieRating {

	@Id
	private String movieid;
	
	private float ratings;
	
	
	
	
}
