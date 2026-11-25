package com.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.biblioteca.biblioteca.repository.AutorRepository;
import com.biblioteca.biblioteca.repository.CategoriaRepository;
import com.biblioteca.biblioteca.repository.LivroRepository;

@Controller
public class HomeController {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;

    public HomeController(LivroRepository livroRepository,
                          AutorRepository autorRepository,
                          CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("totalLivros", livroRepository.count());
        model.addAttribute("totalAutores", autorRepository.count());
        model.addAttribute("totalCategorias", categoriaRepository.count());
        return "index";
    }
}