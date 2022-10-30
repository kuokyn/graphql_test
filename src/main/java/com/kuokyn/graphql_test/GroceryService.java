package com.kuokyn.graphql_test;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;


@Service
public class GroceryService {
    private final GroceryRepository groceryRepository;
    private final UserRepository userRepository;


    public GroceryService(final GroceryRepository GroceryRepository, UserRepository userRepository) {
        this.groceryRepository = GroceryRepository ;
        this.userRepository = userRepository;
    }

    public Grocery createGrocery(String text,
                                 Integer quantity,
                                 Boolean isBought,
                                 Long uid) {
        User user = userRepository.findById(uid).orElseThrow();
        Grocery grocery = new Grocery(text, quantity, isBought, user);
        groceryRepository.save(grocery);
        return grocery;
    }

    public Boolean deleteGrocery(Integer id) {
        Optional<Grocery> grocery = groceryRepository.findById(id);
        grocery.ifPresent(groceryRepository::delete);
        return groceryRepository.findById(id).isEmpty();
    }

    public List<Grocery> getGroceriesByUserId(Long uid) {
        return groceryRepository.findAllByUserId(uid);
    }

    public Grocery getGrocery(Integer id) {
        return this.groceryRepository.findById(id).orElseThrow((IllegalArgumentException::new));
    }

    @PostConstruct
    private void init() {
        userRepository.save(new User("James", "89245556655"));
        userRepository.save(new User("Kate", "89675554433"));
        groceryRepository.save(new Grocery("Bread", 1, false, userRepository.findById(1L).orElseThrow()));
        groceryRepository.save(new Grocery("Ham", 1, false, userRepository.findById(1L).orElseThrow()));
        groceryRepository.save(new Grocery("Cheese", 1, false, userRepository.findById(1L).orElseThrow()));
        groceryRepository.save(new Grocery("Bread", 1, false, userRepository.findById(2L).orElseThrow()));
        groceryRepository.save(new Grocery("Ham", 1, false, userRepository.findById(2L).orElseThrow()));
        groceryRepository.save(new Grocery("Cheese", 1, false, userRepository.findById(2L).orElseThrow()));
    }
}