package com.kyle;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 30/10/2016.
 */
public class DropColl extends JFrame implements ActionListener {
    private JLabel name, collName;
    private JTextField dbtxt, colltxt;
    private JButton deleteButton;
    private String db1, coll1;

    public DropColl() {
        Container cPane;
        setTitle("Drop Collection");
        setSize(350, 300);
        setResizable(true);
        setLocation(250, 200);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());

        name = new JLabel("DB name:");
        cPane.add(name);


        dbtxt = new JTextField(20);
        cPane.add(dbtxt);

        collName = new JLabel("Collection name:");
        cPane.add(collName);


        colltxt = new JTextField(20);
        cPane.add(colltxt);


        deleteButton = new JButton("Delete Collection");
        cPane.add(deleteButton);


        deleteButton.addActionListener(this);
    }
    public void deleteColl(JTextField dbt, JTextField colltxt) {
        db1 = dbt.getText();
        coll1 = colltxt.getText();
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase db = mongoClient.getDatabase(db1);
        db.getCollection(coll1).drop();


    }

    public void actionPerformed(ActionEvent e) {
        deleteColl(dbtxt, colltxt);

    }
}
