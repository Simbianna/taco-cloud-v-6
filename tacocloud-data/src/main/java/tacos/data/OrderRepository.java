package tacos.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import tacos.TacoOrder;
import tacos.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {

    List<TacoOrder> findByUserOrderByPlacedAtDesc(
            User user, Pageable pageable);
}