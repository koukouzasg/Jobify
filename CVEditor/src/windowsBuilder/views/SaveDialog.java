package windowsBuilder.views;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import windowsBuilder.common.CV;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SaveDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbText;
	private JRadioButton rbLatex;
	private JButton okButton;
	private JLabel lblEnterFilename;
	private JTextField txtFileName;
	private CV cv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SaveDialog dialog = new SaveDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public SaveDialog(CV cv) {
		initComponents();
		this.cv = cv;
		createEvents();
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbText.isSelected() != true && rbLatex.isSelected() != true){
					JOptionPane.showMessageDialog(null,"You must choose one of the options above in order to continue.");
				}else {
					if(rbText.isSelected() == true) {
						if(txtFileName.getText().equals("(Untitled)")) {
							txtFileName.setText("Untitled.txt");
							cv.writeToFile(txtFileName.getText());
						}else {
							cv.writeToFile(txtFileName.getText()+".txt");
						}
					}else {
						if(txtFileName.getText().equals("(Untitled)")) {
							txtFileName.setText("Untitled.tex");
							cv.writeToLatex(txtFileName.getText());
						}else {
							JOptionPane.showMessageDialog(null, txtFileName.getText());
							cv.writeToLatex(txtFileName.getText()+".tex");
						}
					}
					SaveDialog.this.setVisible(false);
				}
			}
		});
	}
	private void initComponents() {
		// TODO Auto-generated method stub
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextArea txtrPleaseSelectOne = new JTextArea();
		txtrPleaseSelectOne.setBackground(SystemColor.menu);
		txtrPleaseSelectOne.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtrPleaseSelectOne.setEditable(false);
		txtrPleaseSelectOne.setText("Please select one of the following formats \r\nto save the file.");
		
		rbText = new JRadioButton("Plain Text");
		buttonGroup.add(rbText);
		
		rbLatex = new JRadioButton("Latex");
		buttonGroup.add(rbLatex);
		
		lblEnterFilename = new JLabel("Enter Filename:");
		
		txtFileName = new JTextField();
		txtFileName.setText("(Untitled)");
		txtFileName.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEnterFilename)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFileName, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtrPleaseSelectOne, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(rbText))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(rbLatex)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterFilename)
						.addComponent(txtFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(txtrPleaseSelectOne, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rbText)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rbLatex)
					.addContainerGap(36, Short.MAX_VALUE))
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
