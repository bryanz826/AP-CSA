//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/05
//Class - APCSA
//Lab  - Robot

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
	private static final long serialVersionUID = 1L;

public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString("Robot LAB ", 35, 35 );

      //call head method
      head(window);
      //call other methods
      upperBody(window);
      lowerBody(window);
   }

   public void head( Graphics window )
   {
	  //draw head
      window.setColor(Color.YELLOW);
      window.fillOval(300, 100, 200, 100);
      
      //draw eyes
      window.setColor(Color.GREEN);
      window.fillOval(340, 120, 20, 20);
      window.fillOval(440, 120, 20, 20);
      
      //draw nose
      window.setColor(Color.BLACK);
      window.fillOval(390, 148, 20, 10);
      
      //draw mouth
      window.setColor(Color.RED);
      window.drawArc(350, 150, 100, 40, 180, 180);
   }

   public void upperBody( Graphics window )
   {
	   //draw body
	   window.setColor(Color.YELLOW);
	   window.fillRect(337, 220, 127, 92);
	   window.setColor(Color.BLUE);
	   window.fillRect(338, 221, 125, 90);
	   
	   //draw arms
	   window.setColor(Color.BLACK);
	   window.drawLine(258, 172, 337, 220);
	   window.drawLine(463, 220, 542, 172);
   }

   public void lowerBody( Graphics window )
   {
	   //draw body
	   window.setColor(Color.YELLOW);
	   window.fillRect(337, 334, 127, 92);
	   window.setColor(Color.GRAY);
	   window.fillRect(338, 335, 125, 90);
	   
	   //draw legs
	   window.setColor(Color.BLACK);
	   window.drawLine(258, 504, 337, 425);
	   window.drawLine(463, 425, 542, 504);
   }
}