/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.*;

/**
 *
 * @author admin
 */
public class StudentRegistrationForm {

    JFrame jFrameSRF;

    JLabel jLabelName, jLabelEnrollmentNo, jLabelSemester, jLabelGender, jlabelEmailID, jLabelDepartment;
    JLabel jLabelHobbies, jLabelPassword, jLabelMobileNo;

    JTextField textFieldName, textFieldEnrollmentNo, textFieldEmailID, textFieldMobileNo;

    JPasswordField passwordField;

    JRadioButton radioButtonMale, radioButtonFemale, radioButtonOther;
    ButtonGroup buttonGroupgender;

    JComboBox<String> comboBoxSemester, comboBoxDepartment;

    JCheckBox checkBoxReading, checkBoxTraveling, checkBoxSports;

    JLabel jLabelValidationEnrollmentNo, jLabelValidationName, jLabelValidationEmailID, jLabelValidationMobileNo, jLabelValidationPassword;

    JButton buttonSubmit, buttonClear;
    JPanel jpMainPanel;

    int i = 0;

    public StudentRegistrationForm() {
        jFrameSRF = new JFrame("Student Registration");
        jFrameSRF.setSize(800, 500);
        jFrameSRF.setLayout(null);
        jFrameSRF.setVisible(true);

        jpMainPanel = new JPanel();
        jpMainPanel.setLayout(null);
        jpMainPanel.setBounds(0, 0, 800, 500);
        jFrameSRF.add(jpMainPanel);

        jLabelEnrollmentNo = new JLabel("Enrollment No:");
        jLabelName = new JLabel("Name:");
        jlabelEmailID = new JLabel("Email:");
        jLabelMobileNo = new JLabel("Mobile No:");
        jLabelPassword = new JLabel("Password:");
        jLabelGender = new JLabel("Gender:");
        jLabelDepartment = new JLabel("Department:");
        jLabelSemester = new JLabel("Semester:");
        jLabelHobbies = new JLabel("Hobbies:");

        jLabelEnrollmentNo.setBounds(50, 50, 100, 25);
        jLabelName.setBounds(50, 100, 100, 25);
        jlabelEmailID.setBounds(50, 150, 100, 25);
        jLabelMobileNo.setBounds(50, 200, 100, 25);
        jLabelPassword.setBounds(50, 250, 100, 25);
        jLabelGender.setBounds(50, 300, 100, 25);
        jLabelDepartment.setBounds(50, 350, 100, 25);
        jLabelSemester.setBounds(50, 400, 100, 25);
        jLabelHobbies.setBounds(50, 450, 100, 25);

        jpMainPanel.add(jLabelEnrollmentNo);
        jpMainPanel.add(jLabelName);
        jpMainPanel.add(jlabelEmailID);
        jpMainPanel.add(jLabelMobileNo);
        jpMainPanel.add(jLabelPassword);
        jpMainPanel.add(jLabelGender);
        jpMainPanel.add(jLabelDepartment);
        jpMainPanel.add(jLabelSemester);
        jpMainPanel.add(jLabelHobbies);

        textFieldEnrollmentNo = new JTextField();
        textFieldName = new JTextField();
        textFieldEmailID = new JTextField();
        textFieldMobileNo = new JTextField();
        passwordField = new JPasswordField();

        textFieldEnrollmentNo.setBounds(200, 50, 200, 25);
        textFieldName.setBounds(200, 100, 200, 25);
        textFieldEmailID.setBounds(200, 150, 200, 25);
        textFieldMobileNo.setBounds(200, 200, 200, 25);
        passwordField.setBounds(200, 250, 200, 25);

        jpMainPanel.add(textFieldEnrollmentNo);
        jpMainPanel.add(textFieldName);
        jpMainPanel.add(textFieldEmailID);
        jpMainPanel.add(textFieldMobileNo);
        jpMainPanel.add(passwordField);

        radioButtonMale = new JRadioButton("Male");
        radioButtonFemale = new JRadioButton("Female");
        radioButtonOther = new JRadioButton("Other");
        radioButtonMale.setSelected(true);

        buttonGroupgender = new ButtonGroup();
        buttonGroupgender.add(radioButtonMale);
        buttonGroupgender.add(radioButtonFemale);
        buttonGroupgender.add(radioButtonOther);

        radioButtonMale.setBounds(200, 300, 80, 25);
        radioButtonFemale.setBounds(280, 300, 80, 25);
        radioButtonOther.setBounds(360, 300, 80, 25);

        jpMainPanel.add(radioButtonMale);
        jpMainPanel.add(radioButtonFemale);
        jpMainPanel.add(radioButtonOther);

        String[] departments = {"Computer Engineering", "Electrical Engineering", "Mechanical Engineering", "Civil Engineering", "Other"};
        comboBoxDepartment = new JComboBox<>(departments);
        comboBoxDepartment.setBounds(200, 350, 200, 25);
        jpMainPanel.add(comboBoxDepartment);

        String[] semesters = {"1", "2", "3", "4", "5", "6", "7", "8"};
        comboBoxSemester = new JComboBox<>(semesters);
        comboBoxSemester.setBounds(200, 400, 200, 25);
        jpMainPanel.add(comboBoxSemester);

        checkBoxReading = new JCheckBox("Reading");
        checkBoxTraveling = new JCheckBox("Traveling");
        checkBoxSports = new JCheckBox("Sports");

        checkBoxReading.setBounds(200, 450, 100, 25);
        checkBoxTraveling.setBounds(300, 450, 100, 25);
        checkBoxSports.setBounds(400, 450, 100, 25);

        jpMainPanel.add(checkBoxReading);
        jpMainPanel.add(checkBoxTraveling);
        jpMainPanel.add(checkBoxSports);

        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(200, 500, 100, 30);
        jpMainPanel.add(buttonSubmit);

        buttonClear = new JButton("Clear");
        buttonClear.setBounds(330, 500, 100, 30);
        jpMainPanel.add(buttonClear);

        jLabelValidationEnrollmentNo = new JLabel("Enter Enrollment No.");
        jLabelValidationEnrollmentNo.setBounds(410, 50, 200, 25);
        jLabelValidationEnrollmentNo.setVisible(false);
        jpMainPanel.add(jLabelValidationEnrollmentNo);

        jLabelValidationName = new JLabel("Enter Name");
        jLabelValidationName.setBounds(410, 100, 200, 25);
        jLabelValidationName.setVisible(false);
        jpMainPanel.add(jLabelValidationName);

        jLabelValidationEmailID = new JLabel("Enter Email");
        jLabelValidationEmailID.setBounds(410, 150, 200, 25);
        jLabelValidationEmailID.setVisible(false);
        jpMainPanel.add(jLabelValidationEmailID);

        jLabelValidationMobileNo = new JLabel("Enter MobileNo");
        jLabelValidationMobileNo.setBounds(410, 200, 200, 25);
        jLabelValidationMobileNo.setVisible(false);
        jpMainPanel.add(jLabelValidationMobileNo);

        jLabelValidationPassword = new JLabel("Enter Password");
        jLabelValidationPassword.setVisible(false);
        jLabelValidationPassword.setBounds(410, 250, 200, 25);
        jpMainPanel.add(jLabelValidationPassword);

        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldEnrollmentNo.getText().equals("")) {
                    jLabelValidationEnrollmentNo.setForeground(Color.RED);
                    jLabelValidationEnrollmentNo.setVisible(true);
                    //JOptionPane.showMessageDialog(jFrameSRF, "Enter enrollment no");
                    i++;
                }
                if (textFieldName.getText().equals("")) {
                    jLabelValidationName.setForeground(Color.RED);
                    jLabelValidationName.setVisible(true);
                    i++;
                }
                if (textFieldEmailID.getText().equals("")) {
                    jLabelValidationEmailID.setForeground(Color.RED);
                    jLabelValidationEmailID.setVisible(true);
                    i++;
                }
                if (textFieldMobileNo.getText().equals("")) {
                    jLabelValidationMobileNo.setForeground(Color.RED);
                    jLabelValidationMobileNo.setVisible(true);
                    i++;
                }
                if (passwordField.getPassword().length == 0) {
                    jLabelValidationPassword.setForeground(Color.RED);
                    jLabelValidationPassword.setVisible(true);
                    i++;
                }

