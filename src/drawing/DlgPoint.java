package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgPoint extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fldX;
	private JTextField fldY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setTitle("Grujić Milica, IT 7/2024");
		setModal(true);
		setBounds(100, 100, 420, 260);
		getContentPane().setLayout(new BorderLayout());

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(132, 161, 196));
		getContentPane().add(panelTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("POINT DETAILS");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panelTitle.add(lblTitle);

		contentPanel.setBackground(new Color(245, 249, 253));
		contentPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 1),
				new EmptyBorder(15, 15, 15, 15)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblX = new JLabel("X coordinate:");
		lblX.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 0, 5);
		gbc_lblX.anchor = GridBagConstraints.EAST;
		gbc_lblX.gridx = 0;
		gbc_lblX.gridy = 0;
		contentPanel.add(lblX, gbc_lblX);

		fldX = new JTextField();
		GridBagConstraints gbc_fldX = new GridBagConstraints();
		gbc_fldX.insets = new Insets(0, 0, 0, 10);
		gbc_fldX.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldX.gridx = 1;
		gbc_fldX.gridy = 0;
		contentPanel.add(fldX, gbc_fldX);
		fldX.setColumns(6);

		JLabel lblY = new JLabel("Y coordinate:");
		lblY.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 0, 5);
		gbc_lblY.anchor = GridBagConstraints.EAST;
		gbc_lblY.gridx = 2;
		gbc_lblY.gridy = 0;
		contentPanel.add(lblY, gbc_lblY);

		fldY = new JTextField();
		GridBagConstraints gbc_fldY = new GridBagConstraints();
		gbc_fldY.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldY.gridx = 3;
		gbc_fldY.gridy = 0;
		contentPanel.add(fldY, gbc_fldY);
		fldY.setColumns(6);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(245, 249, 253));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setBackground(new Color(132, 161, 196));
		okButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		okButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(132, 161, 196));
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cancelButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}

}
