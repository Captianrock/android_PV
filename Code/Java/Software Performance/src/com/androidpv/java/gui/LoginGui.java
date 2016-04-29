package com.androidpv.java.gui;
import com.androidpv.java.database.dataBaseListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bradley on 4/8/2016.
 */
public class LoginGui extends JFrame{

    JButton blogin;
    JPanel loginpanel;
    JTextField txuser;
    JTextField pass;
    JButton newUser;
    JLabel username;
    JLabel password;

    public String puname;

    public LoginGui(){
        super("Login Authentication");
        dataBaseListener db = new dataBaseListener();
        blogin = new JButton("Login");
        loginpanel = new JPanel();
        txuser = new JTextField(15);
        pass = new JPasswordField(15);
        newUser = new JButton("New User?");
        username = new JLabel("Username:");
        password = new JLabel("Password:");

        setSize(300,200);
        setLocation(500,280);
        loginpanel.setLayout(null);

        newUser.setBounds(110,135,80,20);
        txuser.setBounds(70,30,150,20);
        pass.setBounds(70,65,150,20);
        blogin.setBounds(110,100,80,20);
        username.setBounds(5,28,80,20);
        password.setBounds(5,63,80,20);

        loginpanel.add(blogin);
        loginpanel.add(txuser);
        loginpanel.add(pass);
        loginpanel.add(newUser);
        loginpanel.add(username);
        loginpanel.add(password);

        getContentPane().add(loginpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        blogin.addActionListener(e -> {
                puname = txuser.getText();
                String ppasswd = pass.getText();

                if(db.checkMembership(puname , ppasswd) && !containsWhiteSpace(puname) && !containsWhiteSpace( ppasswd) ) {
                    createNotice("Please make sure Xposed is installed or else the framework will not work!");
                   PVView.instance = new PVView(puname);
                    dispose();
                }
                else if(puname.equals("") && ppasswd.equals("")){
                    JOptionPane.showMessageDialog(null,"Please insert Username and Password");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Wrong Username / Password");
                    txuser.setText("");
                    pass.setText("");
                    txuser.requestFocus();
                }
        });

        newUser.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                NewUser user = new NewUser();
                dispose();

            }
        });}

    public static boolean containsWhiteSpace(final String testCode){
        if(testCode != null){
            for(int i = 0; i < testCode.length(); i++){
                if(Character.isWhitespace(testCode.charAt(i))){
                    System.out.println("TRUE");
                    return true;
                }
            }
        }
        System.out.println("FALSE");
        return false;
    }

    public static void createNotice(String str){
        JOptionPane.showMessageDialog(null, str);
    }

    public static void main(String ... args){
       new LoginGui();
    }

}

