package group.microservices.moviecatalogservices.dao;

import java.util.List;

public class ListOfUserRating {

    private List<MovieRating> userRating;

    public List<MovieRating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<MovieRating> userRating) {
        this.userRating = userRating;
    }
}
