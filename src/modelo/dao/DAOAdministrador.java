/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.List;
import modelo.vo.Administrador;
import repositorio.RepAdministradores;

/**
 *
 * @author edwin
 */
public class DAOAdministrador {
    RepAdministradores repAdministrador = new RepAdministradores();

    public Administrador buscarPorId(int id) {
        return repAdministrador.search(id);
    }

}
