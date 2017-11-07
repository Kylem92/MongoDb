package com.kyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 26/10/2016.
 */

    public class GUI extends JFrame implements ActionListener {

        private JButton createDbButton;
        private JButton deleteButton;
        private JButton insertButton;
        private JButton createCollButton;
        private JButton updateDocButton;
        private JButton mapReduceModel;
        private JButton view;
        private JButton deletePlayer;

        public static void main(String[] args){
            GUI gui = new GUI();
            gui.setVisible(true);

        }

        public GUI(){
            Container cPane;
            setTitle("Players");
            setSize(300,300);
            setResizable(true);
            setLocation(250,200);

            cPane = getContentPane();
            cPane.setLayout(new FlowLayout());

            createDbButton = new JButton("Create Db");
            cPane.add(createDbButton);
            createCollButton = new JButton("Create Collection");
            cPane.add(createCollButton);
            deleteButton = new JButton("Drop Collection");
            cPane.add(deleteButton);
            insertButton = new JButton("Insert Player");
            cPane.add(insertButton);
            deletePlayer = new JButton("Delete Player");
            cPane.add(deletePlayer);
            updateDocButton = new JButton("Update Player");
            cPane.add(updateDocButton);
            mapReduceModel = new JButton("MapReduce");
            cPane.add(mapReduceModel);
            view = new JButton("View By Name");
            cPane.add(view);

            createDbButton.addActionListener(this);
            deleteButton.addActionListener(this);
            insertButton.addActionListener(this);
            deletePlayer.addActionListener(this);
            createCollButton.addActionListener(this);
            updateDocButton.addActionListener(this);
            mapReduceModel.addActionListener(this);
            view.addActionListener(this);

            setDefaultCloseOperation(EXIT_ON_CLOSE);

        }


        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == createDbButton ) {
                createDb db = new createDb();
                db.setVisible(true);
            }
            else if (e.getSource() == deleteButton ) {
                DropColl db3 = new DropColl();
                db3.setVisible(true);
            }
            else if (e.getSource() == insertButton) {
                InsertToColl db2 = new InsertToColl();
                db2.setVisible(true);
            }
            else if (e.getSource() == createCollButton ) {
                createColl db1 = new createColl();
                db1.setVisible(true);
            }
            else if (e.getSource() == updateDocButton ) {
                Update db4 = new Update();
                db4.setVisible(true);

            }
            else if (e.getSource() == mapReduceModel ) {
                MapReduce db5 = new MapReduce();
                db5.setVisible(true);
            }
            else if (e.getSource() == view ) {


            }
            else if (e.getSource()== deletePlayer){
                DeletePlayer db6 = new DeletePlayer();
                db6.setVisible(true);


            }




        }


}

