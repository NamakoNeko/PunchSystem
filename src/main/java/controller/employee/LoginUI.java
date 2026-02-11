package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.employee.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;
import util.Utility;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField employee_no;
	private JTextField password;

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
					LoginUI frame = new LoginUI();
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
	public LoginUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("員工編號");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 71, 75, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(70, 119, 75, 31);
		contentPane.add(lblNewLabel_1);
		
		employee_no = new JTextField();
		employee_no.setBounds(169, 76, 177, 20);
		contentPane.add(employee_no);
		employee_no.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(169, 124, 177, 20);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Employee employee = new EmployeeServiceImpl().findEmployee(employee_no.getText(), password.getText());
				if (employee != null)
				{
					Utility.saveObject(employee, "Employee");
					
					if(employee.isAdmin())
					{
						AdminManageUI manageUI = new AdminManageUI();
						manageUI.setVisible(true);		
					}
					else
					{
						ManageUI manageUI = new ManageUI();
						manageUI.setVisible(true);						
					}
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "登入失敗，請確認員工編號或密碼");
				}
			}
		});
		btnNewButton.setBounds(181, 185, 84, 22);
		contentPane.add(btnNewButton);
	}
}
