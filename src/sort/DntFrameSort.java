package sort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import geometry.Donut;
import geometry.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DntFrameSort extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Donut> donutListModel = new DefaultListModel<Donut>();
	private DntDialogSort dialog = new DntDialogSort();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DntFrameSort frame = new DntFrameSort();
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
	public DntFrameSort() {
		setTitle("Grujić Milica, IT 7/2024");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(126, 146, 138));

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(126, 146, 138));
		contentPane.add(pnlTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("DONUT MANAGER");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pnlTitle.add(lblTitle);

		JPanel pnlList = new JPanel();
		pnlList.setBackground(new Color(225, 235, 231));
		contentPane.add(pnlList, BorderLayout.CENTER);
		pnlList.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollDonuts = new JScrollPane();
		scrollDonuts.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlList.add(scrollDonuts, BorderLayout.CENTER);

		JList<Donut> listDonuts = new JList<Donut>();
		listDonuts.setModel(donutListModel);
		listDonuts.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollDonuts.setViewportView(listDonuts);

		JPanel pnlActions = new JPanel();
		pnlActions.setBackground(new Color(225, 235, 231));
		contentPane.add(pnlActions, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dialog.setVisible(true);

				if (dialog.isOk()) {
					int x = Integer.parseInt(dialog.getFldCenterX().getText());
					int y = Integer.parseInt(dialog.getFldCenterY().getText());
					int outer = Integer.parseInt(dialog.getFldOuterRadius().getText());
					int inner = Integer.parseInt(dialog.getFldInnerRadius().getText());

					Donut donut = new Donut(new Point(x, y), outer, inner);
					donutListModel.addElement(donut);

					dialog.getFldCenterX().setText("");
					dialog.getFldCenterY().setText("");
					dialog.getFldOuterRadius().setText("");
					dialog.getFldInnerRadius().setText("");
					dialog.setOk(false);
				}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAdd.setBackground(new Color(126, 146, 138));
		btnAdd.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(90, 105, 99), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		pnlActions.add(btnAdd);

		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (donutListModel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty.", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				for (int i = 0; i < donutListModel.size() - 1; i++) {
				    for (int j = 0; j < donutListModel.size() - i - 1; j++) {
				        Donut current = donutListModel.get(j);
				        Donut next = donutListModel.get(j + 1);
				        if (current.compareTo(next) < 0) {
				            donutListModel.remove(j);
				            donutListModel.add(j, next);
				            donutListModel.remove(j + 1);
				            donutListModel.add(j + 1, current);
						}
					}
				}
			}
		});
		btnSort.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSort.setBackground(new Color(126, 146, 138));
		btnSort.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(90, 105, 99), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		pnlActions.add(btnSort);

	}

}
