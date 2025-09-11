package JohnatanSSP.Stock.AI.repository;

import JohnatanSSP.Stock.AI.model.ObjectItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectItemRepository extends JpaRepository<ObjectItem,Long> {

}
