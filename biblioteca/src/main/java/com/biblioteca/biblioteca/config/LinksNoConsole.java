package com.biblioteca.biblioteca.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LinksNoConsole {

    @Value("${server.port:8080}")
    private String porta;

    @Value("${spring.datasource.url}")
    private String urlBanco;

    @EventListener(ApplicationReadyEvent.class)
    public void mostrarLinks() {
        String base = "http://localhost:" + porta;

        System.out.println();
        System.out.println("  Links para acesso rápido:");
        System.out.println("  Início ......... " + base);
        System.out.println("  Livros ......... " + base + "/livros");
        System.out.println("  Autores ........ " + base + "/autores");
        System.out.println("  Categorias ..... " + base + "/categorias");
        System.out.println("  Console H2 ..... " + base + "/h2-console");
        System.out.println("  JDBC URL ....... " + urlBanco);
        System.out.println("  Usuário: sa  |  Senha: (vazia)");
        System.out.println();
    }
}