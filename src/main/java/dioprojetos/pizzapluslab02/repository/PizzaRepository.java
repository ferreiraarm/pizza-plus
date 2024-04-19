package dioprojetos.pizzapluslab02.repository;

import dioprojetos.pizzapluslab02.model.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
