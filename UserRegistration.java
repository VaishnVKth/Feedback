package net.javaguides.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.border.EmptyBorder;


public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField stay;
    private JTextField restorating;
    private JTextField cleanliness;
    private JTextField rent;
    private JTextField servquality;

    private JButton btnNewButton;
 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

     
        
        JLabel lblFeedbackForm = new JLabel("Hotel Feedback Form");
        lblFeedbackForm.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblFeedbackForm.setBounds(322, 12, 525, 50);
        contentPane.add(lblFeedbackForm);
        
        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblName.setBounds(38, 70, 79, 20);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(38, 110, 160, 20);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Reviewer Email");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEmailAddress.setBounds(38, 150, 124, 20);
        contentPane.add(lblEmailAddress);
        
        JLabel lblday = new JLabel("Number of days of stay");
        lblday.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblday.setBounds(38, 190, 124, 20);
        contentPane.add(lblday);
        
        JLabel lblrate = new JLabel("Rating:  (poor/very poor/good/better/best)");
        lblrate.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblrate.setBounds(390, 230, 624, 20);
        contentPane.add(lblrate);
        
        JLabel lblrating = new JLabel("How would you rate this Restaurant overall?");
        lblrating.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblrating.setBounds(38, 270, 624, 20);
        contentPane.add(lblrating);
        
        JLabel lblclean = new JLabel("How was the cleanliness?");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblclean.setBounds(700, 270, 624, 20);
        contentPane.add(lblclean);

        JLabel lblprice = new JLabel("How was rent?");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblprice.setBounds(38, 350, 624, 20);
        contentPane.add(lblprice);
        
        JLabel lblquality = new JLabel("How was the quality of service?");
        lblquality.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblquality.setBounds(700, 350, 624, 20);
        contentPane.add(lblquality);
        
        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        firstname.setBounds(150, 70, 160, 25);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lastname.setBounds(150, 110, 160, 25);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        email.setBounds(150, 150, 160, 25);
        contentPane.add(email);
        email.setColumns(10);
        
        stay = new JTextField();
        stay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        stay.setBounds(180, 190, 160, 25);
        contentPane.add(stay);
        stay.setColumns(10);
        
        restorating = new JTextField();
        restorating.setFont(new Font("Tahoma", Font.PLAIN, 14));
        restorating.setBounds(38, 300, 250, 25);
        contentPane.add(restorating);
        restorating.setColumns(10);
        
        cleanliness = new JTextField();
        cleanliness.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cleanliness.setBounds(700, 300, 250, 25);
        contentPane.add(cleanliness);
        cleanliness.setColumns(10);
        
        rent = new JTextField();
        rent.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rent.setBounds(38, 380, 250, 25);
        contentPane.add(rent);
        rent.setColumns(10);
        
        servquality = new JTextField();
        servquality.setFont(new Font("Tahoma", Font.PLAIN, 14));
        servquality.setBounds(700, 380, 250, 25);
        contentPane.add(servquality);
        servquality.setColumns(10);


        

        
        
        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String day = stay.getText();
                String rating = restorating.getText();
                String clean = cleanliness.getText();
                String price = rent.getText();
                String quality = servquality.getText();
                
                String msg = "" + firstName;           				
                msg += " \n";
                

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/feed", "root", "vaishu");

                    String query = "INSERT INTO hotelfeedback values('" + firstName + "','" + lastName + "','" + emailId + "','" + day + "','" + rating
                    		+ "', '" +
                    		clean + "','" + price + "', '" + quality + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Thankyou!, " + msg + "Your feedback is sucessfully recorded");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
    }
}