package com.example.boletimescolar;

import android.os.AsyncTask;
import android.os.ResultReceiver;

import java.sql.Connection;
import java.sql.ResultSet;

public class executeDB extends AsyncTask<String, Void, ResultSet> {

    private Connection connection;
    private String query;

    public executeDB(Connection connection, String query){
        this.connection = connection;
        this.query = query;
    }

    @Override
    protected ResultSet doInBackground(String... strings) {
        ResultSet resultSet = null;

        try {
            resultSet = connection.prepareStatement(query).executeQuery();
        }catch (Exception e){

        }finally {
            try {
                connection.close();
            }catch (Exception ex){

            }
        }
        return  resultSet;
    }
}
