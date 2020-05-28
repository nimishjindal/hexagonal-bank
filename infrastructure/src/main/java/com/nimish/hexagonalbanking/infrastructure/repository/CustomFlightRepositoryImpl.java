package com.nimish.hexagonalbanking.infrastructure.repository;

import javax.persistence.EntityManager;

public class CustomFlightRepositoryImpl implements CustomFlightRepository{

    private final EntityManager entityManager;

    public CustomFlightRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void deleteByOrigin(String origin){
        String qry = "DELETE from flight WHERE origin=?";
        entityManager.createNativeQuery(qry)
        .setParameter(1,origin)
        .executeUpdate();
    }
}
