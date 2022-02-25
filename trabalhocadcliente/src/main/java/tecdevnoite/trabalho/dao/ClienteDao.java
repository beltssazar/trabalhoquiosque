package tecdevnoite.trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tecdevnoite.trabalho.model.Cliente;
import tecdevnoite.trabalho.model.Genero;

public class ClienteDao {
	
	private Connection conexao;
	
	public ClienteDao(){
		conexao = ConnectionFactory.conectar();
	}
	
	public void inserir (Cliente cliente) {
		String sql = "insert  into tb_clientes"+"(nome,endereco,numero_tel,email,produto,genero,idade)"+"values(?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setLong(3, cliente.getNumero());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getProduto());
			stmt.setInt(6, cliente.getGenero().ordinal());
			stmt.setInt(7, cliente.getIdade());
			stmt.execute();
			conexao.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
		
	}
	
	public List<Cliente> listar(){
		String sql = "select * from tb_clientes order by nome asc";
		PreparedStatement stmt;
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setNumero(rs.getLong("numero_tel"));
				c.setEmail(rs.getString("email"));
				c.setProduto(rs.getString("produto"));
				int posEnum = rs.getInt("genero");
				c.setGenero(Genero.values()[posEnum]);
				c.setIdade(rs.getInt("idade"));
				lista.add(c);
			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public int contaMasc() {
		String sql = "SELECT COUNT(genero) FROM tb_clientes WHERE genero = '0'";
		PreparedStatement stmt;
		int totalMasc = 0;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				totalMasc = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conexao.close();
			return totalMasc;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public int contaFem() {
		String sql = "SELECT COUNT(genero) FROM tb_clientes WHERE genero = '1'";
		PreparedStatement stmt;
		int totalFem = 0;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				totalFem = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conexao.close();
			return totalFem;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void excluir(long idCliente) {
		String sql = "delete from tb_clientes where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			stmt.execute();
			stmt.close();
			conexao.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void atualizar(Cliente cliente) {
		String sql = "update tb_clientes set nome = ?, endereco = ?, numero_tel = ?, email = ?, produto = ?, genero = ?, idade = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setLong(3, cliente.getNumero());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getProduto());
			stmt.setInt(6, cliente.getGenero().ordinal());
			stmt.setInt(7, cliente.getIdade());
			stmt.setLong(8, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Cliente buscar(long idCliente) {
		String sql = "select * from tb_clientes where id = ?";
		PreparedStatement stmt;
		Cliente c = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setNumero(rs.getLong("numero_tel"));
				c.setEmail(rs.getString("email"));
				c.setProduto(rs.getString("produto"));
				int posEnum = rs.getInt("genero");
				c.setGenero(Genero.values()[posEnum]);
				c.setIdade(rs.getInt("idade"));
			}
			rs.close();
			stmt.close();
			conexao.close();
			return c;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

}
