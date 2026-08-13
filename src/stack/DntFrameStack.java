package stack;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DntFrameStack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> donutListModel = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DntFrameStack frame = new DntFrameStack();
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
	public DntFrameStack() {
		setTitle("Grujić Milica, IT 7/2024");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(212, 178, 167));

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(212, 178, 167));
		contentPane.add(pnlTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("DONUT MANAGER");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pnlTitle.add(lblTitle);

		JPanel pnlList = new JPanel();
		pnlList.setBackground(new Color(239, 231, 218));
		contentPane.add(pnlList, BorderLayout.CENTER);
		pnlList.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollDonuts = new JScrollPane();
		scrollDonuts.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlList.add(scrollDonuts, BorderLayout.CENTER);

		JList<String> listDonuts = new JList<String>();
		listDonuts.setModel(donutListModel);
		listDonuts.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollDonuts.setViewportView(listDonuts);

		JPanel pnlActions = new JPanel();
		pnlActions.setBackground(new Color(239, 231, 218));
		contentPane.add(pnlActions, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAdd.setBackground(new Color(212, 178, 167));
		btnAdd.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(160, 120, 105), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		pnlActions.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDelete.setBackground(new Color(212, 178, 167));
		btnDelete.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(160, 120, 105), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		pnlActions.add(btnDelete);

	}

}