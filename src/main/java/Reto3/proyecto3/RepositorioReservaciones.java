/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RepositorioReservaciones {
    @Autowired
    private InterfaceReservaciones crud4;
    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();}
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);}
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);}
    public void delete(Reservaciones reservation){
        crud4.delete(reservation);}
}
