package rajan.wrkspot.demo.myapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import rajan.wrkspot.demo.myapp.models.Corporation;

import java.util.List;

public interface CorporationRepository extends MongoRepository<Corporation, String> {

    @Query("{ 'Lead.firstName' : ?0 }")
    List<Corporation> findCropByLead(String firstName);

}
