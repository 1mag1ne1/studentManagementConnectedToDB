package com.hohai.service;

import com.hohai.module.Student;
import com.hohai.util.MysqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentManagerService {
    public static Connection connection;
    public static PreparedStatement preparedStatement;

    public static ArrayList<Student> selectAllStudent(){
        ArrayList<Student> students = new ArrayList<>();
        try{
            connection = MysqlUtil.getConnectionMine();
            String sql ="select * from info";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                students.add(new Student(set.getInt(1),set.getString(2),set.getInt(3)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                MysqlUtil.closeMysql(connection,preparedStatement);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return students;
    }
    public static void deleteById(int id){
        try {
            connection = MysqlUtil.getConnectionMine();
            String sql = "delete from info where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            if( preparedStatement.executeUpdate()>0 ){
                System.out.println("delete successfully");
            }
            else {
                System.out.println("something wrong!!");
            }
        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            try{
                MysqlUtil.closeMysql(connection,preparedStatement);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void updateAdd(int id ,String name,int age){
        try {
            connection = MysqlUtil.getConnectionMine();
            String sql = "insert into info values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setInt(3,age);
            if( preparedStatement.executeUpdate()>0 ){
                System.out.println("add successfully");
            }
            else {
                System.out.println("something wrong!!");
            }
        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            try{
                MysqlUtil.closeMysql(connection,preparedStatement);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void modefyById(int id,String name,int age){
        try {
            connection = MysqlUtil.getConnectionMine();
            String sql = "update info set name=?,age=? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(3,id);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            if( preparedStatement.executeUpdate()>0 ){
                System.out.println("You've changed successfully");
            }
            else {
                System.out.println("something wrong!!");
            }
        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            try{
                MysqlUtil.closeMysql(connection,preparedStatement);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
