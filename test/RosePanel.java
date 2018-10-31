import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.util.Scanner;

@SuppressWarnings("serial")
public class RosePanel extends JPanel {
   private int PREF_W = 400;
   private int PREF_H = PREF_W;
   private static final double MAX = 100;
   private static final double SCALE = 150.0;
   private static final double DELTA_X = 400;
   private static final double DELTA_Y = DELTA_X;
   private static final Color ROSE_COLOR = Color.green;
   private static final Stroke ROSE_STROKE = new BasicStroke(8f);
   private Path2D path = new Path2D.Double();
   private double radius;
   private double petal;

   

   public RosePanel(double radius, double petal) {
     // Scanner rInput = new Scanner(System.in);
      
      
      for (double i = 0; i < MAX; i++) {
       // double rInput = Scanner.nextDouble();
         
         double placeholder = 2;
         double theta = i * 2 * Math.PI / MAX;
         if( petal % placeholder == 0)
         {
             double r =  radius * Math.cos(( petal ) * theta);
             double dX = SCALE * r * Math.cos(theta) + DELTA_X;
             double dY = SCALE * r * Math.sin(theta) + DELTA_Y;
             if (i == 0)
             {
                 path.moveTo(dX, dY);
               }
               else
               {
                    path.lineTo(dX, dY);
                }
         }
         else
         {
             double r =  radius * Math.cos(petal * theta);
             double dX = SCALE * r * Math.cos(theta) + DELTA_X;
             double dY = SCALE * r * Math.sin(theta) + DELTA_Y;
             if (i == 0) 
             {
                 path.moveTo(dX, dY);
             }
             else 
             {
                 path.lineTo(dX, dY);
             }             
         }
      
      }
      
      path.closePath();
   }

    @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(ROSE_COLOR);
      g2.setStroke(ROSE_STROKE);
      g2.draw(path);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }
   
   public double getPREF_W()
   {
       return PREF_W;
   }
   
   public void setPREF_W( double PREF_W2 )
   {
       PREF_W = (int)PREF_W2;
   }

  
}