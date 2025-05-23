/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logica;

import java.util.List;
import modelo.dao.DAOFavorito;
import modelo.vo.Favorito;

/**
 *
 * @author edwin
 */
public class LogicFavorito {

    DAOFavorito daoFavorito = new DAOFavorito();

    public boolean logicaEliminarFavorito(Favorito favorito) {
        return daoFavorito.daoEliminarFavoritos(favorito);
    }

    public boolean logicaAgregarFavorito(Favorito favorito) {
        return daoFavorito.daoAgregarFavoritos(favorito);
    }
    
    public List<Favorito> logicaBuscarFavoritos(int idCliente){
        return daoFavorito.daoBuscarFavoritosCliente(idCliente);
    }
    
    public Favorito logicaBuscarFavorito(int idCliente, int idHabitacion){
        return daoFavorito.daoBuscarFavorito(idCliente, idHabitacion);
    }
    
}
