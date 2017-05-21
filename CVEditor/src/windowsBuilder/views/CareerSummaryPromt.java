package windowsBuilder.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CareerSummaryPromt extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtContents;
	private JTextField txtDateOfRecruit;
	private JButton okButton;
	
	
	public JTextField getContents()
	{
		return this.txtContents;
	}
	
	
	public JTextField getDateOfRecruit()
	{
		return this.txtDateOfRecruit;
	}
	
	public void setContents(String name)
	{
		this.txtContents.setText(name);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CareerSummaryPromt dialog = new CareerSummaryPromt("","");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CareerSummaryPromt(String contents,String date ) {
		
		initComponents();
		this.txtContents.setText(contents);
		this.txtDateOfRecruit.setText(date);
		createEvents();
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CareerSummaryPromt.this.setVisible(false);
			}
		});
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblContents = new JLabel("Company Name, Job Title:");
		
		JLabel lblDateOfRecruit = new JLabel("Date of recruit:");
		
		txtContents = new JTextField();
		txtContents.setColumns(10);
		
		txtDateOfRecruit = new JTextField();
		txtDateOfRecruit.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblContents)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtContents, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addGap(140))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblDateOfRecruit)
							.addContainerGap(340, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtDateOfRecruit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(328, Short.MAX_VALUE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(38)
					.addComponent(lblContents)
					.addGap(18)
					.addComponent(txtContents, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblDateOfRecruit)
					.addGap(18)
					.addComponent(txtDateOfRecruit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
	}
}
