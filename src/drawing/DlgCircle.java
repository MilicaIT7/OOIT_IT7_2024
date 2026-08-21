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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fldX;
	private JTextField fldY;
	private JTextField fldRadius;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setTitle("Grujić Milica, IT 7/2024");
		setModal(true);
		setBounds(100, 100, 420, 300);
		getContentPane().setLayout(new BorderLayout());

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(132, 161, 196));
		getContentPane().add(panelTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("CIRCLE DETAILS");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panelTitle.add(lblTitle);

		contentPanel.setBackground(new Color(245, 249, 253));
		contentPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 1),
				new EmptyBorder(15, 15, 15, 15)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblPositionSection = new JLabel("Center: ");
		lblPositionSection.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_lblPositionSection = new GridBagConstraints();
		gbc_lblPositionSection.anchor = GridBagConstraints.WEST;
		gbc_lblPositionSection.gridwidth = 4;
		gbc_lblPositionSection.insets = new Insets(0, 0, 8, 0);
		gbc_lblPositionSection.gridx = 0;
		gbc_lblPositionSection.gridy = 0;
		contentPanel.add(lblPositionSection, gbc_lblPositionSection);

		JLabel lblX = new JLabel("X coordinate:");
		lblX.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 28, 5);
		gbc_lblX.anchor = GridBagConstraints.EAST;
		gbc_lblX.gridx = 0;
		gbc_lblX.gridy = 1;
		contentPanel.add(lblX, gbc_lblX);

		fldX = new JTextField();
		GridBagConstraints gbc_fldX = new GridBagConstraints();
		gbc_fldX.insets = new Insets(0, 0, 28, 10);
		gbc_fldX.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldX.gridx = 1;
		gbc_fldX.gridy = 1;
		contentPanel.add(fldX, gbc_fldX);
		fldX.setColumns(6);

		JLabel lblY = new JLabel("Y coordinate:");
		lblY.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 28, 5);
		gbc_lblY.anchor = GridBagConstraints.EAST;
		gbc_lblY.gridx = 2;
		gbc_lblY.gridy = 1;
		contentPanel.add(lblY, gbc_lblY);

		fldY = new JTextField();
		GridBagConstraints gbc_fldY = new GridBagConstraints();
		gbc_fldY.insets = new Insets(0, 0, 28, 0);
		gbc_fldY.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldY.gridx = 3;
		gbc_fldY.gridy = 1;
		contentPanel.add(fldY, gbc_fldY);
		fldY.setColumns(6);

		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.gridx = 0;
		gbc_lblRadius.gridy = 2;
		contentPanel.add(lblRadius, gbc_lblRadius);

		fldRadius = new JTextField();
		GridBagConstraints gbc_fldRadius = new GridBagConstraints();
		gbc_fldRadius.insets = new Insets(0, 0, 0, 10);
		gbc_fldRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldRadius.gridx = 1;
		gbc_fldRadius.gridy = 2;
		contentPanel.add(fldRadius, gbc_fldRadius);
		fldRadius.setColumns(6);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(245, 249, 253));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField[] fields = { fldX, fldY, fldRadius };
				for (JTextField field : fields) {
					if (field.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "All fields must be filled in.",
								"Invalid input", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				try {
					Integer.parseInt(fldX.getText());
					Integer.parseInt(fldY.getText());
					int radius = Integer.parseInt(fldRadius.getText());

					if (radius <= 0) {
						JOptionPane.showMessageDialog(null, "Radius must be greater than zero.",
								"Invalid input", JOptionPane.ERROR_MESSAGE);
						return;
					}

					isOk = true;
					setVisible(false);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "All fields must contain valid whole numbers.",
							"Invalid input", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		okButton.setBackground(new Color(132, 161, 196));
		okButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		okButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setBackground(new Color(132, 161, 196));
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cancelButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}

	public JTextField getFldX() {
		return fldX;
	}

	public void setFldX(JTextField fldX) {
		this.fldX = fldX;
	}

	public JTextField getFldY() {
		return fldY;
	}

	public void setFldY(JTextField fldY) {
		this.fldY = fldY;
	}

	public JTextField getFldRadius() {
		return fldRadius;
	}

	public void setFldRadius(JTextField fldRadius) {
		this.fldRadius = fldRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
