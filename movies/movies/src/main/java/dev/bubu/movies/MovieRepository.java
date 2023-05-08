package dev.bubu.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//to know that this is a repository
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
//    List<Movie> findByMovieName(String name);
    Optional<Movie> findMovieByImdbId(String imdbId);

    Optional<Movie> findMovieByTitle(String title);

}
