package com.kyle;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Amanda on 03/11/2016.
 */
public class DeletePlayer extends JFrame implements ActionListener {
    private JButton deletePlayer;
    private JLabel name;
    private JTextField nametxt;
    private String nameString;




    public DeletePlayer(){
        Container cPane;
        setTitle("Delete Player");
        setSize(300,200);
        setResizable(true);
        setLocation(250,200);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());



        name = new JLabel("name:");
        cPane.add(name);
        nametxt = new JTextField(5);
        cPane.add(nametxt);


        deletePlayer = new JButton("Delete Player");
        cPane.add(deletePlayer);


        deletePlayer.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void delete(JTextField nametxt){
        nameString = nametxt.getText();

        MongoClient myclient = new MongoClient("localhost", 27017);
        MongoDatabase database = myclient.getDatabase("db");
        MongoCollection collection = database.getCollection("players");

        BasicDBObject document = new BasicDBObject();
        document.put("name", nameString);
        collection.deleteOne(document);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==deletePlayer){
            delete(nametxt);
        }

    }
}
