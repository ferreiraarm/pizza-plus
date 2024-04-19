package dioprojetos.pizzapluslab02.controller;

import ch.qos.logback.core.net.server.Client;
import dioprojetos.pizzapluslab02.model.Pizza;
import dioprojetos.pizzapluslab02.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pizza")
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<Iterable<Pizza>> buscarTdos() {
        return ResponseEntity.ok(pizzaService.buscarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pizzaService.buscarPorId(id));

    }

    @PostMapping
    public ResponseEntity<Pizza> inserir (@RequestBody Pizza pizza){
        pizzaService.inserir(pizza);
        return ResponseEntity.ok(pizza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> atualizar(@PathVariable Long id, @RequestBody Pizza pizza){
        pizzaService.atualizar(id, pizza);
        return ResponseEntity.ok(pizza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        pizzaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}