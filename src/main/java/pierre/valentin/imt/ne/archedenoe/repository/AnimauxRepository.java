package pierre.valentin.imt.ne.archedenoe.repository;

import org.springframework.data.repository.CrudRepository;
import pierre.valentin.imt.ne.archedenoe.entity.Animaux;

public interface AnimauxRepository extends CrudRepository<Animaux, Long> {
    Animaux getAnimauxById(int id);
}
