package windowsBuilder.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import windowsBuilder.common.BulletList;
import windowsBuilder.common.BulletListItem;
import windowsBuilder.common.Section;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.awt.event.ActionEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SkillsPromt extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSkillField;
	private JButton okButton;
	private ArrayList<BulletListItem> arrayList;

	private DefaultListModel<BulletListItem> skillsList = new DefaultListModel<BulletListItem>();
	private JList lstSkills;
	private JButton btnAdd;
	private int dateFlag = 99999;
	private JButton btnEdit;
	private JButton btnDelete;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			SkillsPromt dialog = new SkillsPromt("",null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SkillsPromt(String field,ArrayList<BulletListItem> arrayList ) {
		initComponents();
		this.txtSkillField.setText(field);
		this.arrayList = arrayList;
		
		if(arrayList != null) {
			for(int i=0;i<arrayList.size();i++) {
				skillsList.addElement(arrayList.get(i));
			}
		}
		
		createEvents();
		
	}
	public JTextField getTxtSkillField() {
		return txtSkillField;
	}
	
	public ArrayList<BulletListItem>  getArrayList(){
		return this.arrayList;
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SkillsPromt.this.setVisible(false);
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Enter Skills And Experience");			
				SkillsListPromt csp = new SkillsListPromt("","");
				csp.setModal(true);
				csp.setVisible(true);
				String cn = csp.getContents().getText();
				String strDate = csp.getDate().getText();
				if(!strDate.equals("")) {
					int temp = Integer.parseInt(strDate);
					if(temp > dateFlag){
						JOptionPane.showMessageDialog(null, "Dates must be given ordered by the most recent first.");
						return;
					}
					dateFlag = temp;
					BulletListItem bullet = new BulletListItem(Integer.parseInt(strDate), cn);
					skillsList.addElement(bullet);
					arrayList.add(bullet);
				}
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BulletListItem clickedSkillsAndExperience = skillsList.getElementAt(lstSkills.getSelectedIndex());
				String field = clickedSkillsAndExperience.getContents();
				int num = clickedSkillsAndExperience.getDate();
				SkillsListPromt csp = new SkillsListPromt(field,Integer.toString(num));
				
				csp.setModal(true);
				csp.setVisible(true);
				
				String str0 = csp.getContents().getText();
				String str1 = csp.getDate().getText();
				if(!str0.equals("")) {
					clickedSkillsAndExperience.setContents(str0);
					clickedSkillsAndExperience.setDate(Integer.parseInt(str1));		
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BulletListItem clickedSkillsAndExperience = skillsList.getElementAt(lstSkills.getSelectedIndex());
				arrayList.remove(clickedSkillsAndExperience);
				skillsList.removeElement(clickedSkillsAndExperience);
			}
		});
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setBounds(100, 100, 497, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblSkillsAndExperience = new JLabel("Skills And Experience on:");
		txtSkillField = new JTextField();
		txtSkillField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblBulletlist = new JLabel("BulletList:");
		
		btnAdd = new JButton("Add");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSkillsAndExperience)
						.addComponent(lblBulletlist))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAdd))
						.addComponent(txtSkillField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSkillsAndExperience)
						.addComponent(txtSkillField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBulletlist)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnAdd)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		lstSkills = new JList(skillsList);
		scrollPane.setViewportView(lstSkills);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(lstSkills, popupMenu);
		
		btnEdit = new JButton(" Edit   ");
		
		popupMenu.add(btnEdit);
		
		btnDelete = new JButton("Delete");

		popupMenu.add(btnDelete);
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
