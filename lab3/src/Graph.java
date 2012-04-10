/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;

public class Graph extends Applet {

    private final int WINDOW_SIZE_X = 330;
    private final int WINDOW_SIZE_Y = 210;
    private final int AREA_SIZE_X = 330;
    private final int AREA_SIZE_Y = 210;
    private final int HALF_X = AREA_SIZE_X / 2;
    private final int HALF_Y = AREA_SIZE_Y / 2;
    private final int LENGTH_X = 100;
    private final int LENGTH_Y = 100;
    private final int INDENT = 5;
    private final int STEP = 20;

    /*
     * Массивы с координатами точек
     * для вывода четырёхугольника -
     * комбинация треугольника и прямоугольника
     */
    private int xPoints[] = {HALF_X, HALF_X, HALF_X - 2*STEP};
    private int yPoints[] = {HALF_Y, HALF_Y - 2*STEP, HALF_Y};
    private double x;
    private double y;
    public double R;
    public double gettingX;
    public double gettingY;

    private String[] letters={"-2R","","-R","-R/2","0","R/2","R","","2R"};
    private String message;
    private Boolean ShowM;
    private Boolean PointColor;


    /* Координаты текущей точки на области для вывода графика */
    private int xCoord;
    private int yCoord;
    private GraphicsCanvas gc;

    @Override
    public void init() {
        ShowM = true;
        x = 0;
        y = 0;
        String param1 = new String();
        String param2 = new String();
        String param3 = new String();
        String param4 = new String();
        param1 = getParameter("X");
        param2 = getParameter("Y");
        param3 = getParameter("R");
        param4 = getParameter("in");
        try
        {
            if ((param1 != null)&&(param2 != null)&&(param3 != null))
            {
                gettingX = Double.parseDouble(param1);
                gettingY = Double.parseDouble(param2);
                R = Double.parseDouble(param3);
                PointColor = Boolean.parseBoolean(param4);
            }
            else
            {
                gettingX = 0;
                gettingY = 0;
                R = 1;
                PointColor = true;
            }
        } catch (NumberFormatException e) {}



        xCoord = HALF_X;
        yCoord = HALF_Y;

        setLayout(new BorderLayout());

        gc = new GraphicsCanvas();
        add(gc, BorderLayout.CENTER);

        setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);

    }
    @Override
    public void paint(Graphics g) {
        if (gc.getGraphics() != null) {
            gc.repaint();
        }
    }

    /*
     * Метод для вывода графика и точек на экран
     */
    private void drawArea(Graphics g) {

        /* Рисуем фигуры */
        g.setColor(Color.blue);
        g.fillArc(HALF_X -  STEP, HALF_Y -  STEP,
                2*STEP, 2*STEP, 270, 90);
        g.fillRect(HALF_X, HALF_Y- 2 * STEP, STEP, 2*STEP);
        g.fillPolygon(xPoints, yPoints, xPoints.length);

        /* Рисуем Оси */
        g.setColor(Color.black);
        g.drawLine(HALF_X - LENGTH_X, HALF_Y, HALF_X + LENGTH_X, HALF_Y);
        g.drawLine(HALF_X, HALF_Y - LENGTH_Y, HALF_X, HALF_Y + LENGTH_Y);

        /* Рисуем стрелочки у осей */
        g.drawLine(HALF_X, HALF_Y - LENGTH_Y,
                HALF_X - INDENT / 2, HALF_Y - LENGTH_Y + INDENT);
        g.drawLine(HALF_X, HALF_Y - LENGTH_Y,
                HALF_X + INDENT / 2, HALF_Y - LENGTH_Y + INDENT);
        g.drawLine(HALF_X + LENGTH_X, HALF_Y,
                HALF_X + LENGTH_X - INDENT, HALF_Y - INDENT / 2);
        g.drawLine(HALF_X + LENGTH_X, HALF_Y,
                HALF_X + LENGTH_X - INDENT, HALF_Y + INDENT / 2);

        /* Рисуем отсечки на осях */
        for (int i = -4; i <= 4; i++) {
            g.drawLine(HALF_X - INDENT / 2, HALF_Y + i * STEP,
                    HALF_X + INDENT / 2, HALF_Y + i * STEP);
        }
        for (int i = -4; i <= 4; i++) {
            g.drawLine(HALF_X + i * STEP, HALF_Y - INDENT / 2,
                    HALF_X + i * STEP, HALF_Y + INDENT / 2);
        }

        /* Вывод подписей */
        g.drawString("Y", HALF_X + INDENT, HALF_Y - LENGTH_Y + INDENT);
        g.drawString("X", HALF_X + LENGTH_X - INDENT, HALF_Y - INDENT);

          for (int i = -4; i <= 4; i++) {
            if (i == 0) {
                continue;
            }
            g.drawString(letters[i+4], HALF_X + i * STEP - INDENT,
                    HALF_Y - INDENT);
            if ((i >= -4) && (i <= 4)) {
            g.drawString(letters[i+4], HALF_X + INDENT,
                    HALF_Y - i * STEP + INDENT / 2);
            }
        }

        double pixelsPerUnit = 2 * STEP / R;
        xCoord = HALF_X + (int) Math.round(pixelsPerUnit * gettingX);
        yCoord = HALF_Y - (int) Math.round(pixelsPerUnit * gettingY);
        if (PointColor)
        {
            g.setColor(Color.GREEN);
        }
        else
        {
            g.setColor(Color.RED);
        }
        g.fillOval(xCoord - 2, yCoord - 2, 4, 4);
        g.setColor(Color.black);
    }

 /**
     * Класс MouseClick реализует обработку щелчка мышкой по графическому полю
     */
   /* class MouseClick extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent me) {
            double unitPerPixel = R / 2 / STEP;
            int tempXPoint = me.getX();
            int tempYPoint = me.getY();

            if ((tempXPoint < (HALF_X + LENGTH_X))
                    && (tempXPoint > (HALF_X - LENGTH_X))
                    && (tempYPoint < (HALF_Y + LENGTH_Y))
                    && (tempYPoint > (HALF_Y - LENGTH_Y))) {

                xCoord = tempXPoint;
                yCoord = tempYPoint;
                x = (xCoord - HALF_X) * unitPerPixel;
                y = (HALF_Y - yCoord) * unitPerPixel;

                if (ShowM)
               {
                	message = "x = " + Double.toString(x) + "\ny = " + Double.toString(y) + "\nR = " + Double.toString(R);
                	JOptionPane.showMessageDialog(null, message,"Message",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
	message = "Cant show chords, cuz there is no any R value";
                	JOptionPane.showMessageDialog(null, message,"Message",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    } */


    /**
     * Класс GraphicsCanvas реализует поле для вывода графической информации
     */
    class GraphicsCanvas extends Canvas {

        public GraphicsCanvas() {
            setSize(AREA_SIZE_X, AREA_SIZE_Y);
            setBackground(Color.WHITE);
        }
        @Override
        public void paint(Graphics g) {
            drawArea(g);
        }
    }
}
