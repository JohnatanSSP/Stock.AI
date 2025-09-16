package JohnatanSSP.Stock.AI.repository;

import JohnatanSSP.Stock.AI.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Long> {

}
