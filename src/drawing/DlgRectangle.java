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

public class DlgRectangle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fldX;
	private JTextField fldY;
	private JTextField fldWidth;
	private JTextField fldHeight;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setTitle("Grujić Milica, IT 7/2024");
		setModal(true);
		setBounds(100, 100, 420, 300);
		getContentPane().setLayout(new BorderLayout());

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(132, 161, 196));
		getContentPane().add(panelTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("RECTANGLE DETAILS");
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

		JLabel lblPositionSection = new JLabel("Upper left point: ");
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

		JLabel lblSizeSection = new JLabel("Size: ");
		lblSizeSection.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_lblSizeSection = new GridBagConstraints();
		gbc_lblSizeSection.anchor = GridBagConstraints.WEST;
		gbc_lblSizeSection.gridwidth = 4;
		gbc_lblSizeSection.insets = new Insets(0, 0, 8, 0);
		gbc_lblSizeSection.gridx = 0;
		gbc_lblSizeSection.gridy = 2;
		contentPanel.add(lblSizeSection, gbc_lblSizeSection);

		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.insets = new Insets(0, 0, 0, 5);
		gbc_lblWidth.anchor = GridBagConstraints.EAST;
		gbc_lblWidth.gridx = 0;
		gbc_lblWidth.gridy = 3;
		contentPanel.add(lblWidth, gbc_lblWidth);

		fldWidth = new JTextField();
		GridBagConstraints gbc_fldWidth = new GridBagConstraints();
		gbc_fldWidth.insets = new Insets(0, 0, 0, 10);
		gbc_fldWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldWidth.gridx = 1;
		gbc_fldWidth.gridy = 3;
		contentPanel.add(fldWidth, gbc_fldWidth);
		fldWidth.setColumns(6);

		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
		gbc_lblHeight.anchor = GridBagConstraints.EAST;
		gbc_lblHeight.gridx = 2;
		gbc_lblHeight.gridy = 3;
		contentPanel.add(lblHeight, gbc_lblHeight);

		fldHeight = new JTextField();
		GridBagConstraints gbc_fldHeight = new GridBagConstraints();
		gbc_fldHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldHeight.gridx = 3;
		gbc_fldHeight.gridy = 3;
		contentPanel.add(fldHeight, gbc_fldHeight);
		fldHeight.setColumns(6);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(245, 249, 253));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField[] fields = { fldX, fldY, fldWidth, fldHeight };
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
					int width = Integer.parseInt(fldWidth.getText());
					int height = Integer.parseInt(fldHeight.getText());

					if (width <= 0 || height <= 0) {
						JOptionPane.showMessageDialog(null, "Width and height must be greater than zero.",
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

	public JTextField getFldWidth() {
		return fldWidth;
	}

	public void setFldWidth(JTextField fldWidth) {
		this.fldWidth = fldWidth;
	}

	public JTextField getFldHeight() {
		return fldHeight;
	}

	public void setFldHeight(JTextField fldHeight) {
		this.fldHeight = fldHeight;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
