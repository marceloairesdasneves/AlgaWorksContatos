package com.algaworks.controller;

// @author Marcelo Neves
import com.algaworks.model.Contato;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ContatosControle {
    private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
    static{
        LISTA_CONTATOS.add(new Contato("1", "Afonso", "+55 34 1111 1111"));
        LISTA_CONTATOS.add(new Contato("2", "Maria", "+55 34 2222 2222"));
        LISTA_CONTATOS.add(new Contato("3", "Joao", "+55 34 3333 3333"));
        LISTA_CONTATOS.add(new Contato("4", "Jose", "+55 34 4444 4444"));
        LISTA_CONTATOS.add(new Contato("5", "Ana", "+55 34 5555 5555"));
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/contatos")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("listar");
        mv.addObject("contatos", LISTA_CONTATOS);
        return mv;
    }

    @GetMapping("/contatos/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("formulario");
        mv.addObject("contato", new Contato());
        return mv;
    }

}
