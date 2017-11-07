package com.kyle;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 26/10/2016.
 */
public class createDb extends JFrame implements ActionListener {
    private JLabel name;
    private JTextField dbtxt;
    private JButton createButton;
    private String db1;

    public createDb() {
        Container cPane;
        setTitle("Create DB");
        setSize(350, 300);
        setResizable(true);
        setLocation(250, 200);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());

        name = new JLabel("DB name:");
        cPane.add(name);


        dbtxt = new JTextField(20);
        cPane.add(dbtxt);



        createButton = new JButton("CreateDb");
        cPane.add(createButton);


        createButton.addActionListener(this);
    }
    public void createDb(JTextField dbt) {
        db1 = dbt.getText();
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase db = mongoClient.getDatabase(db1);
        System.out.println("Connected to database " + db1+ " successfully");


    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton)
            createDb(dbtxt);
            this.setVisible(false);

    }
}
