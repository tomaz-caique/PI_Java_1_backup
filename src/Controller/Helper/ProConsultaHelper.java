
package Controller.Helper;

import Models.Produto;
import View.Consulta;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ProConsultaHelper {
    
    private final Consulta view;
    private  int idFor;

    public int getIdFor() {
        return idFor;
    }

    public void setIdFor(int idFor) {
        this.idFor = idFor;
    }

    public ProConsultaHelper(Consulta view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Produto> produtoes) {
        
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableProduto().getModel();
        tableModel.setNumRows(0);
        
        for (Produto produto : produtoes) {
            
            tableModel.addRow(new Object[]{
            
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getCategoria(),
            produto.getPreco(),
            produto.getQuantidade(),
            produto.getMaterial(),
            produto.getProvider()
            
        });
          
   
        }
          
    } 
    
   
}

 
