package com.booksystem.booksystem.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.booksystem.booksystem.model.Livro;
import com.booksystem.booksystem.model.Status;
import com.booksystem.booksystem.model.repository.ILivroRepository;
import com.booksystem.booksystem.servico.interfaces.ILivroServico;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Service
public class LivroServico implements ILivroServico{

    Logger logger = LogManager.getLogger(this.getClass());

    ILivroRepository livroRepository;

    ImagemServico imagemServico;

    public LivroServico(ILivroRepository livroRepository, ImagemServico imagemServico){
        this.livroRepository = livroRepository;
        this.imagemServico = imagemServico;
    }

    @Override
    public List<Livro> consultarLivros() {
        logger.info("|--- Serviço - Consultando livros ----|");
        return livroRepository.findAll();
    }

    @Override
    public List<Livro> consultarPorIsbn(Long isbn) {
       logger.info("|--- Serviço - Consultando por ISBN ----|");
       return livroRepository.findByIsbn(isbn);
    }

    @Override
    public Optional<Livro> cadastrarLivro(Livro newLivro) {
        logger.info("|---- Serviço - Cadastrando livro ----|");
        newLivro.setStatus(Status.DISPONIVEL);

        String imagem = imagemServico.verificarTamanhoImagem(newLivro.getImagem());

        if (imagem != null) {
            imagemServico.uploadImagem(newLivro.getId(), newLivro.getImagem());
        }

        return Optional.ofNullable(livroRepository.insert(newLivro));
    }
    
    @Override
    public void excluirLivro(String id) {
        logger.info("|--- Serviço - Excluindo livro ----|");
        livroRepository.deleteById(id);
    }

    // @Override
    // public String cadastrarImagem(String imagemByte) {
       
    //     if(imagemByte.getBytes().length <= 34000){
    //         return imagemByte;
    //     } else {
    //         throw new RuntimeException();
    //     }
    

    // }

    

}
