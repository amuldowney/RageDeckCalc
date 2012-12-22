package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

import Utility.RoBUtilities.RoBRealm;
import Utility.RoBUtilities.RoBSkillRealm;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JButton;

public class RageCalc {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAtk;
	private JComboBox txtRealm;
	private JComboBox txtSkillAtkdef;
	private JComboBox txtSkillRealm;
	private JComboBox txtSkillLevel;
	private JLabel lblSkill;
	private JPanel secondcard;
	private JLabel lblnd;
	private JTextField textField;
	private JComboBox comboBox;
	private JTextField textField_1;
	private JLabel lblSkill_1;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JPanel thirdcard;
	private JLabel lblrd;
	private JTextField textField_2;
	private JComboBox comboBox_4;
	private JTextField textField_3;
	private JLabel lblSkill_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	private JComboBox comboBox_7;
	private JPanel panel;
	private JLabel lblth;
	private JTextField textField_4;
	private JComboBox comboBox_8;
	private JTextField textField_5;
	private JLabel lblSkill_2;
	private JComboBox comboBox_9;
	private JComboBox comboBox_10;
	private JComboBox comboBox_11;
	private JPanel panel_1;
	private JLabel lblth_1;
	private JTextField textField_6;
	private JComboBox comboBox_12;
	private JTextField textField_7;
	private JLabel lblSkill_3;
	private JComboBox comboBox_13;
	private JComboBox comboBox_14;
	private JComboBox comboBox_15;
	private JPanel panel_2;
	private JButton btnCalculate;
	private JTextField comboBox_16;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RageCalc window = new RageCalc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RageCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel firstcard = new JPanel();
		FlowLayout fl_firstcard = (FlowLayout) firstcard.getLayout();
		fl_firstcard.setHgap(3);
		fl_firstcard.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(firstcard);
		
		JLabel lblCard = new JLabel("1st");
		firstcard.add(lblCard);
		
		txtName = new JTextField();
		txtName.setText("Name");
		firstcard.add(txtName);
		txtName.setColumns(10);
		
		txtRealm = new JComboBox(RoBRealm.values());
		firstcard.add(txtRealm);
		
		txtAtk = new JTextField();
		txtAtk.setText("ATK");
		firstcard.add(txtAtk);
		txtAtk.setColumns(5);
		
		lblSkill = new JLabel("  Skill");
		firstcard.add(lblSkill);
		
		txtSkillAtkdef = new JComboBox();
		txtSkillAtkdef.setModel(new DefaultComboBoxModel(new String[] {"ATK", "Self ATK", "ATK/DEF", "Self ATK/DEF"}));
		firstcard.add(txtSkillAtkdef);
		
		txtSkillRealm = new JComboBox(RoBSkillRealm.values());
		firstcard.add(txtSkillRealm);
		
		comboBox_16 = new JTextField();
		comboBox_16.setText("%");
		comboBox_16.setColumns(3);
		firstcard.add(comboBox_16);
		
		txtSkillLevel = new JComboBox();
		txtSkillLevel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		firstcard.add(txtSkillLevel);
		
		secondcard = new JPanel();
		FlowLayout flowLayout = (FlowLayout) secondcard.getLayout();
		flowLayout.setHgap(3);
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(secondcard);
		
		lblnd = new JLabel("2nd");
		secondcard.add(lblnd);
		
		textField = new JTextField();
		textField.setText("Name");
		textField.setColumns(10);
		secondcard.add(textField);
		
		comboBox = new JComboBox(RoBRealm.values());
		secondcard.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setText("ATK");
		textField_1.setColumns(5);
		secondcard.add(textField_1);
		
		lblSkill_1 = new JLabel("  Skill");
		secondcard.add(lblSkill_1);
		
		comboBox_1 = new JComboBox(RoBSkillRealm.values());
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ATK", "Self ATK", "ATK/DEF", "Self ATK/DEF"}));
		secondcard.add(comboBox_1);
		
