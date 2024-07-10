package com.bondith.webappbackend.doa;

import com.bondith.webappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * UserRepo is an interface that extends JpaRepository and represents a repository for User objects.
 * It provides methods for performing database operations such as saving, updating, and retrieving User entities.
 *
 * <p>Usage example:</p>
 * <pre>{@code
 *      // Instantiate a UserRepo object
 *      UserRepo userRepo = new UserRepo();
 *
 *      // Save a new User entity
 *      User user = new User();
 *      user.setId(1);
 *      user.setUsername("john.doe");
 *      user.setPassword("password123");
 *      userRepo.save(user);
 *
 *      // Retrieve a User entity by its ID
 *      Optional<User> optionalUser = userRepo.findById(1);
 *      if (optionalUser.isPresent()) {
 *          User retrievedUser = optionalUser.get();
 *          System.out.println(retrievedUser.getUsername());
 *      }
 * }</pre>
 *
 * Note: The above code is just an example and assumes that the User entity and other related classes are properly defined.
 */
@Repository
public interface UserRepo extends JpaRepository<User, String> {
}
