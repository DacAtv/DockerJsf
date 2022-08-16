package repository;

import dominio.Livro;

import java.util.List;

public interface LivroRepository {

    List<Livro> listarLivros();
    void cadastrar(Livro livro);
    Livro editarLivro(Livro livro);
    Livro buscarLivroPorTitulo(String titulo);
    void excluir(Long id);
}
