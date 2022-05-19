
package Controller;

import Dao.Conexao;
import Dao.ProdutoDAO;
import Models.Produto;
import View.Cadastro;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoController {
    
    private Cadastro view;

    public ProdutoController(Cadastro view) {
        this.view = view;
    }
    
    
    public void salvarProduto(){
            
        

            String nome = view.getjTextNomePro().getText();
            String descricao = view.getjTextAreaDesc().getText();
            String categoria = view.getjTextCategoriaPro().getText();
            String preco = view.getjTextPrecoPro().getText();
            String quantidade = view.getjSpinnerQuantidade().getValue().toString();
            String material = view.getjTextMaterialPro().getText();
            String provider = view.getjComboBoxFornecedor().getSelectedItem().toString();
                
            double precoDouble =  Double.parseDouble(preco);
            int quantidadeInt = Integer.parseInt(quantidade);
            
            Produto produto = new Produto(nome, descricao, categoria, precoDouble, quantidadeInt, material, provider);
            try {
     
            
            Connection conexao = new Conexao().getConnection();
            ProdutoDAO produtoDao = new ProdutoDAO(conexao);
            produtoDao.insert(produto);
            
            view.getjTextNomePro().setText("");
            view.getjTextAreaDesc().setText("");
            view.getjTextCategoriaPro().setText("");
            view.getjTextPrecoPro().setText("");
            view.getjSpinnerQuantidade().setValue(0);
            view.getjTextMaterialPro().setText("");
            view.getjComboBoxFornecedor().setSelectedIndex(0);
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            view.getjTextNomeFor().removeAll();
        } catch (SQLException ex) {

            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);

           
        }
    }
}
