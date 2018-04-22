package com.script972.dao;

import com.script972.util.DBConnector;
import com.script972.entity.Receipt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReceiptDAO {
    private Connection connection;
    private Connection connection2;
    private Statement statement;

    public ReceiptDAO() {
        DBConnector dbConnector=new DBConnector();
        this.connection = dbConnector.getConnection();
        this.connection2=dbConnector.getConnection2();
    }

    public List<Receipt> getAll(){
        String sqlQuery="select * from receipt ";
        List<Receipt> list=new ArrayList<Receipt>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result=statement.executeQuery(sqlQuery);
            while (result.next()){
                Receipt receipt=new Receipt();
                receipt.setId(result.getLong("id"));
                receipt.setName(result.getString("name"));
                receipt.setTown(result.getString("town"));
                receipt.setPassportSer(result.getString("passport_ser"));
                receipt.setNumber(result.getInt("number"));
                receipt.setTake(result.getString("take"));
                receipt.setHome(result.getString("home"));
                receipt.setLandlord(result.getString("landlord"));
                receipt.setSumm(result.getString("sum"));
                receipt.setDateEpire(result.getString("dateExpire"));
                list.add(receipt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Receipt receipt){
        String sqlQuery="INSERT INTO " +
                "receipt(name, town, passport_ser, number, take, home, landlord, sum, dateExpire) " +
                "VALUES ('" +
                receipt.getName()+"', '"+receipt.getTown()+"' , '"+receipt.getPassportSer()+"', "+receipt.getNumber()+", '"
                +receipt.getTake()+"', '"+receipt.getHome()+"', '"
                +receipt.getLandlord()+"', '"+receipt.getSumm()+"', '"+receipt.getDateEpire()+"')";
       /* String sqlQuery="INSERT INTO " +
                "receipt(name, town) " +
                "VALUES ('" + receipt.getName()+"', '"+receipt.getTown()+"')";*/
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAll(List<Receipt> receipts){
        for (Receipt item:
             receipts) {
            insert(item);
        }
    }


    public List<Receipt> filterById(int filtId) {
        List<Receipt> list = new ArrayList<Receipt>();
        try {
            connection.setAutoCommit(false);
            connection2.setAutoCommit(false);

            String sqlQuery = "select * from receipt WHERE id=" + filtId;
            String sqlLog = "INSERT INTO searcher(type_searcher, searcher_word) VALUES (1, " + filtId + ");";

            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sqlQuery);

                Statement statementLog = connection2.createStatement();
                statementLog.executeUpdate(sqlLog);
                while (result.next()) {
                    Receipt receipt = new Receipt();
                    receipt.setId(result.getLong("id"));
                    receipt.setName(result.getString("name"));
                    receipt.setTown(result.getString("town"));
                    receipt.setPassportSer(result.getString("passport_ser"));
                    receipt.setNumber(result.getInt("number"));
                    receipt.setTake(result.getString("take"));
                    receipt.setHome(result.getString("home"));
                    receipt.setLandlord(result.getString("landlord"));
                    receipt.setSumm(result.getString("sum"));
                    receipt.setDateEpire(result.getString("dateExpire"));

                    list.add(receipt);
                }
                connection.commit();
                connection2.commit();

            } catch (SQLException e) {
                e.printStackTrace();

            }
            return list;
        } catch (SQLException e) {
            try {
                connection2.rollback();
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return list;
    }

        public List<Receipt> filterByName(String name) {
        String sqlQuery="select * from receipt WHERE name='"+name+"';";
        List<Receipt> list=new ArrayList<Receipt>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result=statement.executeQuery(sqlQuery);
            while (result.next()){
                Receipt receipt=new Receipt();
                receipt.setId(result.getLong("id"));
                receipt.setName(result.getString("name"));
                receipt.setTown(result.getString("town"));
                receipt.setPassportSer(result.getString("passport_ser"));
                receipt.setNumber(result.getInt("number"));
                receipt.setTake(result.getString("take"));
                receipt.setHome(result.getString("home"));
                receipt.setLandlord(result.getString("landlord"));
                receipt.setSumm(result.getString("sum"));
                receipt.setDateEpire(result.getString("dateExpire"));

                list.add(receipt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
