
package Dao;

import Models.Produto;
import View.Cadastro;
import com.mysql.cj.protocol.Resultset;
import java.awt.Cursor;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    
    private final Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Produto produto) throws SQLException{
            
            String sql = " INSERT INTO product(ID_Product, Product_Name, Product_Description, Product_Category, Product_Price, Qtd_Product, Product_Material, Product_Provider)"
                    + " VALUES (ID_Product,?,?,?,?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(sql);
              statement.setString(1,produto.getNome());
              statement.setString(2,produto.getDescricao());
              statement.setString(3,produto.getCategoria());
              statement.setDouble(4,produto.getPreco());
              statement.setInt(5,produto.getQuantidade());
              statement.setString(6,produto.getMaterial());
              statement.setString(7,produto.getProvider());
            statement.execute(); 

    }

    
    public void update(Produto produto) throws SQLException{
            
            String sql = "UPDATE product SET Product_Name = ?, Product_Description = ?, Product_Price = ?, Qtd_Product = ? WHERE ID_Product = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
              statement.setString(1,produto.getNome());
              statement.setString(2,produto.getDescricao());
              statement.setDouble(3,produto.getPreco());
              statement.setInt(4,produto.getQuantidade());
              statement.setInt(5,produto.getId());

              statement.execute(); 

    }
    
    
   public ArrayList<Produto> SelecionaTodos() throws SQLException{
       
        String sql = "SELECT * FROM Product";
       PreparedStatement statement;
        statement = connection.prepareStatement(sql);
       
       return pesquisaBanco(statement);
   }

    private ArrayList<Produto> pesquisaBanco(PreparedStatement statement) throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            
            int id = resultSet.getInt("ID_Product");
            String nome = resultSet.getString("Product_Name");
            String descricao = resultSet.getString("Product_Description");
            String categoria = resultSet.getString("Product_Category");
            double preco = resultSet.getDouble("Product_Price");
            int quantidade = resultSet.getInt("Qtd_Product");
            String material = resultSet.getString("Product_Material");
            String fornecedor = resultSet.getString("Product_Provider");
            
            Produto produtoDados = new Produto(id ,nome, descricao, categoria, preco, quantidade, material, fornecedor);
            produtos.add(produtoDados);
        }
        return produtos;
    }
   
   public Produto SelecionaPorId(Produto produto) throws SQLException{
       String sql = "SELECT * FROM product where ID_Product = ?";
       PreparedStatement statement = connection.prepareStatement(sql);
       
       statement.setInt(1,produto.getId());
       
        return pesquisaBanco(statement).get(0);
   }
   
   
    public ArrayList<Produto> SelecionaPorNome(String nomeC) throws SQLException{
        String test = ("%" + nomeC + "%");
        String sql = "SELECT * FROM Product where Product_Name LIKE '"+test+"'";
       PreparedStatement statement;
        statement = connection.prepareStatement(sql);
      //  Cursor cursor = get
         statement.execute();
         ArrayList<Produto> produtos = new ArrayList<>();
        ResultSet resultSet = statement.getResultSet();
         while(resultSet.next()){
            
           int id = resultSet.getInt("ID_Product");
            String nome = resultSet.getString("Product_Name");
            String descricao = resultSet.getString("Product_Description");
            String categoria = resultSet.getString("Product_Category");
            double preco = resultSet.getDouble("Product_Price");
            int quantidade = resultSet.getInt("Qtd_Product");
            String material = resultSet.getString("Product_Material");
            String fornecedor = resultSet.getString("Product_Provider");
            
            Produto produtoDados = new Produto(id ,nome, descricao, categoria, preco, quantidade, material, fornecedor);
            produtos.add(produtoDados);
            
         }
            return produtos; 
         }
         
    
      public void delete(Produto produto) throws SQLException{
            
            String sql = "DELETE FROM product WHERE ID_Product = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
              statement.setInt(1,produto.getId());
              statement.execute(); 

    } 
      
    
    }
   
