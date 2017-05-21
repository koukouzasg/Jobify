package windowsBuilder.views;
import windowsBuilder.common.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPopupMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class dlgChronologicalCV extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHome;
	private JTextField txtMobile;
	private JTextField txtAddress;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextArea txtaProfessionalProfile;
	private JScrollPane srcpEducationAndTraining;
	private JList lstEducationAndTraining;
	private JList lstProfessionalExperience;
	private JButton btnOk;
	private JList lstFurtherCourses;
	
	private int dateExp = 99999;
	private int dateEducation = 99999;
	private int dateFurther = 99999;
		
	//Component Models
	DefaultListModel<BulletList> professionalExperienceList = new DefaultListModel<BulletList>();
	DefaultListModel<BulletListItem> educationAndTrainingList = new DefaultListModel<BulletListItem>();
	DefaultListModel<BulletListItem> furtherCoursesList = new DefaultListModel<BulletListItem>();
	
	//Components used
	private JButton btnEdit;
	private JButton btnEdit_1;
	private JButton btnEdit_2;
	private JTextArea txtaAdditionalInformation;
	private JButton addInfo;
	private JButton addInterests;
	private JButton addProfile;
	private JTextArea txtaInterests;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JPopupMenu popupMenu;
	private JButton btnDelete;
	private JButton btnDelete_1;
	private JButton btnDelete_2;
	private ArrayList<Section> sections;
	private JButton btnAdd;
	private JButton btnAdd_1;
	private JTextArea txtaCoreStrengths;
	private JButton btnAdd_2;
	private JButton btnAdd_3;
	private JButton btnAdd_4;
	private JMenuItem mntmSave;
	private CV fCv;
	private JMenuItem mntmMerge;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgChronologicalCV dialog = new dlgChronologicalCV();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgChronologicalCV() {
		
		initComponents();
		initCV();
		createEvents();
		
	}
	
	public dlgChronologicalCV(CV fCv) {
		this.fCv = fCv;
		this.sections = new ArrayList<Section>();
		this.sections.add(fCv.getSections().get(0));
		this.sections.add(fCv.getSections().get(1));
		this.sections.add(fCv.getSections().get(2));
		this.sections.add(fCv.getSections().get(3));
		this.sections.add(fCv.getSections().get(4));
		this.sections.add(fCv.getSections().get(5));
		this.sections.add(fCv.getSections().get(6));
		this.sections.add(fCv.getSections().get(7));
		initComponents();
		loadCV();
		createEvents();
	}
	
	private void loadCV() {
		// TODO Auto-generated method stub
		loadGeneralInformation();
		loadProfProfile();
		loadStrengths();
		loadProfExp();
		loadEducation();
		loadCourses();
		loadAddInfo();
		loadInterests();
	}
		
	private void loadGeneralInformation() {
		// TODO Auto-generated method stub
		this.txtName.setText(fCv.getSections().get(0).getParagraphs().get(0).getContents());
		this.txtAddress.setText(fCv.getSections().get(0).getParagraphs().get(1).getContents());
		this.txtHome.setText(fCv.getSections().get(0).getParagraphs().get(2).getContents());
		this.txtMobile.setText(fCv.getSections().get(0).getParagraphs().get(3).getContents());
		this.txtEmail.setText(fCv.getSections().get(0).getParagraphs().get(4).getContents());
	}
	private void loadProfProfile() {
		// TODO Auto-generated method stub
		this.txtaProfessionalProfile.setText(fCv.getSections().get(1).getParagraphs().get(0).getContents());
	}

	private void loadStrengths() {
		// TODO Auto-generated method stub
		this.txtaCoreStrengths.setText(fCv.getSections().get(2).getParagraphs().get(0).getContents());
	}
	
	private void loadProfExp() {
		// TODO Auto-generated method stub
		ArrayList<BulletList> arrayList = fCv.getSections().get(3).getBulletArrays();
		for(int i = 0;i<arrayList.size();i++) {
			professionalExperienceList.addElement(arrayList.get(i));
		}
		
	}
	
	private void loadEducation() {
		// TODO Auto-generated method stub
		ArrayList<BulletListItem> arrayList = fCv.getSections().get(4).getBulletArrays().get(0).getArrayList();
		for(int i = 0;i<arrayList.size();i++) {
			educationAndTrainingList.addElement(arrayList.get(i));
		}
	}
	
	private void loadCourses() {
		// TODO Auto-generated method stub
		ArrayList<BulletListItem> arrayList = fCv.getSections().get(5).getBulletArrays().get(0).getArrayList();
		for(int i = 0;i<arrayList.size();i++) {
			furtherCoursesList.addElement(arrayList.get(i));
		}
	}
	
	private void loadAddInfo() {
		// TODO Auto-generated method stub
		txtaAdditionalInformation.setText(fCv.getSections().get(6).getParagraphs().get(0).getContents());
	}

	private void loadInterests() {
		// TODO Auto-generated method stub
		txtaInterests.setText(fCv.getSections().get(7).getParagraphs().get(0).getContents());
		
	}

	private void initCV() {
		// TODO Auto-generated method stub
		sections = new ArrayList<Section>();
		ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
		ArrayList<BulletList> bulletArrays = new ArrayList<BulletList>();
		
		fCv = new CV("Chronological CV", sections);
		
		Section generalInfo = new Section("GENERAL INFORMATION", new ArrayList<Paragraph>(), new ArrayList<BulletList>());
			for(int i = 0;i<5;i++) {
				generalInfo.addParagraph(new Paragraph(""));
			}
		Section profProfile = new Section("PROFESSIONAL PROFILE", new ArrayList<Paragraph>(), new ArrayList<BulletList>());
			profProfile.addParagraph(new Paragraph(""));
		Section coreStrengths = new Section("CORE STRENGTHS", new ArrayList<Paragraph>(), new ArrayList<BulletList>());
			coreStrengths.addParagraph(new Paragraph(""));
		Section profExperience = new Section("PROFESSIONAL EXPERIENCE", new ArrayList<Paragraph>(), new ArrayList<BulletList>());
		Section education = new Section("EDUCATION AND TRAINING", new ArrayList<Paragraph>(), new ArrayList<BulletList>());
		Section further = new Section("FURTHER COURSES", new ArrayList<Paragraph>(), new ArrayList<BulletList>());
		Section additional = new Section("ADDITIONAL INFORMATION", new ArrayList<Paragraph>(), new ArrayList<BulletList>());
			additional.addParagraph(new Paragraph(""));
		Section interests = new Section("INTERESTS", new ArrayList<Paragraph>(), new ArrayList<BulletList>());
			interests.addParagraph(new Paragraph(""));
		
		sections.add(generalInfo);
		sections.add(profProfile);
		sections.add(coreStrengths);
		sections.add(profExperience);
		sections.add(education);
		sections.add(further);
		sections.add(additional);
		sections.add(interests);

	}

	private void createEvents() {	
		// TODO Auto-generated method stub
		professionaExperienceEvents();
		educationAndTrainingEvents();
		furtherCoursesEvents();
		additionalInformationEvents();
		interestsEvents();
		CoreStrengthsEvents();
		professionalProfilEvents();
		generalInformationEvents();
		menuEvents();	
				
		lstFurtherCourses.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
			{
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		                if (renderer instanceof JLabel && value instanceof BulletListItem)
			{
		                    // Here value will be of the Type 'Reservation'
		                    ((JLabel) renderer).setText(((BulletListItem) value).toString());
		                }
		                return renderer;
		        }
		});
		
		lstEducationAndTraining.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
			{
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		                if (renderer instanceof JLabel && value instanceof BulletListItem)
			{
		                    // Here value will be of the Type 'Reservation'
		                    ((JLabel) renderer).setText(((BulletListItem) value).toString());
		                }
		                return renderer;
		        }
		});
		
		
		lstProfessionalExperience.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
			{
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		                if (renderer instanceof JLabel && value instanceof BulletList)
			{
		                    // Here value will be of the Type 'Reservation'
		                    ((JLabel) renderer).setText(((BulletList) value).toString());
		                }
		                return renderer;
		        }
		});	
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	private void menuEvents() {
		// TODO Auto-generated method stub
		
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				About about = new About();
				about.setModal(true);
				about.setVisible(true);
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int ret = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(ret == JOptionPane.YES_OPTION)
				{
					//Elegantly shut down program
					//Save any work
					System.exit(0);
				}
			}
		});
		
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveDialog dlg = new SaveDialog(fCv);
				dlg.setModal(true);
				dlg.setVisible(true);
			}
		});
		
		mntmMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MergeFilesDialog dlg = new MergeFilesDialog();
				dlg.setModal(true);
				dlg.setVisible(true);
				dlgChronologicalCV.this.setVisible(false);
			}
		});
		
	}
	
	private void generalInformationEvents() {
		// TODO Auto-generated method stub
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paragraph name = new Paragraph("");
				Paragraph address = new Paragraph("");
				Paragraph telephone = new Paragraph("");
				Paragraph mobile = new Paragraph("");
				Paragraph email = new Paragraph("");
				name.setContents(txtName.getText());
				address.setContents(txtAddress.getText());
				telephone.setContents(txtHome.getText());
				mobile.setContents(txtMobile.getText());
				email.setContents(txtEmail.getText());
				ArrayList<Paragraph> arrayList = new ArrayList<Paragraph>();
				arrayList.add(name);
				arrayList.add(address);
				arrayList.add(telephone);
				arrayList.add(mobile);
				arrayList.add(email);
				sections.get(0).setParagraphs(arrayList);
			}
		});
	}
	
	private void professionalProfilEvents() {
		// TODO Auto-generated method stub			
		addProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paragraph addInfo = new Paragraph("");
				addInfo.setContents((txtaProfessionalProfile.getText()));
				sections.get(1).setParagraph(addInfo);
			}
		});	
	}
	
	private void CoreStrengthsEvents() {
		// TODO Auto-generated method stub
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paragraph addInfo = new Paragraph("");
				addInfo.setContents((txtaCoreStrengths.getText()));
				sections.get(2).setParagraph(addInfo);
			}
		});
	}
	
	private void professionaExperienceEvents() {
		// TODO Auto-generated method stub
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BulletList clickedProfExperience = professionalExperienceList.getElementAt(lstProfessionalExperience.getSelectedIndex());
				sections.get(3).getBulletArrays().remove((lstProfessionalExperience.getSelectedIndex()));
				professionalExperienceList.removeElement(clickedProfExperience);
			}
		});
			
		btnAdd_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Enter Professional Experience");
				ArrayList<BulletListItem> array = new ArrayList<BulletListItem>();
				ExpPromt csp = new ExpPromt("",array);
				csp.setModal(true);
				csp.setVisible(true);
				
				String field = csp.getTxtExpField().getText();
				array = csp.getArrayList();
				BulletList bList = new BulletList(array,field);
				professionalExperienceList.addElement(bList);	
				sections.get(3).addBulletList(bList);
			}
		});
				
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argv0) {
				BulletList clickedProfExperience = professionalExperienceList.getElementAt(lstProfessionalExperience.getSelectedIndex());
				String field = clickedProfExperience.getName();
				ArrayList<BulletListItem> arrayList = clickedProfExperience.getArrayList();
				ExpPromt csp = new ExpPromt(field,arrayList);
				
				csp.setModal(true);
				csp.setVisible(true);
				
				String str = csp.getTxtExpField().getText();
				arrayList = csp.getArrayList();
				clickedProfExperience.setName(str);
				clickedProfExperience.setArrayList(arrayList);		
				Section section = sections.get(3);
				ArrayList<BulletList> blArrayList = section.getBulletArrays();
				BulletList bulletList = blArrayList.get(0);
				ArrayList<BulletListItem> tmpList = bulletList.getArrayList();
				tmpList = arrayList;
			}
		});
				
	}
	
	private void educationAndTrainingEvents() {
		// TODO Auto-generated method stub
		
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Enter qualification,establishment,location and date");
				
				EducationAndTrainingPromt csp = new EducationAndTrainingPromt("","");
				csp.setModal(true);
				csp.setVisible(true);
				
				String ql = csp.getTxtContents().getText();
				String date = csp.getTxtDate().getText();
				if(!date.equals("")) {
					int temp = Integer.parseInt(date);
					if(temp > dateEducation){
						JOptionPane.showMessageDialog(null, "Dates must be given ordered by the most recent first.");
						return;
					}
					dateEducation = temp;
					
					BulletListItem bullet = new BulletListItem(Integer.parseInt(date), ql);
					educationAndTrainingList.addElement(bullet);
					ArrayList<BulletListItem> bList = new ArrayList<BulletListItem>();
					bList.add(bullet);
					BulletList b = new BulletList(bList,"");
					sections.get(4).addBulletList(b);
				}
			}
		});
		
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BulletListItem clickedEducationAndTraining = educationAndTrainingList.getElementAt(lstEducationAndTraining.getSelectedIndex());
				sections.get(4).getBulletArrays().remove((lstEducationAndTraining.getSelectedIndex()));
				educationAndTrainingList.removeElement(clickedEducationAndTraining);
			}
		});
		
		btnEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BulletListItem clickedEducationAndTraining = educationAndTrainingList.getElementAt(lstEducationAndTraining.getSelectedIndex());
				String contents = clickedEducationAndTraining.getContents();
				int date = clickedEducationAndTraining.getDate();
						
				EducationAndTrainingPromt csp = new EducationAndTrainingPromt(contents,String.valueOf(date));
				
				csp.setModal(true);
				csp.setVisible(true);
				
				String str0 = csp.getTxtDate().getText();
				if(!str0.equals("")) {
					clickedEducationAndTraining.setDate(Integer.parseInt(str0));
					
					String str1 = csp.getTxtContents().getText();
					clickedEducationAndTraining.setContents(str1);
					
					BulletListItem item = new BulletListItem(Integer.parseInt(str0), str1);
					Section section = sections.get(4);
					ArrayList<BulletList> blArrayList = section.getBulletArrays();
					BulletList bulletList = blArrayList.get(0);
					ArrayList<BulletListItem> tmpList = bulletList.getArrayList();
					tmpList.set(lstEducationAndTraining.getSelectedIndex(),item);
				}
			}
		});
		
	}
	private void furtherCoursesEvents() {
		// TODO Auto-generated method stub
		btnAdd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Enter Course,establishment,location and date");
				
				furtherCoursesPromt csp = new furtherCoursesPromt("","");
				csp.setModal(true);
				csp.setVisible(true);
				
				String contents = csp.getTxtContents().getText();
				String date = csp.getTxtDate().getText();
				if(!date.equals("")) {
					int temp = Integer.parseInt(date);
					if(temp > dateFurther){
						JOptionPane.showMessageDialog(null, "Dates must be given ordered by the most recent first.");
						return;
					}
					dateFurther = temp;
					BulletListItem bullet = new BulletListItem(Integer.parseInt(date), contents);
					ArrayList<BulletListItem> bList = new ArrayList<BulletListItem>();
					bList.add(bullet);
					BulletList b = new BulletList(bList,"");
					sections.get(5).addBulletList(b);
					furtherCoursesList.addElement(bullet);
				}
			}
		});
		
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BulletListItem clickedFurtherCourses = furtherCoursesList.getElementAt(lstFurtherCourses.getSelectedIndex());
				sections.get(5).getBulletArrays().remove((lstFurtherCourses.getSelectedIndex()));
				furtherCoursesList.removeElement(clickedFurtherCourses);
			}
		});
		
		btnEdit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BulletListItem clickedFurtherCourses = furtherCoursesList.getElementAt(lstFurtherCourses.getSelectedIndex());
				String contents = clickedFurtherCourses.getContents();
				int date = clickedFurtherCourses.getDate();		
				furtherCoursesPromt csp = new furtherCoursesPromt(contents,String.valueOf(date));//courses,esb,loc,date);
				
				csp.setModal(true);
				csp.setVisible(true);
				
				String str0 = csp.getTxtDate().getText();
				if(!str0.equals("")) {
					clickedFurtherCourses.setDate(Integer.parseInt(str0));
					
					String str1 = csp.getTxtContents().getText();
					clickedFurtherCourses.setContents(str1);
					
					BulletListItem item = new BulletListItem(Integer.parseInt(str0), str1);
					Section section = sections.get(5);
					ArrayList<BulletList> blArrayList = section.getBulletArrays();
					BulletList bulletList = blArrayList.get(0);
					ArrayList<BulletListItem> tmpList = bulletList.getArrayList();
					tmpList.set(lstFurtherCourses.getSelectedIndex(),item);
				}
			}
		});
	}

	private void additionalInformationEvents() {
		// TODO Auto-generated method stub	
		
		addInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paragraph addInfo = new Paragraph("");
				addInfo.setContents((txtaAdditionalInformation.getText()));
				sections.get(6).setParagraph(addInfo);
			}
		});
	}
	
	private void interestsEvents() {
		// TODO Auto-generated method stub
		addInterests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paragraph interests = new Paragraph("");
				interests.setContents((txtaInterests.getText()));
				sections.get(7).setParagraph(interests);
			}
		});		
	}

	private void initComponents() {
		// TODO Auto-generated method stub

		getContentPane().setBackground(SystemColor.activeCaption);
		setBackground(SystemColor.text);
		setBounds(100, 100, 541, 780);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.text);
		contentPanel.setForeground(SystemColor.textHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextPane txtpnGeneralInfo = new JTextPane();
		txtpnGeneralInfo.setEditable(false);
		txtpnGeneralInfo.setBackground(SystemColor.text);
		txtpnGeneralInfo.setFont(new Font("Dialog", Font.BOLD, 11));
		txtpnGeneralInfo.setText("1.GENERAL INFORMATION");
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Dialog", Font.BOLD, 10));
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 10));
		
		JLabel lblTelephone = new JLabel("Telephone:(Home)");
		lblTelephone.setFont(new Font("Dialog", Font.BOLD, 10));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 10));
		
		txtHome = new JTextField();
		txtHome.setColumns(10);
		
		JLabel lblmobile = new JLabel("(Mobile)");
		lblmobile.setFont(new Font("Dialog", Font.BOLD, 10));
		
		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		
		JTextPane txtpnprofessionalProfile = new JTextPane();
		txtpnprofessionalProfile.setBackground(SystemColor.text);
		txtpnprofessionalProfile.setEditable(false);
		txtpnprofessionalProfile.setFont(new Font("Dialog", Font.BOLD, 11));
		txtpnprofessionalProfile.setText("2.PROFESSIONAL PROFILE");
		
		JTextPane txtpnCoreStrengths = new JTextPane();
		txtpnCoreStrengths.setEditable(false);
		txtpnCoreStrengths.setBackground(SystemColor.text);
		txtpnCoreStrengths.setFont(new Font("Dialog", Font.BOLD, 11));
		txtpnCoreStrengths.setText("3.CORE STRENGTHS");
		
		JTextPane txtpnProfessional = new JTextPane();
		txtpnProfessional.setEditable(false);
		txtpnProfessional.setBackground(SystemColor.text);
		txtpnProfessional.setFont(new Font("Dialog", Font.BOLD, 11));
		txtpnProfessional.setText("4.PROFESSIONAL EXPERIENCE");
		
		JTextPane txtpneducationAndTraining = new JTextPane();
		txtpneducationAndTraining.setEditable(false);
		txtpneducationAndTraining.setBackground(SystemColor.text);
		txtpneducationAndTraining.setFont(new Font("Dialog", Font.BOLD, 11));
		txtpneducationAndTraining.setText("5.EDUCATION AND TRAINING");
		
		JTextPane txtpnfurtherCourses = new JTextPane();
		txtpnfurtherCourses.setEditable(false);
		txtpnfurtherCourses.setBackground(SystemColor.text);
		txtpnfurtherCourses.setFont(new Font("Dialog", Font.BOLD, 11));
		txtpnfurtherCourses.setText("6.FURTHER COURSES");
		
		JTextPane txtpnadditionalInformation = new JTextPane();
		txtpnadditionalInformation.setEditable(false);
		txtpnadditionalInformation.setBackground(SystemColor.text);
		txtpnadditionalInformation.setFont(new Font("Dialog", Font.BOLD, 11));
		txtpnadditionalInformation.setText("7.ADDITIONAL INFORMATION");
		
		JTextPane txtpninterests = new JTextPane();
		txtpninterests.setEditable(false);
		txtpninterests.setBackground(SystemColor.text);
		txtpninterests.setFont(new Font("Dialog", Font.BOLD, 11));
		txtpninterests.setText("8.INTERESTS");
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JScrollPane srcpAdditionalInformation = new JScrollPane();
		
		JScrollPane srcpInterests = new JScrollPane();
		
		JScrollPane srcpFurtherCourses = new JScrollPane();
		
		srcpEducationAndTraining = new JScrollPane();
		
		JScrollPane srcpProfessionalExperience = new JScrollPane();
		
		JScrollPane scrpProfessionalProfile = new JScrollPane();
		
		btnOk = new JButton("OK");
		
		addInfo = new JButton("Save");
		
		addInterests = new JButton("Save");
		
		addProfile = new JButton("Save");
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAdd = new JButton("Save");
		btnAdd_1 = new JButton("Save");
		btnAdd_2 = new JButton("Add ");
		btnAdd_3 = new JButton("Add ");		
		btnAdd_4 = new JButton("Add ");
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblTelephone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtHome, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblmobile)
							.addGap(1)
							.addComponent(txtMobile, 116, 116, 116))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblAddress))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAddress, 118, 118, 118)
								.addComponent(txtName, 118, 118, 118))
							.addGap(242))
						.addComponent(txtpneducationAndTraining, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnfurtherCourses, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnadditionalInformation, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(srcpEducationAndTraining, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAdd_2))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(srcpProfessionalExperience, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAdd_4))
						.addComponent(txtpnCoreStrengths, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrpProfessionalProfile, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblEmail)
									.addGap(32)
									.addComponent(txtEmail, 118, 118, 118))
								.addComponent(txtpnprofessionalProfile, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAdd)
								.addComponent(addProfile)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(srcpAdditionalInformation, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(addInfo))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(srcpFurtherCourses, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAdd_3)))
					.addGap(105))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(txtpnProfessional, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(txtpninterests, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(srcpInterests, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(addInterests))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap(459, Short.MAX_VALUE)
							.addComponent(btnOk)))
					.addContainerGap())
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAdd_1)
					.addGap(113))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(txtpnGeneralInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(txtpnGeneralInfo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress)
						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelephone)
						.addComponent(txtHome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblmobile)
						.addComponent(txtMobile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addComponent(txtpnprofessionalProfile, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(scrpProfessionalProfile, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(21)
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(addProfile)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtpnCoreStrengths, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAdd_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpnProfessional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAdd_4)
						.addComponent(srcpProfessionalExperience, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(txtpneducationAndTraining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(srcpEducationAndTraining, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAdd_2, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtpnfurtherCourses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(srcpFurtherCourses, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAdd_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtpnadditionalInformation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(srcpAdditionalInformation, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(addInfo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtpninterests, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(srcpInterests, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(addInterests))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnOk)
					.addGap(31))
		);
		
		txtaCoreStrengths = new JTextArea();
		scrollPane.setViewportView(txtaCoreStrengths);
		
		txtaProfessionalProfile = new JTextArea();
		scrpProfessionalProfile.setViewportView(txtaProfessionalProfile);
		
		lstProfessionalExperience = new JList(professionalExperienceList);
		
		srcpProfessionalExperience.setViewportView(lstProfessionalExperience);
		
		popupMenu = new JPopupMenu();
		addPopup(lstProfessionalExperience, popupMenu);
		
		btnEdit = new JButton(" Edit   ");
		
		
		popupMenu.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		
		
		popupMenu.add(btnDelete);
		
		lstEducationAndTraining = new JList(educationAndTrainingList);
		
		srcpEducationAndTraining.setViewportView(lstEducationAndTraining);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(lstEducationAndTraining, popupMenu_1);
		
		btnEdit_1 = new JButton(" Edit   ");
		
		popupMenu_1.add(btnEdit_1);
		
		btnDelete_1 = new JButton("Delete");
		
		popupMenu_1.add(btnDelete_1);
		
		lstFurtherCourses = new JList(furtherCoursesList);
		
		srcpFurtherCourses.setViewportView(lstFurtherCourses);
		
		JPopupMenu popupMenu_2 = new JPopupMenu();
		addPopup(lstFurtherCourses, popupMenu_2);
		
		btnEdit_2 = new JButton(" Edit   ");
		
		popupMenu_2.add(btnEdit_2);
		
		btnDelete_2 = new JButton("Delete");
		
		popupMenu_2.add(btnDelete_2);
		
		txtaInterests = new JTextArea();
		srcpInterests.setViewportView(txtaInterests);
		
		txtaAdditionalInformation = new JTextArea();
		
		srcpAdditionalInformation.setViewportView(txtaAdditionalInformation);
		contentPanel.setLayout(gl_contentPanel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmMerge = new JMenuItem("Merge");
		
		mnFile.add(mntmMerge);
		
		mntmSave = new JMenuItem(" Save");
		
		mnFile.add(mntmSave);
		
		mntmExit = new JMenuItem(" Exit");
		
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help\n");
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
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