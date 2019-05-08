/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Onitiana pc
 */
public class UtilDb {
    public static Connection getCon()
    {
        Connection connex = null;
        try 
        {
            Class.forName("org.postgresql.Driver"); 
            connex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jonatanahotel", "postgres","root");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connex;
    }
}
