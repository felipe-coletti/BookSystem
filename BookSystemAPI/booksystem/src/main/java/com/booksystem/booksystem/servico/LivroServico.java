package com.booksystem.booksystem.servico;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.model.repository.ILivroRepository;
import com.booksystem.booksystem.servico.interfaces.ILivroServico;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class LivroServico implements ILivroServico {

    Logger logger = LogManager.getLogger(this.getClass());

    ILivroRepository livroRepository;

    public LivroServico(ILivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @Override
    public List<Livro> consultarLivros() {
        logger.info("|--- Serviço - Consultando livros ----|");
        return livroRepository.findAll();
    }

    @Override
    public List<Livro> consultarPorTitulo(String titulo, int ordem) {
       logger.info("|--- Serviço - Consultando por título ----|");

       List<Livro> listaLivrosPorTitulo = null;

       if (ordem == 1) {
           listaLivrosPorTitulo = livroRepository.findByTituloAsc(titulo);
           return listaLivrosPorTitulo;
       } else if (ordem == -1) {
           listaLivrosPorTitulo = livroRepository.findByTituloDesc(titulo);
           return listaLivrosPorTitulo;
       }

       return listaLivrosPorTitulo;

    }

    @Override
    public void excluirLivro(String id) {
        logger.info("|--- Serviço - Excluindo livro ----|");
        livroRepository.deleteById(id);
    }

    @Override
    public Optional<Livro> cadastrarLivro(Livro newLivro) {
       
        logger.info("|---- Serviço - Cadastrando livro ----|");
        return Optional.ofNullable(livroRepository.insert(newLivro));
    }

}
