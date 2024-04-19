package dioprojetos.pizzapluslab02.service.impl;

import dioprojetos.pizzapluslab02.model.Endereco;
import dioprojetos.pizzapluslab02.model.Pizza;
import dioprojetos.pizzapluslab02.repository.EnderecoRepository;
import dioprojetos.pizzapluslab02.repository.PizzaRepository;
import dioprojetos.pizzapluslab02.service.PizzaService;
import dioprojetos.pizzapluslab02.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {


    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Pizza> buscarTodas() {

        return pizzaRepository.findAll();
    }

    @Override
    public Pizza buscarPorId(Long id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);

        return pizza.get();

    }

    @Override
    public void inserir(Pizza pizza) {
        salvarPizzaComCep(pizza);
    }

    @Override
    public void atualizar(Long id, Pizza pizza) {
        Optional<Pizza> pizzaId = pizzaRepository.findById(id);
        if (pizzaId.isPresent()) {
            salvarPizzaComCep(pizza);
        }
    }

    @Override
    public void deletar(Long id) {
    pizzaRepository.deleteById(id);
    }

    private void salvarPizzaComCep(Pizza pizza) {
        // Verificar se o Endereco da pizza já existe (pelo CEP).
        String cep = pizza.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        pizza.setEndereco(endereco);
        // Inserir Pizza, vinculando o Endereco (novo ou existente).
        pizzaRepository.save(pizza);
    }
}