                if (i == 0) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String url, username, password;
                        url = "jdbc:mysql://localhost:3306/Student";
                        username = "root";
                        password = "";
                        Connection conn = DriverManager.getConnection(url, username, password);

                        CallableStatement cs = conn.prepareCall("{call reg(?,?,?,?,?,?,?,?)}");
                        cs.setInt(1, Integer.parseInt(textFieldEnrollmentNo.getText()));
                        cs.setString(2, textFieldName.getText());
                        cs.setString(3, textFieldEmailID.getText());
                        cs.setInt(4, Integer.parseInt(textFieldMobileNo.getText()));
                        if (radioButtonFemale.isSelected()) {
                            cs.setString(5, "Female");

                        } else if (radioButtonMale.isSelected()) {
                            cs.setString(5, "Male");

                        } else {
                            cs.setString(5, "Other");

                        }
                        cs.setString(6, (String) comboBoxDepartment.getSelectedItem());
                        cs.setInt(7, Integer.parseInt((String) comboBoxSemester.getSelectedItem()));
                        String Hobbies = "";
                        if (checkBoxReading.isSelected()) {
                            Hobbies += "Reading ";
                        }
                        if (checkBoxSports.isSelected()) {
                            Hobbies += "Sports ";

                        }
                        if (checkBoxTraveling.isSelected()) {
                            Hobbies += "Travelling ";
                        } else {
                            Hobbies += "Not Selected";
                        }
                        cs.setString(8, Hobbies);
                        boolean b=cs.execute();
                        if(b==true)
                        {
                        JOptionPane.showMessageDialog(jFrameSRF, "Recored not inserted successfully");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(jFrameSRF, " Recored inserted successfully");

                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldEmailID.setText("");
                textFieldEnrollmentNo.setText("");
                textFieldMobileNo.setText("");
                textFieldName.setText("");
                passwordField.setText("");
                radioButtonMale.setSelected(true);
                comboBoxSemester.setSelectedIndex(0);
                comboBoxDepartment.setSelectedIndex(0);
                checkBoxReading.setSelected(true);
                checkBoxSports.setSelected(false);
                checkBoxTraveling.setSelected(false);

                jLabelValidationEnrollmentNo.setVisible(false);
                jLabelValidationName.setVisible(false);
                jLabelValidationMobileNo.setVisible(false);
                jLabelValidationPassword.setVisible(false);
                jLabelValidationEmailID.setVisible(false);
            }
        });

        JScrollPane scrollPane = new JScrollPane(jpMainPanel);
        scrollPane.setBounds(0, 0, 800, 500);

        jpMainPanel.setPreferredSize(new Dimension(800, 600));
        jFrameSRF.add(scrollPane);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new StudentRegistrationForm();
    }

}