		comboBox_2 = new JComboBox(RoBSkillRealm.values());
		secondcard.add(comboBox_2);
		
		textField_8 = new JTextField();
		textField_8.setText("%");
		textField_8.setColumns(3);
		secondcard.add(textField_8);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		secondcard.add(comboBox_3);
		
		thirdcard = new JPanel();
		FlowLayout fl_thirdcard = (FlowLayout) thirdcard.getLayout();
		fl_thirdcard.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(thirdcard);
		
		lblrd = new JLabel("3rd");
		thirdcard.add(lblrd);
		
		textField_2 = new JTextField();
		textField_2.setText("Name");
		textField_2.setColumns(10);
		thirdcard.add(textField_2);
		
		comboBox_4 = new JComboBox(RoBRealm.values());
		thirdcard.add(comboBox_4);
		
		textField_3 = new JTextField();
		textField_3.setText("ATK");
		textField_3.setColumns(5);
		thirdcard.add(textField_3);
		
		lblSkill_4 = new JLabel("  Skill");
		thirdcard.add(lblSkill_4);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"ATK", "Self ATK", "ATK/DEF", "Self ATK/DEF"}));
		thirdcard.add(comboBox_5);
		
		comboBox_6 = new JComboBox(RoBSkillRealm.values());
		thirdcard.add(comboBox_6);
		
		textField_9 = new JTextField();
		textField_9.setText("%");
		textField_9.setColumns(3);
		thirdcard.add(textField_9);
		
		comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		thirdcard.add(comboBox_7);
		
		panel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel);
		
		lblth = new JLabel("4th");
		panel.add(lblth);
		
		textField_4 = new JTextField();
		textField_4.setText("Name");
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		comboBox_8 = new JComboBox(RoBRealm.values());
		panel.add(comboBox_8);
		
		textField_5 = new JTextField();
		textField_5.setText("ATK");
		textField_5.setColumns(5);
		panel.add(textField_5);
		
		lblSkill_2 = new JLabel("  Skill");
		panel.add(lblSkill_2);
		
		comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"ATK", "Self ATK", "ATK/DEF", "Self ATK/DEF"}));
		panel.add(comboBox_9);
		
		comboBox_10 = new JComboBox(RoBSkillRealm.values());
		panel.add(comboBox_10);
		
		textField_11 = new JTextField();
		textField_11.setText("%");
		textField_11.setColumns(3);
		panel.add(textField_11);
		
		comboBox_11 = new JComboBox();
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		panel.add(comboBox_11);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel_1);
		
		lblth_1 = new JLabel("5th");
		panel_1.add(lblth_1);
		
		textField_6 = new JTextField();
		textField_6.setText("Name");
		textField_6.setColumns(10);
		panel_1.add(textField_6);
		
		comboBox_12 = new JComboBox(RoBRealm.values());
		panel_1.add(comboBox_12);
		
		textField_7 = new JTextField();
		textField_7.setText("ATK");
		textField_7.setColumns(5);
		panel_1.add(textField_7);
		
		lblSkill_3 = new JLabel("  Skill");
		panel_1.add(lblSkill_3);
		
		comboBox_13 = new JComboBox();
		comboBox_13.setModel(new DefaultComboBoxModel(new String[] {"ATK", "Self ATK", "ATK/DEF", "Self ATK/DEF"}));
		panel_1.add(comboBox_13);
		
		comboBox_14 = new JComboBox(RoBSkillRealm.values());
		panel_1.add(comboBox_14);
		
		textField_10 = new JTextField();
		textField_10.setText("%");
		textField_10.setColumns(3);
		panel_1.add(textField_10);
		
		comboBox_15 = new JComboBox();
		comboBox_15.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		panel_1.add(comboBox_15);
		
		panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		
		btnCalculate = new JButton("Calculate");
		panel_2.add(btnCalculate);
	}

}
