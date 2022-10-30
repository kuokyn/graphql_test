package com.kuokyn.graphql_test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {
    public List<Grocery> findAllByUserId(Long uid);
}
