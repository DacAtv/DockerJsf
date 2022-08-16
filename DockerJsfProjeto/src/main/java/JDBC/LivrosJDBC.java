package JDBC;

import Dominio.Livro;
import Dominio.Livros;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivrosJDBC implements Livros {

    private Connection connection;

    public LivrosJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/livros",
                    "job","123"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LivrosJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }

    }

    @Override
    public void criar(Livro livro) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO livros(titulo, dataDeLancamento) VALUES ( ?, ? );"
            );
            statement.setString(1,livro.titulo());
            statement.setDate(
                    2,Date.valueOf(livro.dataLancamento())
            );
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivrosJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }

    }

    @Override
    public List<Livro> todos() {
        try {
            List<Livro> lista = new ArrayList<>();
            ResultSet result = connection.prepareStatement(
                    "SELECT * FROM livros"
            ).executeQuery();
            while (result.next()) {
                lista.add(
                        criarLivros(result)
                );
            }
            return lista;
        } catch (SQLException ex) {
            return Collections.EMPTY_LIST;
        }
    }

    private Livro criarLivros(ResultSet result) throws SQLException {
        LocalDate dataDeLancamento = result.getDate("dataDeLancamento").toLocalDate();
        String titulo = result.getString("titulo");
        int id = result.getInt("id");
        return new Livro(id,titulo,dataDeLancamento);
    }

}