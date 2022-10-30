package com.kuokyn.graphql_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GroceryController {

    @Autowired
    private GroceryRepository groceryRepository;
//    private GroceryService groceryService;

    @QueryMapping
    public Iterable<Grocery> getGroceries() {
        return groceryRepository.findAll();
    }

    @QueryMapping
    public Grocery getGrocery(@Argument Integer id) {
        return groceryRepository.findById(id).orElseThrow();
    }

    @MutationMapping
    public Grocery createGrocery(@Argument String text,
                                 @Argument Integer quantity,
                                 @Argument Boolean isBought,
                                 @Argument String uid) {
        Grocery grocery = new Grocery(text, quantity, isBought, uid);
        return groceryRepository.save(grocery);
    }

    @MutationMapping
    public void deleteGrocery(@Argument Integer id) {
        groceryRepository.deleteById(id);
    }
}
