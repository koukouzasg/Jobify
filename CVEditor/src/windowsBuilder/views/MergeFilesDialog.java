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

public class MergeFilesDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName1;
	private JTextField txtName2;
	private JButton okButton;
	private JTextField txtMerged;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MergeFilesDialog dialog = new MergeFilesDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MergeFilesDialog() {
		initComponents();
		createEvents();
	}
	private void createEvents() {
		// TODO Auto-generated method stub
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CV cv = new  CV("",null);
				boolean bool = cv.mergeFiles(txtName1.getText(),txtName2.getText());
				if(bool == true) {
					cv.writeToFile(txtMerged.getText());
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
					MergeFilesDialog.this.setVisible(false);
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
		
		JLabel lblCvName1 = new JLabel("CV Name 1:");
		txtName1 = new JTextField();
		txtName1.setColumns(10);
		JLabel lblCvName = new JLabel("CV Name 2:");
		txtName2 = new JTextField();
		txtName2.setColumns(10);
		
		JLabel lblMergedCvName = new JLabel("Merged CV Name:");
		
		txtMerged = new JTextField();
		txtMerged.setColumns(10);
		
		JLabel lblMergeTwoExisting = new JLabel("Merge two existing CV's into one.");
		lblMergeTwoExisting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMustBeOf = new JLabel("Must be of same format.");
		lblMustBeOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCvName)
								.addComponent(lblMergedCvName)
								.addComponent(txtName2)
								.addComponent(txtMerged, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(100)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtName1)
								.addComponent(lblCvName1))))
					.addContainerGap(119, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMergeTwoExisting)
					.addContainerGap(212, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMustBeOf)
					.addContainerGap(265, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addComponent(lblMergeTwoExisting)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMustBeOf)
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(lblCvName1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtName1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCvName)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtName2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMergedCvName)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtMerged, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
