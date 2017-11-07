package com.kyle;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by Kyle on 01/11/2016.
 */
public class Update extends JFrame implements ActionListener {
    private JButton createButton;
    private JLabel name;
    private JLabel club;



    private JTextField nametxt;

    private JTextField clubtxt;

    private String nameString, clubString;




    public Update(){
        Container cPane;
        setTitle("Update Club");
        setSize(300,200);
        setResizable(true);
        setLocation(250,200);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());



        name = new JLabel("name:");
        cPane.add(name);
        nametxt = new JTextField(5);
        cPane.add(nametxt);

        club = new JLabel("club:");
        cPane.add(club);
        clubtxt = new JTextField(5);
        cPane.add(clubtxt);


        createButton = new JButton("Update Club");
        cPane.add(createButton);


        createButton.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void update(JTextField nametxt, JTextField clubtxt){
        nameString = nametxt.getText();
        clubString = clubtxt.getText();


        MongoClient myclient = new MongoClient("localhost", 27017);
        MongoDatabase database = myclient.getDatabase("db");
        MongoCollection collection = database.getCollection("players");

        collection.updateOne(eq("name", nameString), new Document("$set", new Document("club", clubString)));

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            update(nametxt, clubtxt);

        }
    }
}
