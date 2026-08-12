package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ExampleFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JLabel lblCrvenaBoja = new JLabel("Crvena boja");
	private JLabel lblPlavaBoja = new JLabel("Plava boja");
	private JLabel lblZutaBoja = new JLabel("Zuta boja");
	private JTextField textFieldBoje;
	private JList<String> listBoje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExampleFrame frame = new ExampleFrame();
					frame.setTitle("Application");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExampleFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCentar = new GridBagLayout();
		gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlCentar.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlCentar.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCentar.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlCentar.setLayout(gbl_pnlCentar);

		JToggleButton tglbtnCrvenaBoja = new JToggleButton("Crvena boja");
		tglbtnCrvenaBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblCrvenaBoja.getText());
			}
		});
		buttonGroup.add(tglbtnCrvenaBoja);
		GridBagConstraints gbc_tglbtnCrvenaBoja = new GridBagConstraints();
		gbc_tglbtnCrvenaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvenaBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnCrvenaBoja.gridx = 0;
		gbc_tglbtnCrvenaBoja.gridy = 0;
		pnlCentar.add(tglbtnCrvenaBoja, gbc_tglbtnCrvenaBoja);

		GridBagConstraints gbc_lblCrvenaBoja = new GridBagConstraints();
		gbc_lblCrvenaBoja.anchor = GridBagConstraints.EAST;
		gbc_lblCrvenaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvenaBoja.gridx = 1;
		gbc_lblCrvenaBoja.gridy = 0;
		pnlCentar.add(lblCrvenaBoja, gbc_lblCrvenaBoja);

		JToggleButton tglbtnPlavaBoja = new JToggleButton("Plava boja");
		tglbtnPlavaBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblPlavaBoja.getText());
			}
		});

		JLabel lblDodatneBoje = new JLabel("Dodatne boje");
		GridBagConstraints gbc_lblDodatneBoje = new GridBagConstraints();
		gbc_lblDodatneBoje.insets = new Insets(0, 0, 5, 0);
		gbc_lblDodatneBoje.gridx = 2;
		gbc_lblDodatneBoje.gridy = 0;
		pnlCentar.add(lblDodatneBoje, gbc_lblDodatneBoje);
		buttonGroup.add(tglbtnPlavaBoja);
		GridBagConstraints gbc_tglbtnPlavaBoja = new GridBagConstraints();
		gbc_tglbtnPlavaBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPlavaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlavaBoja.gridx = 0;
		gbc_tglbtnPlavaBoja.gridy = 1;
		pnlCentar.add(tglbtnPlavaBoja, gbc_tglbtnPlavaBoja);

		GridBagConstraints gbc_lblPlavaBoja = new GridBagConstraints();
		gbc_lblPlavaBoja.anchor = GridBagConstraints.WEST;
		gbc_lblPlavaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlavaBoja.gridx = 1;
		gbc_lblPlavaBoja.gridy = 1;
		pnlCentar.add(lblPlavaBoja, gbc_lblPlavaBoja);

		JToggleButton tglbtnZutaBoja = new JToggleButton("Zuta boja");
		tglbtnZutaBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblZutaBoja.getText());
			}
		});

		JComboBox<String> comboBoxBoje = new JComboBox<String>();
		comboBoxBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(comboBoxBoje.getSelectedItem().toString());
				switch(comboBoxBoje.getSelectedItem().toString()) {
					case "Roze":
						lblDodatneBoje.setForeground(Color.pink);
						break;
					case "Ljubicasta":
						lblDodatneBoje.setForeground(Color.magenta);
						break;
					case "Narandzasta":
						lblDodatneBoje.setForeground(Color.orange);
						break;
				}

			}
		});
		comboBoxBoje.setModel(new DefaultComboBoxModel<String>(new String[] {"Narandzasta", "Roze", "Ljubicasta"}));
		GridBagConstraints gbc_comboBoxBoje = new GridBagConstraints();
		gbc_comboBoxBoje.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxBoje.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxBoje.gridx = 2;
		gbc_comboBoxBoje.gridy = 1;
		pnlCentar.add(comboBoxBoje, gbc_comboBoxBoje);
		buttonGroup.add(tglbtnZutaBoja);
		GridBagConstraints gbc_tglbtnZutaBoja = new GridBagConstraints();
		gbc_tglbtnZutaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnZutaBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnZutaBoja.gridx = 0;
		gbc_tglbtnZutaBoja.gridy = 2;
		pnlCentar.add(tglbtnZutaBoja, gbc_tglbtnZutaBoja);

		GridBagConstraints gbc_lblZutaBoja = new GridBagConstraints();
		gbc_lblZutaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_lblZutaBoja.anchor = GridBagConstraints.EAST;
		gbc_lblZutaBoja.gridx = 1;
		gbc_lblZutaBoja.gridy = 2;
		pnlCentar.add(lblZutaBoja, gbc_lblZutaBoja);

		textFieldBoje = new JTextField();
		textFieldBoje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(textFieldBoje.getText());
					textFieldBoje.setText("");
				}
			}
		});
		GridBagConstraints gbc_textFieldBoje = new GridBagConstraints();
		gbc_textFieldBoje.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBoje.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBoje.gridx = 2;
		gbc_textFieldBoje.gridy = 2;
		pnlCentar.add(textFieldBoje, gbc_textFieldBoje);
		textFieldBoje.setColumns(10);

		JButton btnDodajBoju = new JButton("Dodaj boju");
		btnDodajBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgBoje dlgBoje = new DlgBoje();
				dlgBoje.setModal(true);
				dlgBoje.setVisible(true);

				if(dlgBoje.isOk()) {
					dlm.addElement(dlgBoje.getTextFieldRed().getText() + " " +
							dlgBoje.getTextFieldGreen().getText() + " " +
							dlgBoje.getTextFieldBlue().getText());

					pnlCentar.setBackground(new Color(dlgBoje.getRedInt(),
							dlgBoje.getGreenInt(), dlgBoje.getBlueInt()));
				} else {
					JOptionPane.showMessageDialog(null,
							"Vrednosti nisu dobro unete",
							"Poruka",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		GridBagConstraints gbc_btnDodajBoju = new GridBagConstraints();
		gbc_btnDodajBoju.insets = new Insets(0, 0, 0, 5);
		gbc_btnDodajBoju.gridx = 0;
		gbc_btnDodajBoju.gridy = 3;
		pnlCentar.add(btnDodajBoju, gbc_btnDodajBoju);

		JButton btnBojaPozadine = new JButton("Boja pozadine");
		btnBojaPozadine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color backColor = JColorChooser.showDialog(null, "Choose background color", Color.black);
				if (backColor != null)
					pnlCentar.setBackground(backColor);
			}
		});
		pnlCentar.add(btnBojaPozadine);

		JButton btnIzmeniBoju = new JButton("Izmeni boju");
		btnIzmeniBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = listBoje.getSelectedIndex();
				String selectedElement = dlm.getElementAt(selectedIndex);
				String[] splittedList = selectedElement.split(" ");
				String red = splittedList[0];
				String green = splittedList[1];
				String blue = splittedList[2];

				DlgBoje dlgIzmeniBoju = new DlgBoje();
				dlgIzmeniBoju.getTextFieldRed().setText(red);
				dlgIzmeniBoju.getTextFieldGreen().setText(green);
				dlgIzmeniBoju.getTextFieldBlue().setText(blue);
				dlgIzmeniBoju.setModal(true);
				dlgIzmeniBoju.setVisible(true);

				if(dlgIzmeniBoju.isOk()) {
					dlm.removeElementAt(selectedIndex);

					dlm.add(selectedIndex, dlgIzmeniBoju.getTextFieldRed().getText() + " " +
							dlgIzmeniBoju.getTextFieldGreen().getText() + " " +
							dlgIzmeniBoju.getTextFieldBlue().getText());

					pnlCentar.setBackground(new Color(dlgIzmeniBoju.getRedInt(),
							dlgIzmeniBoju.getGreenInt(), dlgIzmeniBoju.getBlueInt()));
				} else {
					JOptionPane.showMessageDialog(null,
							"Vrednosti nisu dobro unete",
							"Poruka",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		GridBagConstraints gbc_btnIzmeniBoju = new GridBagConstraints();
		gbc_btnIzmeniBoju.insets = new Insets(0, 0, 0, 5);
		gbc_btnIzmeniBoju.gridx = 1;
		gbc_btnIzmeniBoju.gridy = 3;
		pnlCentar.add(btnIzmeniBoju, gbc_btnIzmeniBoju);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		pnlCentar.add(scrollPane, gbc_scrollPane);

		listBoje = new JList<String>();
		listBoje.setModel(dlm);
		scrollPane.setViewportView(listBoje);

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(new Color(128, 0, 64));
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[]{0, 0};
		gbl_pnlSouth.rowHeights = new int[]{0, 0};
		gbl_pnlSouth.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlSouth.setLayout(gbl_pnlSouth);

		JButton btnAntistresDugme = new JButton("Antistres dugme");
		btnAntistresDugme.setForeground(new Color(255, 255, 255));
		btnAntistresDugme.setBackground(new Color(0, 64, 128));
		btnAntistresDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)",
						"Proba dugmeta", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnAntistresDugme = new GridBagConstraints();
		gbc_btnAntistresDugme.gridx = 0;
		gbc_btnAntistresDugme.gridy = 0;
		pnlSouth.add(btnAntistresDugme, gbc_btnAntistresDugme);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(0, 255, 64));
		contentPane.add(pnlNorth, BorderLayout.NORTH);

		JLabel lblZadatak = new JLabel("Zadatak 1");
		pnlNorth.add(lblZadatak);

	}

}