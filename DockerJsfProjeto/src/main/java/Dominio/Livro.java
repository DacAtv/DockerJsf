package Dominio;

import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private LocalDate dataDeLancamento;

    public Livro(int id, String titulo, LocalDate dataDeLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.dataDeLancamento = dataDeLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

}
