package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.employee.CheckInRecord;
import model.employee.Employee;
import service.impl.EmployeeServiceImpl;
import util.Utility;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class ManageUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
					ManageUI frame = new ManageUI();
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
	public ManageUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 27, 351, 181);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JPanel panel = new JPanel();
		panel.setBounds(43, 268, 351, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("開始時間");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 53, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("年");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(65, 15, 31, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("月");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(160, 15, 31, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("日");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(245, 15, 31, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(43, 326, 351, 41);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("結束時間");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 10, 53, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("年");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(65, 15, 31, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("月");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(160, 15, 31, 14);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("日");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setBounds(245, 15, 31, 14);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		/*****開始時間下拉選單*****/
		
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		Employee employee = (Employee)Utility.readObject("Employee");
		CheckInRecord data = employeeService.findFirstRecordDatas(employee);
		LocalDate currentDate = LocalDate.now();
		int year = data != null ? data.getCheck_datetime().getYear() : LocalDate.now().getYear();
		String[] years = Utility.getYears(year);
		String[] months = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		
		JComboBox comboBoxStartYear = new JComboBox();
		comboBoxStartYear.setModel(new DefaultComboBoxModel(years));
		comboBoxStartYear.setBounds(96, 11, 63, 22);
		comboBoxStartYear.setSelectedIndex(Utility.getIndexOfCurrentYear(year));
		panel.add(comboBoxStartYear);
		
		JComboBox comboBoxStartMonth = new JComboBox();
		comboBoxStartMonth.setModel(new DefaultComboBoxModel(months));
		comboBoxStartMonth.setBounds(195, 11, 44, 22);
		comboBoxStartMonth.setSelectedIndex(Utility.getIndexOfCurrentMonth());
		panel.add(comboBoxStartMonth);
		
		JComboBox comboBoxStartDay = new JComboBox();
		comboBoxStartDay.setModel(new DefaultComboBoxModel(Utility.getDays(currentDate.getYear(), currentDate.getMonthValue())));
		comboBoxStartDay.setBounds(276, 11, 44, 22);
		comboBoxStartDay.setSelectedIndex(Utility.getIndexOfCurrentDay());
		panel.add(comboBoxStartDay);
		
		ManageUI.addMenuListener(comboBoxStartYear, comboBoxStartMonth, comboBoxStartDay, comboBoxStartYear);
		ManageUI.addMenuListener(comboBoxStartYear, comboBoxStartMonth, comboBoxStartDay, comboBoxStartMonth);
		
		/*****結束時間下拉選單*****/
		
		JComboBox comboBoxEndYear = new JComboBox();
		comboBoxEndYear.setModel(new DefaultComboBoxModel(years));
		comboBoxEndYear.setBounds(96, 11, 63, 22);
		comboBoxEndYear.setSelectedIndex(Utility.getIndexOfCurrentYear(year));
		panel_1.add(comboBoxEndYear);
		
		JComboBox comboBoxEndMonth = new JComboBox();
		comboBoxEndMonth.setModel(new DefaultComboBoxModel(months));
		comboBoxEndMonth.setSelectedIndex(1);
		comboBoxEndMonth.setBounds(195, 11, 44, 22);
		comboBoxEndMonth.setSelectedIndex(Utility.getIndexOfCurrentMonth());
		panel_1.add(comboBoxEndMonth);
		
		JComboBox comboBoxEndDay = new JComboBox();
		comboBoxEndDay.setModel(new DefaultComboBoxModel(Utility.getDays(currentDate.getYear(), currentDate.getMonthValue())));
		comboBoxEndDay.setBounds(276, 11, 44, 22);
		comboBoxEndDay.setSelectedIndex(Utility.getIndexOfCurrentDay());
		panel_1.add(comboBoxEndDay);
		
		ManageUI.addMenuListener(comboBoxEndYear, comboBoxEndMonth, comboBoxEndDay, comboBoxEndYear);
		ManageUI.addMenuListener(comboBoxEndYear, comboBoxEndMonth, comboBoxEndDay, comboBoxEndMonth);

		/**********************/
		
		LocalDate date = LocalDate.now();
		
		JButton btnNewButton = new JButton("打卡");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				employeeService.addCheckData(employee);
			}
		});
		btnNewButton.setBounds(86, 218, 84, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int startYear = Integer.parseInt((String)comboBoxStartYear.getSelectedItem());
				int startMonth = Integer.parseInt((String)comboBoxStartMonth.getSelectedItem());
				int startDay = Integer.parseInt((String)comboBoxStartDay.getSelectedItem());
				
				int endYear = Integer.parseInt((String)comboBoxEndYear.getSelectedItem());
				int endMonth = Integer.parseInt((String)comboBoxEndMonth.getSelectedItem());
				int endDay = Integer.parseInt((String)comboBoxEndDay.getSelectedItem());
				
				LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
				LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);
				
				if (!Utility.isDateVaild(startDate, endDate))
				{
					JOptionPane.showMessageDialog(null, "結束日期不得大於開始日期");
				}
				
				List<CheckInRecord> records = employeeService.findRecordDatasByDate(employee, startDate, endDate);
				
				String recordText = "";
				for(CheckInRecord record : records)
				{
					recordText += "打卡時間: " + record.getCheck_datetime() + "\n";
				}
				
				textArea.setText(recordText);
			}
		});
		btnNewButton_1.setBounds(245, 218, 84, 22);
		contentPane.add(btnNewButton_1);
	}
	
	private static void addMenuListener(JComboBox yearComboBox, JComboBox monthComboBox, JComboBox dayComboBox, JComboBox selectComboBox)
	{
		selectComboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				
				int cacheSelectedYear = Integer.parseInt((String)yearComboBox.getSelectedItem());
				int cacheSelectedMonth = Integer.parseInt((String)monthComboBox.getSelectedItem());
				int cacheSelectedDay = Integer.parseInt((String)dayComboBox.getSelectedItem());
				
				dayComboBox.setModel(new DefaultComboBoxModel(
						Utility.getDays(
							cacheSelectedYear, 
							cacheSelectedMonth
						)
					)
				);
				
				dayComboBox.setSelectedIndex(Utility.getIndexOfDay(cacheSelectedYear, cacheSelectedMonth, cacheSelectedDay));
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
	}
}
