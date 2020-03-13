package com.demo.cinemamicroservice.cinemaservice.repositories.dynamo;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.demo.cinemamicroservice.cinemaservice.repositories.exceptions.DuplicateIMovieIdException;
import com.demo.cinemamicroservice.cinemaservice.repositories.exceptions.ModelNotFoundException;
import com.demo.cinemamicroservice.cinemaservice.repositories.models.CinemaShowing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class CinemaRepository {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public CinemaRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    /**
     * Finds movie schedules and provides a list of information about the service.
     * @param movieId
     * @return
     * @throws ModelNotFoundException
     * @throws DuplicateIMovieIdException
     */
    public List<CinemaShowing> findCinemaByShowing(Long movieId) throws ModelNotFoundException, DuplicateIMovieIdException {
    CinemaShowing cinemaShowing = new CinemaShowing();
    cinemaShowing.setMovieId(movieId);

        DynamoDBQueryExpression<CinemaShowing> expression =
            new DynamoDBQueryExpression<CinemaShowing>()
                .withHashKeyValues(cinemaShowing);

        List<CinemaShowing> records = query(expression);
        duplicateMovieId(records);
        return records;
    }

    private List<CinemaShowing> query(DynamoDBQueryExpression<CinemaShowing> expression) throws ModelNotFoundException {
        try {
            return dynamoDBMapper.query(CinemaShowing.class, expression);
        } catch (SdkClientException sce) {
            log.error("ModelNotFoundException",sce);
            throw new ModelNotFoundException(sce);
        }
    }

    private void duplicateMovieId(List<CinemaShowing> cinemaShowingList) throws DuplicateIMovieIdException {
        long count = cinemaShowingList.stream()
            .map(CinemaShowing::getMovieId)
            .distinct()
            .count();

        if (count > 1) {
            throw new DuplicateIMovieIdException(count);
        }
    }
}
