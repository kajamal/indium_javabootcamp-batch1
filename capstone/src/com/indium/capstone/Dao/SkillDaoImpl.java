package com.indium.capstone.Dao;

import com.indium.capstone.Model.Skill;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl implements SkillDao{
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public SkillDaoImpl() {

    }

    public Connection getConnection() {
        try {
            if(conn == null) {
                MysqlDataSource datasource = new MysqlDataSource();
                datasource.setServerName("localhost");
                datasource.setDatabaseName("TrackingApp");
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

    public Boolean create(Skill skill) {
        boolean status = false;
        try {
            String query = "INSERT INTO skilldetails (id,name,description, category, experiance) values(?,?,?,?,?)";

            pstmt = getConnection().prepareStatement(query);
            pstmt.setInt(1, skill.getId());
            pstmt.setString(2,skill.getName());
            pstmt.setString(3, skill.getDescription());
            pstmt.setString(4, skill.getCategory());
            pstmt.setInt(5, skill.getExperience());


            status = pstmt.executeUpdate() > 0 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean update(Skill skill) {
        boolean status = false;
        try {
            String query = "UPDATE skilldetails SET name =?,description=?,category=?,experiance =? WHERE Id= ?";
            pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1,skill.getName());
            pstmt.setString(2,skill.getDescription());
            pstmt.setString(3, skill.getCategory());
            pstmt.setInt(4, skill.getExperience());
            pstmt.setInt(5, skill.getId());

            status = pstmt.executeUpdate() > 0 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean delete(int skillID) {
        boolean status = false;
        try {
            stmt = getConnection().createStatement();

            String query = "DELETE FROM skilldetails WHERE skillid = " + skillID;

            status = stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}