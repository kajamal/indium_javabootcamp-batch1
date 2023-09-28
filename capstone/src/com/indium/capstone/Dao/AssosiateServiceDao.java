package com.indium.capstone.Dao;

import com.indium.capstone.Model.Associate;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssosiateServiceDao implements Associateinterface{

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public Connection getConnection() {
        try {
            if(conn == null) {
                MysqlDataSource datasource = new MysqlDataSource();
                datasource.setServerName("localhost");
                datasource.setDatabaseName("Trackingapp");
                datasource.setUser("root");
                datasource.setPassword("Kaja@0005");


                conn = datasource.getConnection();
                System.out.println("Connection created successfully. " + conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    @Override
    public Boolean create(Associate associate) {
        boolean status = false;
        try {

            String query = "INSERT INTO AssociateDetails (id ,name, age, BusinessUnit, email, location) values(?,?,?,?,?,?)";
            pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, associate.getId());
            pstmt.setString(2, associate.getName());
            pstmt.setInt(3, associate.getAge());
            pstmt.setString(4, associate.getBusinessUnit());
            pstmt.setString(5, associate.getEmail());
            pstmt.setString(6, associate.getLocation());
            System.out.println("Data created and Stored successfully");

            status = pstmt.executeUpdate() > 0 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


    @Override
    public Boolean update(Associate associate) {
        boolean status = false;
        try {

            String query = "UPDATE AssociateDetails SET name = ?, age = ?, BusinessUnit = ?, email = ? , location = ? WHERE id = ?";
            pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, associate.getName());
            pstmt.setInt(2, associate.getAge());
            pstmt.setString(3, associate.getBusinessUnit());
            pstmt.setString(4, associate.getEmail());
            pstmt.setString(5, associate.getLocation());
            pstmt.setInt(6, associate.getId());

            status = pstmt.executeUpdate() > 0 ? true : false;
            System.out.println("Data  update successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean delete(int id) {
        boolean status = false;
        try {
            stmt = getConnection().createStatement();

            String query = "DELETE FROM AssociateDetails WHERE id = " + id;

            status = stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    @Override
    public List<Associate> getall() {
        List<Associate> accounts = new ArrayList<>();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM AssociateDetails");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String businessUnit = rs.getString("BusinessUnit");
                String email = rs.getString("email");
                String location = rs.getString("location");
                accounts.add(new Associate(id,name, age, businessUnit, email,location));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

}
