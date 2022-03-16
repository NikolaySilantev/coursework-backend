package com.example.coursework.services;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class BuildSearchService implements ApplicationListener<ApplicationReadyEvent>{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager.unwrap(SessionImplementor.class));
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            System.out.println("An error occurred trying to build the search index: " + e.toString());
        }
    }
}
