package br.project.Concessionaria;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcessionariaDao {

    private JdbcTemplate jdbcTemplate;

    //Dao para inserir
    public Concessionaria incluir(Concessionaria c) throws Exception {
        String sqlInsert = "INSERT INTO Concessionaria (ID, CLIENTE, MODELO, PLACA, ENDERECO, CIDADE, ESTADO) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlInsert);) {
            ps.setInt(1, c.getId());
            ps.setString(1, c.getCliente());
            ps.setString(2, c.getModelo());
            ps.setString(3, c.getPlaca());
            ps.setString(4, c.getEndereco());
            ps.setString(5, c.getCidade());
            ps.setString(6, c.getEstado());
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Concessionaria inserida com sucesso.");
                return c;
            }
            ps.close();
            throw new Exception("Erro na inserção.");
        }
    }

    //Dao para listar
    public List<Concessionaria> listar() throws Exception {
        String sqlSelect = "select ID, CLIENTE, MODELO, PLACA ENDERECO, CIDADE, ESTADO from Concessionaria";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlSelect);) {
            List<Concessionaria> lista = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Concessionaria c = new Concessionaria();
                    c.setId(rs.getInt("id"));
                    c.setCliente(rs.getString("cliente"));
                    c.setModelo(rs.getString("modelo"));
                    c.setPlaca(rs.getString("placa"));
                    c.setEndereco(rs.getString("telefone"));
                    c.setCidade(rs.getString("cidade"));
                    c.setEstado(rs.getString("estado"));
                    lista.add(c);
                }
            }
            return lista;
        }
    }

    //Dao para obter
    public Concessionaria obter(int id) throws Exception {
        String sqlSelect = "select ID, NOME, ENDERECO, TELEFONE from Pessoa where id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlSelect);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    Concessionaria c = new Concessionaria();
                    c.setId(rs.getInt("id"));
                    c.setCliente(rs.getString("cliente"));
                    c.setModelo(rs.getString("modelo"));
                    c.setPlaca(rs.getString("placa"));
                    c.setEndereco(rs.getString("endereco"));
                    c.setCidade(rs.getString("cidade"));
                    c.setEstado(rs.getString("estado"));
                    return c;
                }
            }
            throw new Exception("Id não encontrado na tabela");
        }
    }
}
