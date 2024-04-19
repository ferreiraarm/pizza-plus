package dioprojetos.pizzapluslab02.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "pizzas")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Endereco endereco;
    private String nome;

    private Double preco;

    // Vínculo Muitos-para-Muitos com Ingrediente (ManyToMany)
    @ManyToMany
    @JoinTable(name = "pizza_ingrediente",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))

    private Set<Ingredientes> ingredientes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Set<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}