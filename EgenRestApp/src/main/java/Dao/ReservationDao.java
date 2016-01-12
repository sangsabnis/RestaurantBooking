/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DB.DBUtil;
import Exception.MyException;
import Model.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author Sangram
 */
public class ReservationDao {

    public ArrayList<Reservation> findAll() throws MyException {
        ArrayList <Reservation> allReservations = new ArrayList();
        Connection con = DBUtil.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("select * from reservation");
            rs=ps.executeQuery();
            while(rs.next()){   
                Reservation res = new Reservation();
                res.setID(rs.getInt("ID"));
                res.setFirstName(rs.getString("FIRST_NAME"));
                res.setLastName(rs.getString("LAST_NAME"));
                res.setEmail(rs.getString("EMAIL"));
                res.setPhone(rs.getString("PHONE"));
                res.setDateTime(rs.getString("DATETIME"));
                res.setPartySize(rs.getString("PARTY_SIZE"));
                res.setTableNumber(rs.getInt("TABLE_NUMBER"));
                allReservations.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MyException(e.getMessage());
        }
        //Error if not commented
        finally{
            
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    if (con != null) {
                        con.close();
                    }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new MyException(e.getMessage());
            }
        }
        return allReservations;
    }

    public Reservation findSingle(int id) throws MyException, NotFoundException {
        Connection con = DBUtil.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reservation res = new Reservation();
        try {
            ps = con.prepareStatement("select * from reservation where ID=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                
                res.setID(rs.getInt("ID"));
                res.setFirstName(rs.getString("FIRST_NAME"));
                res.setLastName(rs.getString("LAST_NAME"));
                res.setEmail(rs.getString("EMAIL"));
                res.setPhone(rs.getString("PHONE"));
                res.setDateTime(rs.getString("DATETIME"));
                res.setPartySize(rs.getString("PARTY_SIZE"));
                res.setTableNumber(rs.getInt("TABLE_NUMBER"));
            }else{
                throw new NotFoundException("There is no such reservation related to this ID");
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new MyException(ex.getMessage());
        }        
        finally{
            
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    if (con != null) {
                        con.close();
                    }
            } catch (SQLException e) {
                e.printStackTrace();
                //throw new MyException(e.getMessage());
            }
        }
        return res;
    }

    public Reservation create(Reservation res) throws MyException {
        Connection con = DBUtil.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
           ps = con.prepareStatement("INSERT INTO reservation (FIRST_NAME, LAST_NAME, EMAIL, PHONE, DATETIME, PARTY_SIZE,TABLE_NUMBER) VALUES (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
           ps.setString(1, res.getFirstName());
           ps.setString(2, res.getLastName());
           ps.setString(3, res.getEmail());
           ps.setString(4, res.getPhone());
           ps.setString(5, res.getDateTime());
           ps.setString(6, res.getPartySize());
           ps.setInt(7, res.getTableNumber());
           ps.executeUpdate();
           rs = ps.getGeneratedKeys();
           if(rs.next()){
               res.setID(rs.getInt(1));
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //throw new MyException(ex.getMessage());
        }
        finally {

            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public Reservation update(int id, Reservation res) throws MyException {
        
        Connection con = DBUtil.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //Reservation res = new Reservation();
        ReservationDao dao = new ReservationDao();
        Reservation temp = dao.findSingle(id);
        if(temp==null){
            return null;
        }
        try {
            ps = con.prepareStatement("UPDATE reservation SET FIRST_NAME=?, LAST_NAME=?, EMAIL=?, PHONE=?, DATETIME=?, PARTY_SIZE=?, TABLE_NUMBER=? WHERE ID=?");
            ps.setString(1, res.getFirstName());
            ps.setString(2, res.getLastName());
            ps.setString(3, res.getEmail());
            ps.setString(4, res.getPhone());
            ps.setString(5, res.getDateTime());
            ps.setString(6, res.getPartySize());
            ps.setInt(7, res.getTableNumber());
            ps.setInt(8, id);
            ps.executeUpdate();
//            rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                res.setID(rs.getInt(1));
//                //System.out.println("Test Output" +rs.getInt(1));
//            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MyException(ex.getMessage());
        } finally {

            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                //throw new MyException(e.getMessage());
            }
        }
        res = dao.findSingle(id);
        return res;
        
    }

    public void delete(int id) throws MyException {
        Connection con = DBUtil.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = con.prepareStatement("delete from reservation where ID=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MyException(ex.getMessage());
        } finally {

            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                //throw new MyException(e.getMessage());
            }
        }

    }
    
}