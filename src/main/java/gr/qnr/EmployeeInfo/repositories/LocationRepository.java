package gr.qnr.EmployeeInfo.repositories;

import gr.qnr.EmployeeInfo.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {

   Optional<Location>  findByName(String name);
}
