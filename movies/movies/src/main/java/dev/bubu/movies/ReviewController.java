package dev.bubu.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Review>>(reviewService.findReviewById(id),HttpStatus.OK);
    }

    //what ever we get as a requestbody we would like to convert it to a map of key String, value String and name this Map as Payload
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"));
        return new ResponseEntity("Your review was added with success!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Review>> deleteReview(@PathVariable ObjectId id) {
        reviewService.deleteSingleReview(reviewService.findReviewById(id).get().getId());
        return new ResponseEntity("Review deleted successfully", HttpStatus.OK);
    }

}
