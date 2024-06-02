package com.booksystem.booksystem.service;

import java.util.List;
import java.util.Optional;

import com.booksystem.booksystem.model.Emprestimo;

public interface IEmprestimoServico {
    public List<Emprestimo> consultarEmprestimos();
    public Optional<Emprestimo> cadastrarEmprestimo(String username, Emprestimo emprestimo);

}
