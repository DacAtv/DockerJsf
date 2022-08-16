package Dominio;

import java.time.LocalDate;

public class Livro {
    private long id;
    private String titulo;
    private LocalDate dataDeLancamento;

    public Livro(String titulo,LocalDate dataDeLancamento) {
        this(0,titulo,dataDeLancamento);
    }

    public Livro(long id,String titulo,LocalDate dataDeLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.dataDeLancamento = dataDeLancamento;
    }
    public String titulo(){
        return this.titulo;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", dataDeLancamento=" + dataDeLancamento + '}';
    }

    public LocalDate dataLancamento() {
        return this.dataDeLancamento;
    }

}
