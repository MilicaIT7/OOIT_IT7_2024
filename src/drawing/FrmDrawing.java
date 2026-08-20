package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDrawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DlgPoint dialogPoint = new DlgPoint();
	private DlgLine dialogLine = new DlgLine();
	private Point lineStartPoint = null;
	private DlgRectangle dialogRectangle = new DlgRectangle();
	private JPanel pnlDrawingArea;
	private JPanel pnlActions;
	private JPanel pnlTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		setTitle("Grujić Milica, IT 7/2024");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(132, 161, 196));

		pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(132, 161, 196));
		contentPane.add(pnlTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("DRAWING APPLICATION");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pnlTitle.add(lblTitle);

		pnlDrawingArea = new JPanel();
		pnlDrawingArea.setBackground(new Color(232, 240, 250));
		pnlDrawingArea.setLayout(new BorderLayout(0, 0));
		contentPane.add(pnlDrawingArea, BorderLayout.CENTER);

		JPanel pnlShapes = new JPanel();
		pnlShapes.setBackground(new Color(232, 240, 250));
		pnlShapes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlDrawingArea.add(pnlShapes, BorderLayout.NORTH);

		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tglbtnPoint.setBackground(new Color(132, 161, 196));
		tglbtnPoint.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		buttonGroup.add(tglbtnPoint);
		pnlShapes.add(tglbtnPoint);

		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tglbtnLine.setBackground(new Color(132, 161, 196));
		tglbtnLine.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		buttonGroup.add(tglbtnLine);
		pnlShapes.add(tglbtnLine);

		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tglbtnRectangle.setBackground(new Color(132, 161, 196));
		tglbtnRectangle.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		buttonGroup.add(tglbtnRectangle);
		pnlShapes.add(tglbtnRectangle);

		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tglbtnCircle.setBackground(new Color(132, 161, 196));
		tglbtnCircle.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		buttonGroup.add(tglbtnCircle);
		pnlShapes.add(tglbtnCircle);

		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tglbtnDonut.setBackground(new Color(132, 161, 196));
		tglbtnDonut.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		buttonGroup.add(tglbtnDonut);
		pnlShapes.add(tglbtnDonut);
		
		PnlDrawing pnlDrawing = new PnlDrawing();
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (tglbtnPoint.isSelected()) {
					dialogPoint.getFldX().setText(Integer.toString(e.getX()));
					dialogPoint.getFldY().setText(Integer.toString(e.getY()));

					dialogPoint.setVisible(true);

					if (dialogPoint.isOk()) {
						int x = Integer.parseInt(dialogPoint.getFldX().getText());
						int y = Integer.parseInt(dialogPoint.getFldY().getText());

						Point point = new Point(x, y);
						pnlDrawing.getShapes().add(point);
						pnlDrawing.repaint();
					}

					dialogPoint.setOk(false);
				}
				
				if (tglbtnLine.isSelected()) {
					if (lineStartPoint == null) {
						lineStartPoint = new Point(e.getX(), e.getY());
					} else {
						dialogLine.getFldStartX().setText(Integer.toString(lineStartPoint.getXCoord()));
						dialogLine.getFldStartY().setText(Integer.toString(lineStartPoint.getYCoord()));
						dialogLine.getFldEndX().setText(Integer.toString(e.getX()));
						dialogLine.getFldEndY().setText(Integer.toString(e.getY()));

						dialogLine.setVisible(true);

						if (dialogLine.isOk()) {
							int startX = Integer.parseInt(dialogLine.getFldStartX().getText());
							int startY = Integer.parseInt(dialogLine.getFldStartY().getText());
							int endX = Integer.parseInt(dialogLine.getFldEndX().getText());
							int endY = Integer.parseInt(dialogLine.getFldEndY().getText());

							Line line = new Line(new Point(startX, startY), new Point(endX, endY));
							pnlDrawing.getShapes().add(line);
							pnlDrawing.repaint();
						}

						dialogLine.setOk(false);
						lineStartPoint = null;
					}
				}
				
				if (tglbtnRectangle.isSelected()) {
					dialogRectangle.getFldX().setText(Integer.toString(e.getX()));
					dialogRectangle.getFldY().setText(Integer.toString(e.getY()));

					dialogRectangle.setVisible(true);

					if (dialogRectangle.isOk()) {
						int x = Integer.parseInt(dialogRectangle.getFldX().getText());
						int y = Integer.parseInt(dialogRectangle.getFldY().getText());
						int width = Integer.parseInt(dialogRectangle.getFldWidth().getText());
						int height = Integer.parseInt(dialogRectangle.getFldHeight().getText());

						Rectangle rectangle = new Rectangle(new Point(x, y), width, height);
						pnlDrawing.getShapes().add(rectangle);
						pnlDrawing.repaint();

						dialogRectangle.getFldWidth().setText("");
						dialogRectangle.getFldHeight().setText("");
					}

					dialogRectangle.setOk(false);
				}

			}
		});
		pnlDrawingArea.add(pnlDrawing, BorderLayout.CENTER);

		pnlActions = new JPanel();
		pnlActions.setBackground(new Color(232, 240, 250));
		pnlActions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(pnlActions, BorderLayout.SOUTH);

		JButton btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSelect.setBackground(new Color(132, 161, 196));
		btnSelect.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		pnlActions.add(btnSelect);

		JButton btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnModify.setBackground(new Color(132, 161, 196));
		btnModify.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		pnlActions.add(btnModify);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDelete.setBackground(new Color(132, 161, 196));
		btnDelete.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		pnlActions.add(btnDelete);

	}

}
