package windowsBuilder.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import windowsBuilder.common.CV;
import windowsBuilder.common.Section;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Font;

public class CVEditorEntry extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btgCvTemp = new ButtonGroup();
	private JButton btnContinue;
	private JRadioButton rbCombined;
	private JRadioButton rbChronological;
	private JRadioButton rbFunctional;
	private JButton btnOpen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CVEditorEntry frame = new CVEditorEntry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CVEditorEntry()
	{
		setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		setTitle("CV EDITOR");
		initComponents();
		createEvents();
	}

	private void createEvents() 
	{
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Section> arrayList = new ArrayList<Section>();
				CV cv = new CV("",arrayList);
				OpenFileDialog dialog = new OpenFileDialog(cv);
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		
		// TODO Auto-generated method stub
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbFunctional.isSelected())
				{
					dlgFunctionalCV fcv = new dlgFunctionalCV();
					fcv.setVisible(true);
					
				}
				else if(rbChronological.isSelected())
				{
					dlgChronologicalCV chcv = new dlgChronologicalCV();
					chcv.setVisible(true);
					
				}
				else if(rbCombined.isSelected())
				{
					dlgCombinedCV cbcv = new dlgCombinedCV();
					cbcv.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"You have not selected any of the CV templates.\nSelect one to proceed.");
				}
				
			}
		});
	}

	private void initComponents() 
	{
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton Monkey = new JButton("");
		Monkey.setIcon(new ImageIcon(CVEditorEntry.class.getResource("/windowsBuilder/resources/monkey128.png")));
		
		rbFunctional = new JRadioButton("Functional CV");
		btgCvTemp.add(rbFunctional);
		
		rbChronological = new JRadioButton("Chronological CV");
		btgCvTemp.add(rbChronological);
		
		rbCombined = new JRadioButton("Combined CV");
		btgCvTemp.add(rbCombined);
		
		btnContinue = new JButton("Create CV");
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBackground(UIManager.getColor("Button.select"));
		txtArea.setFont(new Font("Dialog", Font.BOLD, 14));
		txtArea.setText("\t           Welcome to Jobify's CV editor!\r\n\t\r\n\t         Please choose one of the following \r\n\t         CV templates and then \"Create CV\".\r\n\r\n\t     Else,click on Open CV to open an existing CV.\r\n\r\n");
		txtArea.setEditable(false);
		
		btnOpen = new JButton("Open CV");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(Monkey, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(374, Short.MAX_VALUE)
					.addComponent(btnContinue)
					.addGap(18)
					.addComponent(btnOpen)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtArea, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rbCombined)
						.addComponent(rbChronological)
						.addComponent(rbFunctional))
					.addContainerGap(371, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(Monkey, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtArea, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addComponent(rbFunctional)
					.addGap(18)
					.addComponent(rbChronological)
					.addGap(18)
					.addComponent(rbCombined)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnContinue)
						.addComponent(btnOpen))
					.addGap(61))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
