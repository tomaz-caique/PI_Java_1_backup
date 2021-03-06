
package Controller;

import Controller.Helper.ForConsultaHelper;
import View.Cadastro;
import Dao.Conexao;
import Dao.FornecedorDAO;
import Models.Fornecedor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
    
public class FornecedorController {
    
    private Cadastro view;

    public FornecedorController(Cadastro view) {
        this.view = view;

    }
    
    public void SalvarFornecedor(){
        
        
            String nome = view.getjTextNomeFor().getText();
            String email = view.getjTextEmailFor().getText();
            String telefone = view.getjTextTelefoneFor().getText();
            String contrato = view.getjTextContratoFun().getText();
                
            Fornecedor fornecedor = new Fornecedor(nome, email, telefone, contrato);
            try {
     
            
            Connection conexao = new Conexao().getConnection();
             FornecedorDAO fornecedorDao = new FornecedorDAO(conexao);
            fornecedorDao.insert(fornecedor);
            
            
            view.getjTextNomeFor().setText("");
            view.getjTextEmailFor().setText("");
            view.getjTextTelefoneFor().setText("");
            view.getjTextContratoFun().setText("");

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {

            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);

           
        }
            
    }
    


}
