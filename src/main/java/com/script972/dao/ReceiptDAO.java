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
    private Statement statement;

    public ReceiptDAO() {
        DBConnector dbConnector=new DBConnector();
        this.connection = dbConnector.getConnection();
    }

    public List<Receipt> getAll(){
        String sqlQuery="select * from receipt";
        List<Receipt> list=new ArrayList<Receipt>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result=statement.executeQuery(sqlQuery);
            while (result.next()){
                Receipt receipt=new Receipt();
                receipt.setName(result.getString("name"));

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


}
