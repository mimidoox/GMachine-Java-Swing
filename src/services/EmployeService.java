/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Employe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class EmployeService implements IDao<Employe>{

    @Override
    public boolean create(Employe o) {
         try {
            String sql = "insert into employe values (null,?,?,?,?)";
             PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
             ps.setString(1, o.getNom());
             ps.setString(2, o.getPrenom());
             ps.setString(3, o.getEmail());
             ps.setString(4, o.getPassword());
             
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Employe o) {
        try {
            String sql = "delete from employe where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1,o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employe o) {       
        try {
            String sql = "update employe set nom = ?, prenom = ?,email=? , password=? where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
             ps.setString(1, o.getNom());
             ps.setString(2, o.getPrenom());
             ps.setString(3, o.getEmail());
             ps.setString(4, o.getPassword());
             ps.setInt(5, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employe findById(int id) {
        try {
            String sql = "select * from employe where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),rs.getString("email"),rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employe> findAll() {
        List<Employe> employes = new ArrayList<Employe>();
        try {
            String sql = "select * from employe";
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                employes.add(new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),rs.getString("email"),rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employes;
    }
    
}
