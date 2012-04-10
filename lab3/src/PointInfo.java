/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.context.*;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import java.util.*;


/**
 *
 * @author Andrew;
 */
@ManagedBean
//@ApplicationScoped
@SessionScoped
public class PointInfo {
    private static ArrayList<Point> Points = new ArrayList<Point>();
    private double x; //x
    private double y; //y
    private double r = 1; //R
    private boolean containes=true; // in Area

    public String addPoint()
    {
        Point pnt = new Point(x, y, r);
        this.containes = pnt.getisContaines();
        Points.add(pnt);
        return "";
    }
    public ArrayList<Point> getPoints()
    {
           return Points;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getR()
    {
        return r;
    }

    public void setR(double r)
    {
        this.r = r;
    }

    public boolean getContaines()
    {
        return containes;
    }

     public void xCommandLinkClicked()
     {
         FacesContext facesContext = FacesContext.getCurrentInstance();
         Map<String,String> params =
                facesContext.getExternalContext().getRequestParameterMap();
         x =Double.parseDouble(params.get("x")) ;
     }
    public class Point
    {
        /** x */
        private double x;
        /** y */
        private double y;
        /** R */
        private double R;
        /** isContaines */
        private boolean isContaines;
        /** true or false */
        public Point(double x, double y, double R)
        {
            this.x = x;
            this.y = y;
            this.R = R;
            this.isContaines = (((x >= 0) && (y <= 0) && ((x * x + y * y) <= ((R * R)/4.0))) ||((x >= 0) && (y >=0) && (y <=R)&& (x<R/2.0))||
                    ((x <= 0) && (y>=0) && (y <= x+R)));
        }

          /* ---------- свойства ------------- */
          public double getX() {
            return x;
          }

          public void setX(double x) {
            this.x = x;
          }

          public double getY() {
            return y;
          }

          public void setY(double y) {
            this.y = y;
          }

          public double getR() {
            return R;
          }

          public void setR(double R) {
            this.R = R;
          }

          public boolean getisContaines() {
            return isContaines;
          }



    }

}
