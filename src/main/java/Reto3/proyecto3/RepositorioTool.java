
package Reto3.proyecto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alejo
 */
@Repository
public class RepositorioTool {
    
    @Autowired
    private InterfaceTool crud;
    public List<Tool> getAll(){
        return (List<Tool>) crud.findAll();
    }
    
    public Optional<Tool> getTool(int id){
        return crud.findById(id);
    }
    
    public Tool save(Tool tool){
        return crud.save(tool);
    }
    public void delete(Tool tool){
        crud.delete(tool);
    
}}
