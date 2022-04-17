package pierre.valentin.imt.ne.archedenoe.repository;

import org.springframework.data.repository.CrudRepository;
import pierre.valentin.imt.ne.archedenoe.entity.Arche;

public interface ArcheRepository extends CrudRepository<Arche, Long> {
    Arche getArcheById(Long id);
}
