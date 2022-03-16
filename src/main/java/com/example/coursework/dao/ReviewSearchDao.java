package com.example.coursework.dao;

import com.example.coursework.models.Review;
import org.apache.lucene.search.Query;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReviewSearchDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Review> searchReviews (String text) {
        Query keywordQuery  = getQueryBuilder()
                .keyword().fuzzy()
                .withEditDistanceUpTo(2)
                .onFields("title", "full_text", "tags")
                .matching(text)
                .createQuery();
        return getJpaQuery(keywordQuery).getResultList();
    }

    private FullTextQuery getJpaQuery(org.apache.lucene.search.Query luceneQuery) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager.unwrap(SessionImplementor.class));

        return fullTextEntityManager.createFullTextQuery(luceneQuery, Review.class);
    }

    private QueryBuilder getQueryBuilder() {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager.unwrap(SessionImplementor.class));

        return fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Review.class)
                .get();
    }
}
