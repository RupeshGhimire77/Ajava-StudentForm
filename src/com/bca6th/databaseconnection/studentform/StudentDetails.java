package com.bca6th.databaseconnection.studentform;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import com.bca6th.databaseconnection.studentmodel.Student;
import com.bca6th.databaseconnection.studentservice.StudentService;
import com.bca6th.databaseconnection.studentservice.StudentServiceImpl;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;
	private JTable table;
	StudentService studentService= new StudentServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails();
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
	public StudentDetails() {
		setTitle("Student Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1198, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(763, 28, 98, 37);
		contentPane.add(lblNewLabel);
		
		searchTextField = new JTextField();
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String searchName=searchTextField.getText();
				if(searchName==null || searchName.isEmpty()) {
					loadValueInTable();
				}else {
					searchValueByName(searchName);
				}
				
			}
		});
		searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		searchTextField.setBounds(871, 30, 253, 46);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);
		
		table = new JTable();
		table.setBounds(36, 122, 1102, 393);
		contentPane.add(table);
		
		String columnName[]= {"id","name","address","contact","gender","section","subject"};
		
		DefaultTableModel model= new DefaultTableModel(columnName,0);
		table.setModel(model);
		
		loadValueInTable();
		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(36, 122, 1102, 393);
		contentPane.add(scrollPane);
		
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentForm1 studentForm1= new StudentForm1();
				studentForm1.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(53, 569, 151, 47);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEdit.setBounds(231, 569, 151, 47);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDelete.setBounds(415, 569, 151, 47);
		contentPane.add(btnDelete);
	}
	public void loadValueInTable() {
		List<Student> studentList=studentService.getStudent();
		
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();	
		tableModel.setRowCount(0);
		
		for(Student student: studentList) {
			tableModel.addRow(new Object[] {student.getId(),student.getName(),student.getAddress(),student.getContact(),student.getGender(),student.getSection(),student.getSubject()});
		}
	}
	public void searchValueByName(String name) {
		List<Student> studentList=studentService.searchStudentByName(name);
		
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();	
		tableModel.setRowCount(0);
		
		for(Student student: studentList) {
			tableModel.addRow(new Object[] {student.getId(),student.getName(),student.getAddress(),student.getContact(),student.getGender(),student.getSection(),student.getSubject()});
		}
	}
}
