package com.kuokyn.graphql_test;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class GroceryService {
    private final GroceryRepository groceryRepository ;

    public GroceryService(final GroceryRepository GroceryRepository) {
        this.groceryRepository = GroceryRepository ;
    }

    public Grocery createGrocery(String text,
                                 Integer quantity,
                                 Boolean isBought,
                                 String uid) {
        Grocery grocery = new Grocery(text, quantity, isBought, uid);
        groceryRepository.save(grocery);
        return grocery;
    }

    public Boolean deleteGrocery(Integer id) {
        Optional<Grocery> grocery = groceryRepository.findById(id);
        grocery.ifPresent(groceryRepository::delete);
        return groceryRepository.findById(id).isEmpty();
    }

    public List<Grocery> getGroceries() {
        return new ArrayList<>(groceryRepository.findAll());
    }

    public Grocery getGrocery(Integer id) {
        return this.groceryRepository.findById(id).orElseThrow((IllegalArgumentException::new));
    }

    @PostConstruct
    private void init() {
        groceryRepository.save(new Grocery("Bread", 1, false, "James"));
        groceryRepository.save(new Grocery("Ham", 1, false, "James"));
        groceryRepository.save(new Grocery("Cheese", 1, false, "James"));
    }
}