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

public class RosePanelDriver
{
   public static void main(String[] args) 
   {
      double radius = Double.parseDouble(JOptionPane.showInputDialog(null," Enter Radius: "));
      double petal = Double.parseDouble(JOptionPane.showInputDialog(null," Enter Number of Petals: "));
     /* double width = radius * 400;
       PREF_W.setPREF_W( (width) ); */
      RosePanel mainPanel = new RosePanel( radius, petal  );

      JFrame frame = new JFrame("RosePanel");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
      
      /* SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            createAndShowGui();
         }
      }); */
   }
}
