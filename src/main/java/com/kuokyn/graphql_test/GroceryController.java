package com.kuokyn.graphql_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @QueryMapping
    public List<Grocery> getGroceriesByUserId(@Argument Long uid) {
        return groceryService.getGroceriesByUserId(uid);
    }

    @QueryMapping
    public Grocery getGrocery(@Argument Integer id) {
        return groceryService.getGrocery(id);
    }

    @MutationMapping
    public Grocery createGrocery(@Argument String text,
                                 @Argument Integer quantity,
                                 @Argument Boolean isBought,
                                 @Argument Long uid) {
        return groceryService.createGrocery(text, quantity, isBought, uid);
    }

    @MutationMapping
    public void deleteGrocery(@Argument Integer id) {
        groceryService.deleteGrocery(id);
    }
}
