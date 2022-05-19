
package Controller.Helper;

import Models.Fornecedor;
import View.Cadastro;
import View.Consulta;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class ForConsultaHelper {
    

    private  Consulta view;
    private  Cadastro viewC;
    private  int idFor;

    public int getIdFor() {
        return idFor;
    }

    public void setIdFor(int idFor) {
        this.idFor = idFor;
    }

    public ForConsultaHelper(Consulta view) {
        this.view = view;
    }
    
     public ForConsultaHelper(Cadastro viewC) {
        this.viewC = viewC;
    }
    

    public void preencherTabela(ArrayList<Fornecedor> fornecedores) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableFornecedor().getModel();
        tableModel.setNumRows(0);
        
        for (Fornecedor fornecedor : fornecedores) {
            
            tableModel.addRow(new Object[]{
            
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getEmail(),
            fornecedor.getTelefone(),
            fornecedor.getContrato()
            
        });
          
   
        }
          
    } 

    
    
}
 
