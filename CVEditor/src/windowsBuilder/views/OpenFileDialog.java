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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class OpenFileDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFilename;
	private JButton okButton;
	private CV cv;
	private JLabel lblincludingtxtOr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OpenFileDialog dialog = new OpenFileDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public OpenFileDialog(CV cv) {
		initComponents();
		this.cv = cv;
		createEvents();
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String filename = txtFilename.getText();
				cv.openFile(filename);
				if(cv.getName().equals("Functional CV")) {
					dlgFunctionalCV dlg = new dlgFunctionalCV(cv);
					dlg.setVisible(true);
				}else if(cv.getName().equals("Chronological CV")) {
					dlgChronologicalCV dlg = new dlgChronologicalCV(cv);
					dlg.setVisible(true);
				}else if(cv.getName().equals("Combined CV")){
					dlgCombinedCV dlg = new dlgCombinedCV(cv);
					dlg.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Error Opening CV.File format not supported.");
				}
				OpenFileDialog.this.setVisible(false);
			}
		});
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setBounds(100, 100, 417, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblTypeTheName = new JLabel("Type the name of the file you like to open:");
		lblTypeTheName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtFilename = new JTextField();
		txtFilename.setColumns(10);
		
		lblincludingtxtOr = new JLabel("(Including .txt or .tex respectively)");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTypeTheName)
						.addComponent(txtFilename, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblincludingtxtOr))
					.addContainerGap(177, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTypeTheName)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblincludingtxtOr)
					.addGap(18)
					.addComponent(txtFilename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
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
