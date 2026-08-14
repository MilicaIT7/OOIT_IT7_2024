package stack;

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

public class DntDialogStack extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField fldCenterX;
	private JTextField fldCenterY;
	private JTextField fldOuterRadius;
	private JTextField fldInnerRadius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DntDialogStack dialog = new DntDialogStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DntDialogStack() {
		setTitle("Grujić Milica, IT 7/2024");
		setModal(true);
		setBounds(100, 100, 420, 300);
		getContentPane().setLayout(new BorderLayout());

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(212, 178, 167));
		getContentPane().add(panelTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("DONUT DETAILS");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panelTitle.add(lblTitle);

		contentPanel.setBackground(new Color(239, 231, 218));
		contentPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(160, 120, 105), 1),
				new EmptyBorder(15, 15, 15, 15)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblPositionSection = new JLabel("Position: ");
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

		fldCenterX = new JTextField();
		GridBagConstraints gbc_fldCenterX = new GridBagConstraints();
		gbc_fldCenterX.insets = new Insets(0, 0, 28, 10);
		gbc_fldCenterX.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldCenterX.gridx = 1;
		gbc_fldCenterX.gridy = 1;
		contentPanel.add(fldCenterX, gbc_fldCenterX);
		fldCenterX.setColumns(6);

		JLabel lblY = new JLabel("Y coordinate:");
		lblY.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 28, 5);
		gbc_lblY.anchor = GridBagConstraints.EAST;
		gbc_lblY.gridx = 2;
		gbc_lblY.gridy = 1;
		contentPanel.add(lblY, gbc_lblY);

		fldCenterY = new JTextField();
		GridBagConstraints gbc_fldCenterY = new GridBagConstraints();
		gbc_fldCenterY.insets = new Insets(0, 0, 28, 0);
		gbc_fldCenterY.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldCenterY.gridx = 3;
		gbc_fldCenterY.gridy = 1;
		contentPanel.add(fldCenterY, gbc_fldCenterY);
		fldCenterY.setColumns(6);

		JLabel lblSizeSection = new JLabel("Size: ");
		lblSizeSection.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_lblSizeSection = new GridBagConstraints();
		gbc_lblSizeSection.anchor = GridBagConstraints.WEST;
		gbc_lblSizeSection.gridwidth = 4;
		gbc_lblSizeSection.insets = new Insets(0, 0, 8, 0);
		gbc_lblSizeSection.gridx = 0;
		gbc_lblSizeSection.gridy = 2;
		contentPanel.add(lblSizeSection, gbc_lblSizeSection);

		JLabel lblOuterRadius = new JLabel("Outer radius:");
		lblOuterRadius.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
		gbc_lblOuterRadius.insets = new Insets(0, 0, 0, 5);
		gbc_lblOuterRadius.anchor = GridBagConstraints.EAST;
		gbc_lblOuterRadius.gridx = 0;
		gbc_lblOuterRadius.gridy = 3;
		contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);

		fldOuterRadius = new JTextField();
		GridBagConstraints gbc_fldOuterRadius = new GridBagConstraints();
		gbc_fldOuterRadius.insets = new Insets(0, 0, 0, 10);
		gbc_fldOuterRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldOuterRadius.gridx = 1;
		gbc_fldOuterRadius.gridy = 3;
		contentPanel.add(fldOuterRadius, gbc_fldOuterRadius);
		fldOuterRadius.setColumns(6);

		JLabel lblInnerRadius = new JLabel("Inner radius:");
		lblInnerRadius.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
		gbc_lblInnerRadius.insets = new Insets(0, 0, 0, 5);
		gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
		gbc_lblInnerRadius.gridx = 2;
		gbc_lblInnerRadius.gridy = 3;
		contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);

		fldInnerRadius = new JTextField();
		GridBagConstraints gbc_fldInnerRadius = new GridBagConstraints();
		gbc_fldInnerRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_fldInnerRadius.gridx = 3;
		gbc_fldInnerRadius.gridy = 3;
		contentPanel.add(fldInnerRadius, gbc_fldInnerRadius);
		fldInnerRadius.setColumns(6);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(239, 231, 218));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setBackground(new Color(212, 178, 167));
		okButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		okButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(160, 120, 105), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(212, 178, 167));
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cancelButton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(160, 120, 105), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}

}
