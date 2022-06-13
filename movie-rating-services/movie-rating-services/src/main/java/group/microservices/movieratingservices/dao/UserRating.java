package group.microservices.movieratingservices.dao;

import java.util.List;

public class UserRating {

    private List<MovieRating> userRating;

    public List<MovieRating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<MovieRating> userRating) {
        this.userRating = userRating;
    }
}
