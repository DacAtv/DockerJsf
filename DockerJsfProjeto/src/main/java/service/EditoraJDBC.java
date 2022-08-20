package service;

import dominio.Editora;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditoraJDBC implements EditoraRepository {

    private Connection connection;

    public EditoraJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/livros",
                    "postgres","postgres"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EditoraJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }

    }



    @Override
    public void nova(Editora editora) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO editoras(localDeOrigem, nomeFantasia) VALUES ( ?, ? );"
            );
            statement.setString(1, editora.getLocalDeOrigem());
            statement.setString(2, editora.getNomeFantasia());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivroJDBC.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public List<Editora> todas() {
        try {
            List<Editora> lista = new ArrayList<>();
            ResultSet result = connection.prepareStatement(
                    "SELECT * FROM editoras"
            ).executeQuery();
            while (result.next()) {
                lista.add(
                        criarEditoras(result)
                );
            }
            return lista;
        } catch (SQLException ex) {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<Editora> porLocalDeOrigem(String localDeOrigem) {
        try {
            List<Editora> lista = new ArrayList<>();
            PreparedStatement prepareStatement = connection.prepareStatement(
                    "SELECT * FROM editoras WHERE localDeOrigem like ?"
            );
            prepareStatement.setString(1, localDeOrigem);
            ResultSet result = prepareStatement.executeQuery();
            while (result.next()) {
                lista.add(
                        criarEditoras(result)
                );
            }
            return lista;
        } catch (SQLException ex) {
            return Collections.EMPTY_LIST;
        }
    }

    private Editora criarEditoras(ResultSet result) throws SQLException {
        String localDeOrigem = result.getString("localDeOrigem");
        String nomeFantasia = result.getString("nomeFantasia");
        int codigo = result.getInt("codigo");

        return new Editora(codigo,localDeOrigem,nomeFantasia);
    }
}
