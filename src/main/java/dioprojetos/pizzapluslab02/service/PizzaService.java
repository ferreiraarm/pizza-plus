package dioprojetos.pizzapluslab02.service;

import dioprojetos.pizzapluslab02.model.Pizza;

public interface PizzaService {
    Iterable<Pizza> buscarTodas();

    Pizza buscarPorId(Long id);

    void inserir(Pizza pizza);

    void atualizar(Long id, Pizza pizza);

    void deletar(Long id);
}
