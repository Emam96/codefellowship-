package codefellowship.example.codefellowship.repos;

import codefellowship.example.codefellowship.models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepo extends CrudRepository<ApplicationUser,Long> {

    ApplicationUser findByUsername(String username);

}
