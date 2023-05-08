package dev.bubu.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    //same as a repository
    //form a new dynamic query and do the job inside the database without using the Repository
    @Autowired
    private MongoTemplate mongoTemplate;

    public Optional<Review> findReviewById(ObjectId id) {
        return reviewRepository.findById(id);
    }

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        //using the template to perform an update call on the Movie class
        mongoTemplate.update(Movie.class)
                //updating the movie where the imdbid in the database matches the imdb that we had received
                .matching(Criteria.where("imdbId").is(imdbId))
                //make the change inside the database
                .apply(new Update().push("reviewsIds").value(review))
                //update only one
                .first();

        return review;
    }

    public void deleteSingleReview(ObjectId id) {
        reviewRepository.deleteById(id);
    }
}
