package com.example.tacocloud.data;

import com.example.tacocloud.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {

}