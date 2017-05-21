package windowsBuilder.views;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import windowsBuilder.common.BulletListItem;

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

public class ExpPromt extends JDialog {
	private JButton okButton;
	private JPanel buttonPane;
	private JTextField txtExpField;
	private JScrollPane scrollPane;
	private JList lstExp;
	private ArrayList<BulletListItem> arrayList;
	private DefaultListModel<BulletListItem> expList = new DefaultListModel<BulletListItem>();
	private JButton btnAdd;
	private int dateFlag = 99999;
	private JPopupMenu popupMenu;
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
	public ExpPromt(String field,ArrayList<BulletListItem> arrayList ) {
		initComponents();
		this.txtExpField.setText(field);
		this.arrayList = arrayList;
		
		if(arrayList != null) {
			for(int i=0;i<arrayList.size();i++) {
				expList.addElement(arrayList.get(i));
			}
		}
		createEvents();
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpPromt.this.setVisible(false);
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Enter Professional Experience");			
				ExpListPromt csp = new ExpListPromt("","");
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
					expList.addElement(bullet);
					arrayList.add(bullet);
				}
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BulletListItem clickedExperience = expList.getElementAt(lstExp.getSelectedIndex());
				String field = clickedExperience.getContents();
				int num = clickedExperience.getDate();
				ExpListPromt csp = new ExpListPromt(field,Integer.toString(num));
				
				csp.setModal(true);
				csp.setVisible(true);
				
				String str0 = csp.getContents().getText();
				String str1 = csp.getDate().getText();
				if(!str0.equals("")) {
					clickedExperience.setContents(str0);
					clickedExperience.setDate(Integer.parseInt(str1));
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BulletListItem clickedSkillsAndExperience = expList.getElementAt(lstExp.getSelectedIndex());
				arrayList.remove(clickedSkillsAndExperience);
				expList.removeElement(clickedSkillsAndExperience);
			}
		});
	}
	
	public JTextField getTxtExpField() {
		return this.txtExpField;
	}
	
	public ArrayList<BulletListItem>  getArrayList(){
		return this.arrayList;
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setBounds(100, 100, 450, 300);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				okButton = new JButton("OK");
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JLabel lblCompanyNamejobTitledate = new JLabel("Company Name,Job Title,Date:");
		
		txtExpField = new JTextField();
		txtExpField.setColumns(10);
		
		JLabel lblBulletlist = new JLabel("BulletList:");
		
		scrollPane = new JScrollPane();
		
		btnAdd = new JButton("Add");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCompanyNamejobTitledate))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtExpField, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBulletlist))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCompanyNamejobTitledate)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtExpField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblBulletlist)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAdd))
					.addGap(14)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		lstExp = new JList(expList);
		scrollPane.setViewportView(lstExp);
		
		popupMenu = new JPopupMenu();
		addPopup(lstExp, popupMenu);
		
		btnEdit = new JButton(" Edit   ");
		
		popupMenu.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		
		popupMenu.add(btnDelete);
		getContentPane().setLayout(groupLayout);
	
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
