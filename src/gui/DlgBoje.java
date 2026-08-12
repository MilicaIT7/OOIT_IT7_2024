package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgBoje extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldRed;
	private JTextField textFieldGreen;
	private JTextField textFieldBlue;
	private boolean isOk = true;

	private int redInt;
	private int greenInt;
	private int blueInt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgBoje dialog = new DlgBoje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgBoje() {
		setBounds(100, 100, 450, 300);
		setTitle("Dodaj boju");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblRed = new JLabel("Red");
				GridBagConstraints gbc_lblRed = new GridBagConstraints();
				gbc_lblRed.anchor = GridBagConstraints.EAST;
				gbc_lblRed.insets = new Insets(0, 0, 5, 5);
				gbc_lblRed.gridx = 0;
				gbc_lblRed.gridy = 0;
				panel.add(lblRed, gbc_lblRed);
			}
			{
				textFieldRed = new JTextField();
				GridBagConstraints gbc_textFieldRed = new GridBagConstraints();
				gbc_textFieldRed.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldRed.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldRed.gridx = 1;
				gbc_textFieldRed.gridy = 0;
				panel.add(textFieldRed, gbc_textFieldRed);
				textFieldRed.setColumns(10);
			}
			{
				JLabel lblGreen = new JLabel("Green");
				GridBagConstraints gbc_lblGreen = new GridBagConstraints();
				gbc_lblGreen.anchor = GridBagConstraints.EAST;
				gbc_lblGreen.insets = new Insets(0, 0, 5, 5);
				gbc_lblGreen.gridx = 0;
				gbc_lblGreen.gridy = 1;
				panel.add(lblGreen, gbc_lblGreen);
			}
			{
				textFieldGreen = new JTextField();
				GridBagConstraints gbc_textFieldGreen = new GridBagConstraints();
				gbc_textFieldGreen.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldGreen.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldGreen.gridx = 1;
				gbc_textFieldGreen.gridy = 1;
				panel.add(textFieldGreen, gbc_textFieldGreen);
				textFieldGreen.setColumns(10);
			}
			{
				JLabel lblBlue = new JLabel("Blue");
				GridBagConstraints gbc_lblBlue = new GridBagConstraints();
				gbc_lblBlue.insets = new Insets(0, 0, 0, 5);
				gbc_lblBlue.anchor = GridBagConstraints.EAST;
				gbc_lblBlue.gridx = 0;
				gbc_lblBlue.gridy = 2;
				panel.add(lblBlue, gbc_lblBlue);
			}
			{
				textFieldBlue = new JTextField();
				GridBagConstraints gbc_textFieldBlue = new GridBagConstraints();
				gbc_textFieldBlue.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldBlue.gridx = 1;
				gbc_textFieldBlue.gridy = 2;
				panel.add(textFieldBlue, gbc_textFieldBlue);
				textFieldBlue.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String red = textFieldRed.getText();
						String green = textFieldGreen.getText();
						String blue = textFieldBlue.getText();

						try {
							redInt = Integer.parseInt(red);
							greenInt = Integer.parseInt(green);
							blueInt = Integer.parseInt(blue);

							if (redInt < 0 || redInt > 255) {
								JOptionPane.showMessageDialog(null,
										"Vrednosti moraju biti u opsegu", "Poruka",
										JOptionPane.ERROR_MESSAGE);
								isOk = false;
							} else if (greenInt < 0 || greenInt > 255) {
								JOptionPane.showMessageDialog(null,
										"Vrednosti moraju biti u opsegu", "Poruka",
										JOptionPane.ERROR_MESSAGE);
								isOk = false;
							} else if (blueInt < 0 || blueInt > 255) {
								JOptionPane.showMessageDialog(null,
										"Vrednosti moraju biti u opsegu", "Poruka",
										JOptionPane.ERROR_MESSAGE);
								isOk = false;
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null,
									"Vrednosti moraju biti unete i biti broj u opsegu",
									"Poruka",
									JOptionPane.ERROR_MESSAGE);
							isOk = false;
						}

						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextFieldRed() {
		return textFieldRed;
	}

	public void setTextFieldRed(JTextField textFieldRed) {
		this.textFieldRed = textFieldRed;
	}

	public JTextField getTextFieldGreen() {
		return textFieldGreen;
	}

	public void setTextFieldGreen(JTextField textFieldGreen) {
		this.textFieldGreen = textFieldGreen;
	}

	public JTextField getTextFieldBlue() {
		return textFieldBlue;
	}

	public void setTextFieldBlue(JTextField textFieldBlue) {
		this.textFieldBlue = textFieldBlue;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public int getRedInt() {
		return redInt;
	}

	public void setRedInt(int redInt) {
		this.redInt = redInt;
	}

	public int getGreenInt() {
		return greenInt;
	}

	public void setGreenInt(int greenInt) {
		this.greenInt = greenInt;
	}

	public int getBlueInt() {
		return blueInt;
	}

	public void setBlueInt(int blueInt) {
		this.blueInt = blueInt;
	}

}