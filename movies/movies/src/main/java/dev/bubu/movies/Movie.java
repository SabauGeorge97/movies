package dev.bubu.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

//this class sheet presents each document in the movies collection
@Document(collection = "movies")
//user for getters&setters
@Data
//constructor with all the parameters
@AllArgsConstructor
//constructor with no params
@NoArgsConstructor
public class Movie {

    //should be treated as unique identifier
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    //will store only the ids of the review
    //the view will be in separate collection
    @DocumentReference
    private List<Review> reviewsIds;
}
