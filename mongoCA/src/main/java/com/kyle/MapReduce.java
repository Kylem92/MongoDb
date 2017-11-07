package com.kyle;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 01/11/2016.
 */
public class MapReduce extends JFrame implements ActionListener {
    private JButton viewButton;
    private JTextArea txtArea;


    public MapReduce() {
        Container cPane;
        setTitle("MapReduce");
        setSize(350, 300);
        setResizable(true);
        setLocation(250, 200);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());





        viewButton = new JButton("MapReduce");
        cPane.add(viewButton);


        viewButton.addActionListener(this);
    }

    public void mapReduce()
    {


        String map ="function () {"+
                "emit('name', {count:1});"+
                "}";

        String reduce = "function(key, values) { " +
                "    return sum(values); " +
                "}";


        MongoClient myclient = new MongoClient("localhost", 27017);
        MongoDatabase database = myclient.getDatabase("db");
        MongoCollection collection = (MongoCollection) database.getCollection("players").mapReduce(map, reduce);

        txtArea.append(collection.toString());
        System.out.print(collection.toString());

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            mapReduce();
        }

    }
}
