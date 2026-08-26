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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DlgPoint dialogPoint = new DlgPoint();
	private DlgLine dialogLine = new DlgLine();
	private Point lineStartPoint = null;
	private DlgRectangle dialogRectangle = new DlgRectangle();
	private DlgCircle dialogCircle = new DlgCircle();
	private DlgDonut dialogDonut = new DlgDonut();
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
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setFont(new Font("Times New Roman", Font.BOLD, 12));
		tglbtnSelect.setBackground(new Color(132, 161, 196));
		tglbtnSelect.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		buttonGroup.add(tglbtnSelect);
		
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
						point.setEdgeColor(dialogPoint.getEdgeColor());
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
							line.setEdgeColor(dialogLine.getEdgeColor());
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
						rectangle.setEdgeColor(dialogRectangle.getEdgeColor());
						rectangle.setFillColor(dialogRectangle.getFillColor());
						pnlDrawing.getShapes().add(rectangle);
						pnlDrawing.repaint();

						dialogRectangle.getFldWidth().setText("");
						dialogRectangle.getFldHeight().setText("");
					}

					dialogRectangle.setOk(false);
				}
				
				if (tglbtnCircle.isSelected()) {
					dialogCircle.getFldX().setText(Integer.toString(e.getX()));
					dialogCircle.getFldY().setText(Integer.toString(e.getY()));

					dialogCircle.setVisible(true);

					if (dialogCircle.isOk()) {
						int x = Integer.parseInt(dialogCircle.getFldX().getText());
						int y = Integer.parseInt(dialogCircle.getFldY().getText());
						int radius = Integer.parseInt(dialogCircle.getFldRadius().getText());

						Circle circle = new Circle(new Point(x, y), radius);
						circle.setEdgeColor(dialogCircle.getEdgeColor());
						circle.setFillColor(dialogCircle.getFillColor());
						pnlDrawing.getShapes().add(circle);
						pnlDrawing.repaint();

						dialogCircle.getFldRadius().setText("");
					}

					dialogCircle.setOk(false);
				}
				
				if (tglbtnDonut.isSelected()) {
					dialogDonut.getFldX().setText(Integer.toString(e.getX()));
					dialogDonut.getFldY().setText(Integer.toString(e.getY()));

					dialogDonut.setVisible(true);

					if (dialogDonut.isOk()) {
						int x = Integer.parseInt(dialogDonut.getFldX().getText());
						int y = Integer.parseInt(dialogDonut.getFldY().getText());
						int outer = Integer.parseInt(dialogDonut.getFldOuterRadius().getText());
						int inner = Integer.parseInt(dialogDonut.getFldInnerRadius().getText());

						Donut donut = new Donut(new Point(x, y), outer, inner);
						donut.setEdgeColor(dialogDonut.getEdgeColor());
						donut.setFillColor(dialogDonut.getFillColor());
						pnlDrawing.getShapes().add(donut);
						pnlDrawing.repaint();

						dialogDonut.getFldOuterRadius().setText("");
						dialogDonut.getFldInnerRadius().setText("");
					}

					dialogDonut.setOk(false);
				}
				
				if (tglbtnSelect.isSelected()) {
					int clickedIndex = -1;
					for (int i = pnlDrawing.getShapes().size() - 1; i >= 0; i--) {
						if (pnlDrawing.getShapes().get(i).contains(e.getX(), e.getY())) {
							clickedIndex = i;
							break;
						}
					}

					boolean wasSelected = clickedIndex != -1 && pnlDrawing.getShapes().get(clickedIndex).isSelected();

					for (Shape shape : pnlDrawing.getShapes()) {
						shape.setSelected(false);
					}

					if (clickedIndex != -1 && wasSelected == false) {
						pnlDrawing.getShapes().get(clickedIndex).setSelected(true);
					}

					pnlDrawing.repaint();
				}

			}
		});
		pnlDrawingArea.add(pnlDrawing, BorderLayout.CENTER);

		pnlActions = new JPanel();
		pnlActions.setBackground(new Color(232, 240, 250));
		pnlActions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(pnlActions, BorderLayout.SOUTH);

		pnlActions.add(tglbtnSelect);

		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shape selectedShape = null;
				for (Shape shape : pnlDrawing.getShapes()) {
					if (shape.isSelected()) {
						selectedShape = shape;
						break;
					}
				}

				if (selectedShape == null) {
					JOptionPane.showMessageDialog(null, "No shape is selected.", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				else if (selectedShape instanceof Point) {
					Point point = (Point) selectedShape;

					dialogPoint.getFldX().setText(Integer.toString(point.getXCoord()));
					dialogPoint.getFldY().setText(Integer.toString(point.getYCoord()));

					dialogPoint.setVisible(true);

					if (dialogPoint.isOk()) {
						int x = Integer.parseInt(dialogPoint.getFldX().getText());
						int y = Integer.parseInt(dialogPoint.getFldY().getText());

						point.setXCoord(x);
						point.setYCoord(y);
						point.setEdgeColor(dialogPoint.getEdgeColor());
						pnlDrawing.repaint();
					}

					dialogPoint.setOk(false);
				}
				
				else if (selectedShape instanceof Line) {
					Line line = (Line) selectedShape;

					dialogLine.getFldStartX().setText(Integer.toString(line.getStartPoint().getXCoord()));
					dialogLine.getFldStartY().setText(Integer.toString(line.getStartPoint().getYCoord()));
					dialogLine.getFldEndX().setText(Integer.toString(line.getEndPoint().getXCoord()));
					dialogLine.getFldEndY().setText(Integer.toString(line.getEndPoint().getYCoord()));

					dialogLine.setVisible(true);

					if (dialogLine.isOk()) {
						int startX = Integer.parseInt(dialogLine.getFldStartX().getText());
						int startY = Integer.parseInt(dialogLine.getFldStartY().getText());
						int endX = Integer.parseInt(dialogLine.getFldEndX().getText());
						int endY = Integer.parseInt(dialogLine.getFldEndY().getText());

						line.getStartPoint().setXCoord(startX);
						line.getStartPoint().setYCoord(startY);
						line.getEndPoint().setXCoord(endX);
						line.getEndPoint().setYCoord(endY);
						line.setEdgeColor(dialogLine.getEdgeColor());
						pnlDrawing.repaint();
					}

					dialogLine.setOk(false);
				}
				
				else if (selectedShape instanceof Rectangle) {
					Rectangle rectangle = (Rectangle) selectedShape;

					dialogRectangle.getFldX().setText(Integer.toString(rectangle.getUpperLeftPoint().getXCoord()));
					dialogRectangle.getFldY().setText(Integer.toString(rectangle.getUpperLeftPoint().getYCoord()));
					dialogRectangle.getFldWidth().setText(Integer.toString(rectangle.getWidth()));
					dialogRectangle.getFldHeight().setText(Integer.toString(rectangle.getHeight()));

					dialogRectangle.setVisible(true);

					if (dialogRectangle.isOk()) {
						int x = Integer.parseInt(dialogRectangle.getFldX().getText());
						int y = Integer.parseInt(dialogRectangle.getFldY().getText());
						int width = Integer.parseInt(dialogRectangle.getFldWidth().getText());
						int height = Integer.parseInt(dialogRectangle.getFldHeight().getText());

						rectangle.getUpperLeftPoint().setXCoord(x);
						rectangle.getUpperLeftPoint().setYCoord(y);
						rectangle.setWidth(width);
						rectangle.setHeight(height);
						rectangle.setEdgeColor(dialogRectangle.getEdgeColor());
						rectangle.setFillColor(dialogRectangle.getFillColor());
						pnlDrawing.repaint();
					}

					dialogRectangle.setOk(false);
				}
				
				else if (selectedShape instanceof Donut) {
					Donut donut = (Donut) selectedShape;

					dialogDonut.getFldX().setText(Integer.toString(donut.getCenter().getXCoord()));
					dialogDonut.getFldY().setText(Integer.toString(donut.getCenter().getYCoord()));
					dialogDonut.getFldOuterRadius().setText(Integer.toString(donut.getRadius()));
					dialogDonut.getFldInnerRadius().setText(Integer.toString(donut.getInnerRadius()));

					dialogDonut.setVisible(true);

					if (dialogDonut.isOk()) {
						int x = Integer.parseInt(dialogDonut.getFldX().getText());
						int y = Integer.parseInt(dialogDonut.getFldY().getText());
						int outer = Integer.parseInt(dialogDonut.getFldOuterRadius().getText());
						int inner = Integer.parseInt(dialogDonut.getFldInnerRadius().getText());

						donut.getCenter().setXCoord(x);
						donut.getCenter().setYCoord(y);
						try {
							donut.setRadius(outer);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid input",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						donut.setInnerRadius(inner);
						donut.setEdgeColor(dialogDonut.getEdgeColor());
						donut.setFillColor(dialogDonut.getFillColor());
						pnlDrawing.repaint();
					}

					dialogDonut.setOk(false);
				}
				
				else if (selectedShape instanceof Circle) {
					Circle circle = (Circle) selectedShape;

					dialogCircle.getFldX().setText(Integer.toString(circle.getCenter().getXCoord()));
					dialogCircle.getFldY().setText(Integer.toString(circle.getCenter().getYCoord()));
					dialogCircle.getFldRadius().setText(Integer.toString(circle.getRadius()));

					dialogCircle.setVisible(true);

					if (dialogCircle.isOk()) {
						int x = Integer.parseInt(dialogCircle.getFldX().getText());
						int y = Integer.parseInt(dialogCircle.getFldY().getText());
						int radius = Integer.parseInt(dialogCircle.getFldRadius().getText());

						circle.getCenter().setXCoord(x);
						circle.getCenter().setYCoord(y);
						try {
							circle.setRadius(radius);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid input",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						circle.setEdgeColor(dialogCircle.getEdgeColor());
						circle.setFillColor(dialogCircle.getFillColor());
						pnlDrawing.repaint();
					}

					dialogCircle.setOk(false);
				}
			}
		});
		btnModify.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnModify.setBackground(new Color(132, 161, 196));
		btnModify.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		pnlActions.add(btnModify);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Shape selectedShape = null;
				for (Shape shape : pnlDrawing.getShapes()) {
					if (shape.isSelected()) {
						selectedShape = shape;
						break;
					}
				}

				if (selectedShape == null) {
					JOptionPane.showMessageDialog(null, "No shape is selected.", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if (selectedShape instanceof Point) {
					int confirm = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to delete this point?", "Confirm deletion",
							JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						pnlDrawing.getShapes().remove(selectedShape);
						pnlDrawing.repaint();
					}
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDelete.setBackground(new Color(132, 161, 196));
		btnDelete.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(95, 120, 150), 2),
				BorderFactory.createEmptyBorder(4, 12, 4, 12)));
		pnlActions.add(btnDelete);

	}

}
