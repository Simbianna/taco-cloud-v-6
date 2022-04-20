package com.example.tacocloud.data;

import com.example.tacocloud.model.TacoOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}