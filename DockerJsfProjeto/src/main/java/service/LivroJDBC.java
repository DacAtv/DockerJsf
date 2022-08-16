package service;

import dominio.Livro;
import repository.LivroRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivroJDBC implements LivroRepository {

    private Connection connection;

    public LivroJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/livros",
                    "job","123"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LivroJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void cadastrarLivro(Livro livro) {
        try {
            PreparedStatement stm = connection.prepareStatement(
                    "INSERT INTO livros(titulo, dataDeLancamento) VALUES (?, ?);");

            stm.setString(1, livro.titulo());
            stm.setDate(2, Date.valueOf(livro.dataLancamento()));
            stm.executeUpdate();

        } catch (SQLException e) {

            Logger.getLogger(LivroJDBC.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public List<Livro> listarLivros() {
        try {
            List<Livro> lista = new ArrayList<>();
            ResultSet result = connection.prepareStatement(
                    "SELECT * FROM livros"
            ).executeQuery();
            while (result.next()) {
                lista.add(
                        criarLivro(result)
                );
            }
            return lista;
        } catch (SQLException ex) {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public Livro editarLivro(Livro livro) {
        return null;
    }

    @Override
    public Livro buscarLivroPorTitulo(String titulo) {
        return null;
    }

    @Override
    public void excluirLivro(Long id) {

    }

    private Livro criarLivro(ResultSet result) throws SQLException {
        LocalDate dataDeLancamento = result.getDate("dataDeLancamento").toLocalDate();
        String titulo = result.getString("titulo");
        int id = result.getInt("id");
        return new Livro((long) id,titulo,dataDeLancamento);
    }

}
