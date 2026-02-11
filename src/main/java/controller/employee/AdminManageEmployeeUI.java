package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.employee.impl.AdminDaoImpl;
import model.employee.Employee;
import service.impl.EmployeeExtendServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class AdminManageEmployeeUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField employee_no;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JTextField employee_name;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JTextField department;
	private JPanel panel_3;
	private JLabel lblNewLabel_3;
	private JTextField password;
	private JPanel panel_4;
	private JLabel lblNewLabel_4;
	private JCheckBox isAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AdminManageEmployeeUI frame = new AdminManageEmployeeUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminManageEmployeeUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 10, 320, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("員工編號");
		lblNewLabel.setBounds(10, 10, 57, 20);
		panel.add(lblNewLabel);
		
		employee_no = new JTextField();
		employee_no.setBounds(77, 10, 218, 20);
		panel.add(employee_no);
		employee_no.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(46, 66, 320, 39);
		contentPane.add(panel_1);
		
		lblNewLabel_1 = new JLabel("員工姓名");
		lblNewLabel_1.setBounds(10, 10, 57, 20);
		panel_1.add(lblNewLabel_1);
		
		employee_name = new JTextField();
		employee_name.setColumns(10);
		employee_name.setBounds(77, 10, 218, 20);
		panel_1.add(employee_name);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(46, 115, 320, 39);
		contentPane.add(panel_2);
		
		lblNewLabel_2 = new JLabel("所屬單位");
		lblNewLabel_2.setBounds(10, 10, 57, 20);
		panel_2.add(lblNewLabel_2);
		
		department = new JTextField();
		department.setColumns(10);
		department.setBounds(77, 10, 218, 20);
		panel_2.add(department);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(46, 159, 320, 39);
		contentPane.add(panel_3);
		
		lblNewLabel_3 = new JLabel("密碼");
		lblNewLabel_3.setBounds(10, 10, 57, 20);
		panel_3.add(lblNewLabel_3);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(77, 10, 218, 20);
		panel_3.add(password);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(46, 208, 320, 39);
		contentPane.add(panel_4);
		
		lblNewLabel_4 = new JLabel("管理權限");
		lblNewLabel_4.setBounds(10, 10, 57, 20);
		panel_4.add(lblNewLabel_4);
		
		isAdmin = new JCheckBox("");
		isAdmin.setBounds(73, 9, 94, 22);
		panel_4.add(isAdmin);
		
		/*************************/
		
		EmployeeExtendServiceImpl service = new EmployeeExtendServiceImpl();
		
		btnNewButton = new JButton("新增員工");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, service.createEmployee(getEmployeeModel()));
			}
		});
		btnNewButton.setBounds(46, 269, 84, 22);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("修改員工");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, service.updateEmployee(getEmployeeModel()));
			}
		});
		btnNewButton_1.setBounds(140, 269, 84, 22);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("刪除員工");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, service.deleteEmployee(getEmployeeModel(), ""));
			}
		});
		btnNewButton_2.setBounds(237, 269, 84, 22);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("返回");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminManageUI adminManageUI = new AdminManageUI();
				adminManageUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(331, 269, 84, 22);
		contentPane.add(btnNewButton_3);
	}
	
	private Employee getEmployeeModel()
	{
		return new Employee(
				employee_no.getText(),
				employee_name.getText(),
				department.getText(),
				password.getText(),
				isAdmin.isSelected()
		);
	}
}
