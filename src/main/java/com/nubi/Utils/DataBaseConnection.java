package com.nubi.Utils;

import java.sql.*;

public class DataBaseConnection {

    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;

    public void iDataBaseConnection() throws SQLException{
        String url = "jdbc:postgresql://test-ec2-dev.tunubi.com:5434/registration";

        try{
            connection = DriverManager.getConnection(url,"postgres", null);
        }catch (SQLException e){
            e.getMessage();
        }
    }

    public String execute(String query, String field) throws SQLException{

        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);
        while (rs.next()){
            return rs.getString(field);
        }

        return rs.getString(1);
    }


    public void closeConecction() throws SQLException{
        if(rs!=null){
            rs.close();
        }
        if(stmt!=null){
            stmt.close();
        }
        if(connection!=null){
            connection.close();
        }
    }

}
