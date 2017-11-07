package com.kyle;

import com.mongodb.MongoClient;
import com.mongodb.operation.CreateCollectionOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 30/10/2016.
 */
public class createColl extends JFrame implements ActionListener{

    private JLabel name, collName;
    private JTextField dbtxt, colltxt;
    private JButton createButton;
    private String db1, coll1;

    public createColl() {
        Container cPane;
        setTitle("Create DB collection");
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



        createButton = new JButton("CreateDb");
        cPane.add(createButton);


        createButton.addActionListener(this);
    }
    public void createDbColl(JTextField dbt, JTextField collt) {
        coll1 = collt.getText();
        db1 = dbt.getText();
        MongoClient mongoClient = new MongoClient("localhost",27017);
        CreateCollectionOperation coll = new CreateCollectionOperation(db1, coll1);
        System.out.println("Collection to database " + db1+ " called " + coll1);


    }




    public void actionPerformed(ActionEvent e) {
        createDbColl(dbtxt,colltxt);
    }
}
