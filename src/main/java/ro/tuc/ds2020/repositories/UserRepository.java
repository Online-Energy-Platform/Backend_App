package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.tuc.ds2020.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    //CE MA GANDEAM SA FAC: SA SALVEZ USER-UL CA SI CLIENT CAUTAND ID-UL ROLE-ULUI DE CLIENT, DAR NU MA LASA SA FAC INSERT INTO, POATE LA QUERY
    //SE POATE FACE DOAR SELECT? IDK. DACA NU MERGE, OARE CUM ALTCUMVA AS PUTEA FACE INSERT NESTIIND ID-UL ROLE-ULUI. DACA NU, PUN ROLE-UL DIRECT IN USER.
    /* CUSTOM QUERY FOR SAVING A USER IN THE DATABASE: */
//    @Query(value = "INSERT INTO User " +
//            "VALUES(:id, :first_name, :last_name, :address, :email, :password, " +
//            "(SELECT r FROM Role WHERE r.description = 'CLIENT'))")
//    Optional<User> insertClient(@Param("id") UUID id, @Param("first_name") String firstName,
//                                @Param("last_name") String lastName, @Param("address") String address,
//                                @Param("email") String email, @Param("password") String password);

    /**
     * Example: JPA generate Query by Field
     */
    //List<User> findByName(String name);

    /**
     * Example: Write Custom Query
     */
//    @Query(value = "SELECT p " +
//            "FROM Person p " +
//            "WHERE p.name = :name " +
//            "AND p.age >= 60  ")
//    Optional<Person> findSeniorsByName(@Param("name") String name);

}
