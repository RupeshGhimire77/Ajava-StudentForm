package com.bca6th.databaseconnection.studentform;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.bca6th.databaseconnection.studentmodel.Student;
import com.bca6th.databaseconnection.studentservice.StudentService;
import com.bca6th.databaseconnection.studentservice.StudentServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class StudentForm1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm1 frame = new StudentForm1();
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
	public StudentForm1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1460, 838);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblName.setBounds(111, 65, 150, 35);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblAddress.setBounds(111, 135, 150, 35);
		contentPane.add(lblAddress);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblContact.setBounds(111, 202, 150, 35);
		contentPane.add(lblContact);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblGender.setBounds(111, 281, 150, 35);
		contentPane.add(lblGender);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSection.setBounds(111, 358, 150, 35);
		contentPane.add(lblSection);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSubject.setBounds(111, 442, 150, 35);
		contentPane.add(lblSubject);
		
		JTextArea nameTextArea = new JTextArea();
		nameTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		nameTextArea.setBounds(261, 65, 308, 35);
		contentPane.add(nameTextArea);
		
		JTextArea addressTextArea = new JTextArea();
		addressTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		addressTextArea.setBounds(261, 136, 308, 35);
		contentPane.add(addressTextArea);
		
		JTextArea contactTextArea = new JTextArea();
		contactTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		contactTextArea.setBounds(261, 202, 308, 35);
		contentPane.add(contactTextArea);
		
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Times New Roman", Font.BOLD, 24));
		rdbtnMale.setBounds(258, 281, 111, 35);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Times New Roman", Font.BOLD, 24));
		rdbtnFemale.setBounds(371, 281, 111, 35);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setFont(new Font("Times New Roman", Font.BOLD, 24));
		rdbtnOthers.setBounds(484, 281, 111, 35);
		contentPane.add(rdbtnOthers);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		bg.add(rdbtnOthers);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BCA", "CSIT", "BIM"}));
		comboBox.setBounds(271, 358, 298, 35);
		contentPane.add(comboBox);
		
		JCheckBox cProgramCheckBox = new JCheckBox("C Programming");
		cProgramCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		cProgramCheckBox.setBounds(267, 442, 198, 35);
		contentPane.add(cProgramCheckBox);
		
		JCheckBox javaCheckBox = new JCheckBox("Java");
		javaCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		javaCheckBox.setBounds(486, 442, 198, 35);
		contentPane.add(javaCheckBox);
		
		JCheckBox aJavaCheckBox = new JCheckBox("Advance Java");
		aJavaCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		aJavaCheckBox.setBounds(267, 497, 198, 35);
		contentPane.add(aJavaCheckBox);
		
		JCheckBox dotnetCheckBox = new JCheckBox("DotNet");
		dotnetCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		dotnetCheckBox.setBounds(484, 497, 198, 35);
		contentPane.add(dotnetCheckBox);
		
		JCheckBox scriptingLanguageCheckBox = new JCheckBox("Scripting Language");
		scriptingLanguageCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		scriptingLanguageCheckBox.setBounds(267, 547, 231, 35);
		contentPane.add(scriptingLanguageCheckBox);
		
		JButton btnSubmitButton = new JButton("Submit");
		btnSubmitButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnSubmitButton.setBounds(271, 651, 158, 54);
		contentPane.add(btnSubmitButton);
		
		JButton btnNewButton = new JButton("Cancel");
	
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentDetails details= new StudentDetails();
				details.setVisible(true);
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(484, 656, 144, 48);
		contentPane.add(btnNewButton);
		ActionListener a1= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = nameTextArea.getText();
				String  address= addressTextArea.getText();
				String contact = contactTextArea.getText();
				long result = Long.parseLong(contact);
				String section = (String) comboBox.getSelectedItem();
				
				
				String gender="";
				if(rdbtnMale.isSelected()) {
					gender="Male";
				}else if(rdbtnFemale.isSelected()) {
					gender ="Female";
				}else if(rdbtnOthers.isSelected()) {
					gender = "Others";
				}
				String subject="";
				
				if(cProgramCheckBox.isSelected()) {
					subject =subject+ "C programming /";
				} if(javaCheckBox.isSelected()) {
					subject=subject+ "Java/";
				} if(aJavaCheckBox.isSelected()) {
					subject=subject+"Advance Java/";
				} if(dotnetCheckBox.isSelected()) {
					subject = subject+"DotNet/";
				} if(scriptingLanguageCheckBox.isSelected()) {
					subject=subject+"Scripting Language";
				}
				
			
				Student student = new Student();
				student.setName(name);
				student.setAddress(address);
				student.setContact(result);
				student.setSection(section);
				student.setGender(gender);
				student.setSubject(subject);
				StudentService studentService = new StudentServiceImpl();
				studentService.saveStudent(student);
				dispose();
				StudentDetails details= new StudentDetails();
				details.setVisible(true);
				
			}
		};
		btnSubmitButton.addActionListener(a1);
	}
}
