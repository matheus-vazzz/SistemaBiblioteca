package com.biblioteca.biblioteca.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.LivroRepository;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/exemplo")
    public String exibirLivro(Model model) {
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        model.addAttribute("livro", livro);
        return "index";
    }

    @GetMapping("/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping
    public String cadastrarLivro(@ModelAttribute Livro livro) {
        repository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping
    public String listarLivros(Model model) {
        List<Livro> livros = repository.findAll();
        model.addAttribute("livros", livros);
        return "livros/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/livros";
    }
}