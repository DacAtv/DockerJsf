package repository;

import dominio.Livro;

import java.sql.SQLException;
import java.util.List;

public interface LivroRepository {

    void cadastrarLivro(Livro livro) throws SQLException;
    List<Livro> listarLivros();
    Livro editarLivro(Livro livro);
    Livro buscarLivroPorTitulo(String titulo);
    void excluirLivro(Long id);
}
