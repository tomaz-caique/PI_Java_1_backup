
package Controller;


import Controller.Helper.ProConsultaHelper;
import Dao.Conexao;
import Dao.ProdutoDAO;
import Models.Produto;
import View.Consulta;
import View.ConsultaProduto;
import View.ConsultaProduto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

public class ProConsultaController {
    
    private  Consulta view;
    private  ConsultaProduto viewF;
    private  ProConsultaHelper helper;

 

 
    public ProConsultaController(Consulta view) {
        this.view = view;
        this.helper = new ProConsultaHelper(view);
    }

    public ProConsultaController(ConsultaProduto viewF) {
        this.viewF = viewF;
    }


    
    
    public void atualizaTabela() throws SQLException{
    
        Connection conexao = new Conexao().getConnection();
        ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
        ArrayList<Produto> produtos = produtoDAO.SelecionaTodos();
        
        helper.preencherTabela(produtos);
        
    }
    
    public void carregaDados() throws SQLException{
    
        DefaultTableModel model = (DefaultTableModel) view.getjTableProduto().getModel();
        int selectedRowIndex = view.getjTableProduto().getSelectedRow();
        
        String id =   model.getValueAt(selectedRowIndex, 0).toString();
        String nome = model.getValueAt(selectedRowIndex, 1).toString();
        String descricao = model.getValueAt(selectedRowIndex, 2).toString();
        String preco = model.getValueAt(selectedRowIndex, 4).toString();
        var quantidade = model.getValueAt(selectedRowIndex, 5);
        
        ConsultaProduto consultaprodo = new ConsultaProduto();
        consultaprodo.setIdConsulta(id);
        consultaprodo.getjTextNomePro().setText(nome);
        consultaprodo.getjTextAreaDesc().setText(descricao);
        consultaprodo.getjTextPrecoPro().setText(preco);
        consultaprodo.getjSpinnerQuantidade().setValue(quantidade);
        
        
        consultaprodo.setVisible(true);
        
    }

   
    
    public void alterarDados() throws SQLException{
        

        String id = viewF.getIdConsulta();
        String nome = viewF.getjTextNomePro().getText();
        String descricao = viewF.getjTextAreaDesc().getText();
        String preco = viewF.getjTextPrecoPro().getText();
        String quantidade = viewF.getjSpinnerQuantidade().getValue().toString();
        int convertId = Integer.parseInt(id);
        double convertPreco = Double.parseDouble(preco);
        int convertQtd = Integer.parseInt(quantidade);
     
        var produto = new Produto(convertId, nome, descricao, convertPreco, convertQtd);
       
        try{
        Connection conexao = new Conexao().getConnection();
        ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
        produtoDAO.update(produto);
        
        
        viewF.dispose();
        JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        Consulta consulta = new Consulta(1);
        consulta.setVisible(true);
        
        }
          catch(SQLException ex){  
                
              System.out.println("ERRO");
             
             }  
        
        
    }
    
    public void ProcurarPorNome(String texto){
        
            try {
                   Connection conexao = new Conexao().getConnection();
                    ProdutoDAO produtoDao = new ProdutoDAO(conexao);
                    
                    ArrayList<Produto> produtos = produtoDao.SelecionaPorNome(texto);
                    ProConsultaHelper prodConsuHelper = new ProConsultaHelper(view);
                    prodConsuHelper.preencherTabela(produtos);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
                }
    
    }
    
     public void deletarProduto() throws SQLException{
        

        String id = viewF.getIdConsulta();
        int convertId = Integer.parseInt(id);
     
        var produto = new Produto(convertId);
        
         
        int dialogButton = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir ?"); 
        if (dialogButton == JOptionPane.YES_OPTION) 
        {
        try{
        Connection conexao = new Conexao().getConnection();
        ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
        produtoDAO.delete(produto);
       
        viewF.dispose();
        JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        Consulta consulta = new Consulta(1);
        consulta.setVisible(true);
        
        }
          catch(SQLException ex){  
                
              System.out.println("ERRO");
             
             }  
        
        }
        else {
            
        }
        
       
    }
     
    
}
