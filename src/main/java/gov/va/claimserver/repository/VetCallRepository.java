package gov.va.claimserver.repository;

import gov.va.claimserver.model.VetCallEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetCallRepository extends CrudRepository<VetCallEntity, Long> {
}
