/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.proyecto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejo
 */
@Service
public class ServiciosTool {
    @Autowired
   private RepositorioTool metodosCrud;
    
    public List<Tool> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Tool> getTool(int toolId){
        return metodosCrud.getTool(toolId);
    }
    
    public Tool save(Tool tool){
        if(tool.getId()==null){
            return metodosCrud.save(tool);
        }else{
            Optional<Tool> e=metodosCrud.getTool(tool.getId());
            if(e.isEmpty()){
                return metodosCrud.save(tool);
            }else{
                return tool;
            }
        }
    }
    
    public Tool update(Tool tool){
        if(tool.getId()!=null){
            Optional<Tool> e=metodosCrud.getTool(tool.getId());
            if(!e.isEmpty()){
                if(tool.getName()!=null){
                    e.get().setName(tool.getName());
                }
                if(tool.getBrand()!=null){
                    e.get().setBrand(tool.getBrand());
                }
                if(tool.getYear()!=null){
                    e.get().setYear(tool.getYear());
                }
                if(tool.getDescription()!=null){
                    e.get().setDescription(tool.getDescription());
                }
                if(tool.getCategory()!=null){
                    e.get().setCategory(tool.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return tool;
            }
        }else{
            return tool;
        }
    }
    
    public boolean deleteTool(int toolId){
        Boolean aBoolean = getTool(toolId).map(tool -> {
            metodosCrud.delete(tool);
            return true;
        }).orElse(false);
        return aBoolean;
    
    }
}
    
    
