package Dominio;

import java.util.List;

public interface Livros {

    public List<Livro> todos();

    public void criar(Livro livro);
}