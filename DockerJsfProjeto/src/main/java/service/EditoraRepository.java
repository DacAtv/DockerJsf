package service;

import dominio.Editora;

import java.util.List;

public interface EditoraRepository {
    public List<Editora> todas();

    public List<Editora> porLocalDeOrigem(String localDeOrigem);

    public void nova(Editora editora);

}
