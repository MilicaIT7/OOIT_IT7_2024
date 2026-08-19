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

public class DlgLine extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fldStartX;
	private JTextField fldStartY;
	private JTextField fldEndX;
	private JTextField fldEndY;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setTitle("Grujić Milica, IT 7/2024");
		setModal(true);
		setBounds(100, 100, 420, 300);
		getContentPane().setLayout(new BorderLayout());

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(132, 161, 196));
		getContentPane().add(panelTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("LINE DETAILS");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panelTitle.add(lblTitle);

		contentPanel.setBackground(new Color(245, 249, 253));
		contentPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 1),
				new EmptyBorder(15, 15, 15, 15)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblStartSection = new JLabel("Start point: ");
		lblStartSection.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_lblStartSection = new GridBagConstraints();
		gbc_lblStartSection.anchor = GridBagConstraints.WEST;
		gbc_lblStartSection.gridwidth = 4;
		gbc_lblStartSection.insets = new Insets(0, 0, 8, 0);
		gbc_lblStartSection.gridx = 0;
		gbc_lblStartSection.gridy = 0;
		contentPanel.add(lblStartSection, gbc_lblStartSection);

		JLabel lblStartX = new JLabel("X coordinate:");
		lblStartX.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblStartX = new GridBagConstraints();
		gbc_lblStartX.insets = new Insets(0, 0, 28, 5);
		gbc_lblStartX.anchor = GridBagConstraints.EAST;
		gbc_lblStartX.gridx = 0;
		gbc_lblStartX.gridy = 1;
		contentPanel.add(lblStartX, gbc_lblStartX);

		fldStartX = new JTextField();
		GridBagConstraints gbc_fldStartX = new GridBagConstraints();
		gbc_fldStartX.insets = new Insets(0, 0, 28, 10);
		gbc_fldStartX.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldStartX.gridx = 1;
		gbc_fldStartX.gridy = 1;
		contentPanel.add(fldStartX, gbc_fldStartX);
		fldStartX.setColumns(6);

		JLabel lblStartY = new JLabel("Y coordinate:");
		lblStartY.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblStartY = new GridBagConstraints();
		gbc_lblStartY.insets = new Insets(0, 0, 28, 5);
		gbc_lblStartY.anchor = GridBagConstraints.EAST;
		gbc_lblStartY.gridx = 2;
		gbc_lblStartY.gridy = 1;
		contentPanel.add(lblStartY, gbc_lblStartY);

		fldStartY = new JTextField();
		GridBagConstraints gbc_fldStartY = new GridBagConstraints();
		gbc_fldStartY.insets = new Insets(0, 0, 28, 0);
		gbc_fldStartY.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldStartY.gridx = 3;
		gbc_fldStartY.gridy = 1;
		contentPanel.add(fldStartY, gbc_fldStartY);
		fldStartY.setColumns(6);

		JLabel lblEndSection = new JLabel("End point: ");
		lblEndSection.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_lblEndSection = new GridBagConstraints();
		gbc_lblEndSection.anchor = GridBagConstraints.WEST;
		gbc_lblEndSection.gridwidth = 4;
		gbc_lblEndSection.insets = new Insets(0, 0, 8, 0);
		gbc_lblEndSection.gridx = 0;
		gbc_lblEndSection.gridy = 2;
		contentPanel.add(lblEndSection, gbc_lblEndSection);

		JLabel lblEndX = new JLabel("X coordinate:");
		lblEndX.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblEndX = new GridBagConstraints();
		gbc_lblEndX.insets = new Insets(0, 0, 0, 5);
		gbc_lblEndX.anchor = GridBagConstraints.EAST;
		gbc_lblEndX.gridx = 0;
		gbc_lblEndX.gridy = 3;
		contentPanel.add(lblEndX, gbc_lblEndX);

		fldEndX = new JTextField();
		GridBagConstraints gbc_fldEndX = new GridBagConstraints();
		gbc_fldEndX.insets = new Insets(0, 0, 0, 10);
		gbc_fldEndX.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldEndX.gridx = 1;
		gbc_fldEndX.gridy = 3;
		contentPanel.add(fldEndX, gbc_fldEndX);
		fldEndX.setColumns(6);

		JLabel lblEndY = new JLabel("Y coordinate:");
		lblEndY.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblEndY = new GridBagConstraints();
		gbc_lblEndY.insets = new Insets(0, 0, 0, 5);
		gbc_lblEndY.anchor = GridBagConstraints.EAST;
		gbc_lblEndY.gridx = 2;
		gbc_lblEndY.gridy = 3;
		contentPanel.add(lblEndY, gbc_lblEndY);

		fldEndY = new JTextField();
		GridBagConstraints gbc_fldEndY = new GridBagConstraints();
		gbc_fldEndY.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldEndY.gridx = 3;
		gbc_fldEndY.gridy = 3;
		contentPanel.add(fldEndY, gbc_fldEndY);
		fldEndY.setColumns(6);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(245, 249, 253));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField[] fields = { fldStartX, fldStartY, fldEndX, fldEndY };
				for (JTextField field : fields) {
					if (field.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Coordinates must be entered.",
								"Invalid input", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				try {
					Integer.parseInt(fldStartX.getText());
					Integer.parseInt(fldStartY.getText());
					Integer.parseInt(fldEndX.getText());
					Integer.parseInt(fldEndY.getText());

					isOk = true;
					setVisible(false);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Coordinates must be whole numbers.",
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

	public JTextField getFldStartX() {
		return fldStartX;
	}

	public void setFldStartX(JTextField fldStartX) {
		this.fldStartX = fldStartX;
	}

	public JTextField getFldStartY() {
		return fldStartY;
	}

	public void setFldStartY(JTextField fldStartY) {
		this.fldStartY = fldStartY;
	}

	public JTextField getFldEndX() {
		return fldEndX;
	}

	public void setFldEndX(JTextField fldEndX) {
		this.fldEndX = fldEndX;
	}

	public JTextField getFldEndY() {
		return fldEndY;
	}

	public void setFldEndY(JTextField fldEndY) {
		this.fldEndY = fldEndY;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
