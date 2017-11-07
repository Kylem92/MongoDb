package com.kyle;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 30/10/2016.
 */
public class InsertToColl extends JFrame implements ActionListener {


    private JButton createButton;
    private JLabel name;
    private JLabel dob;
    private JLabel club;
    private JLabel achievements;
    private JLabel achievementsP;
    private JLabel dbname;
    private JLabel collName;

    private JTextField dbtxt;
    private JTextField colltxt;
    private JTextField nametxt;
    private JTextField dobtxt;
    private JTextField clubtxt;
    private JTextField achievementstxt;
    private JTextField achievementsPertxt;
    private String nameString, dobString, clubString, achievementsString, db, coll, personalAch;




    public InsertToColl(){
        Container cPane;
        setTitle("Insert to Collection");
        setSize(300,300);
        setResizable(true);
        setLocation(250,200);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());

        dbname = new JLabel("DB name:");
        cPane.add(dbname);


        dbtxt = new JTextField(5);
        cPane.add(dbtxt);

        collName = new JLabel("Collection name:");
        cPane.add(collName);


        colltxt = new JTextField(6);
        cPane.add(colltxt);

        name = new JLabel("name:");
        cPane.add(name);
        nametxt = new JTextField(5);
        cPane.add(nametxt);


        dob = new JLabel("dob:");
        cPane.add(dob);
        dobtxt = new JTextField(5);
        cPane.add(dobtxt);

        club = new JLabel("club:");
        cPane.add(club);
        clubtxt = new JTextField(5);
        cPane.add(clubtxt);

        achievements = new JLabel("Club achievements:");
        cPane.add(achievements);
        achievementstxt = new JTextField(10);
        cPane.add(achievementstxt);

        achievementsP = new JLabel("Personal achievements:");
        cPane.add(achievementsP);
        achievementsPertxt = new JTextField(10);
        cPane.add(achievementsPertxt);


        createButton = new JButton("Create");
        cPane.add(createButton);


        createButton.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void insert(JTextField dbtxt, JTextField colltxt, JTextField nametxt, JTextField dobtxt, JTextField clubtxt, JTextField achievementstxt, JTextField achievementsPertxt){
        db = dbtxt.getText();
        coll = colltxt.getText();
        nameString = nametxt.getText();
        dobString = dobtxt.getText();
        clubString = clubtxt.getText();
        achievementsString = achievementstxt.getText();
        personalAch = achievementsPertxt.getText();

        MongoClient myclient = new MongoClient("localhost", 27017);
        MongoDatabase database = myclient.getDatabase(db);
        MongoCollection collection = database.getCollection(coll);

        Document document = new Document();
        document.put("name", nameString);
        document.put("dob", dobString);
        document.put("club", clubString);

        Document achievements = new Document();
        achievements.put("club", achievementsString);
        achievements.put("personal", personalAch);

        document.put("achievements", achievements);

        collection.insertOne(document);
        myclient.close();





    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            insert(dbtxt, colltxt, nametxt, dobtxt, clubtxt, achievementstxt, achievementsPertxt);

        }
    }
}
