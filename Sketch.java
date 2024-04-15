import java.util.Random;
import processing.core.PApplet;

public class Sketch extends PApplet {
  
public void settings() {
  // Image Size
  size(500, 500);
}

 public void setup() {
  // Background Features
  background(52, 151, 227);
  noLoop();
  surface.setResizable(true);
  
 }

 public void draw() {
  noStroke();

  Random Colour1 = new Random();
  Random Colour2 = new Random();
  Random Colour3 = new Random();

  HouseDrawing(0, 0, height / 10, width / 10);
  HappyFaceDrawing(0, 0, height / 10, width / 10, Colour1.nextInt(0, 255), Colour2.nextInt(0, 255), Colour3.nextInt(0, 255));
  }

  /**
  * Happy or Sad
  *
  * @param OuterEyeColourMaker
  * @return Returns true if even, false if odd.
  * @author H. Rahukulan
  */

  public boolean ColourChecker(float OuterEyeColourMaker) {
    if (OuterEyeColourMaker % 2 == 0) {
      return true; 
    }
    else {
      return false;
    }
    }

   /**
  * A method that draws a house ordered in rows and columns.
  *
  * @param HouseX
  * @param HouseY
  * @param HouseSizeX
  * @param HouseSizeY
  * @author H. Rahukulan
  */

  public void HouseDrawing(float HouseX, float HouseY, float HouseSizeX, float HouseSizeY) {
    // House Drawings for rows and colunms
    for (HouseX = width / 10; HouseX <= width - (width / 10); HouseX += width / 4.3) {
      for (HouseY = height / 10; HouseY <= height - (height / 10); HouseY += height / 4) {
        
        // House
        fill(168, 50, 164);
        rect(HouseX, HouseY, HouseSizeX, HouseSizeY);
        
        // Roof
        fill(13, 1, 23);
        triangle(HouseX - Math.round(height * 0.025), HouseY, HouseX + Math.round(height * 0.05), HouseY - Math.round(height * 0.075), HouseX + Math.round(height * 0.13), HouseY);

        // Door
        fill(237, 61, 2);
        rect(HouseX + Math.round(width * 0.035), HouseY + Math.round(height * 0.04), Math.round(width * 0.03), Math.round(height * 0.06));
        }
      }
 }

  /**
  * A method that draws a happy face in rows and columns.
  *
  * @param FaceX
  * @param FaceY
  * @param FaceSizeX
  * @param FaceSizeY
  * @param FaceColour1
  * @param FaceColour2
  * @param FaceColour3
  * @author H. Rahukulan
  */

 public void HappyFaceDrawing(float FaceX, float FaceY, float FaceSizeX, float FaceSizeY, float FaceColour1, float FaceColour2, float FaceColour3) {

  // Face Drawings for columns and rows
  for (FaceX = width / 4; FaceX <= width - width / 4; FaceX += width / 4) {
    for (FaceY = height / 4; FaceY <= height - height / 4; FaceY += height / 4) {
      
      // Happy Face
      // Face
      fill(FaceColour1, FaceColour2, FaceColour3);
      ellipse(FaceX, FaceY, FaceSizeX, FaceSizeY);

      // Outer Eye
      noLoop();
      Random OddOrEven = new Random();
      int OuterEyeColourMaker = OddOrEven.nextInt(0, 2);
      boolean blnOutEyeColour = ColourChecker(OuterEyeColourMaker);
      if (blnOutEyeColour) {
        fill(0);
      }
      else {
        fill(255);
      }

      ellipse(FaceX - Math.round(width * 0.02), FaceY - Math.round(height * 0.015), Math.round(width * 0.02), Math.round(height * 0.01));
      ellipse(FaceX +  Math.round(width * 0.02), FaceY -  Math.round(height * 0.015), Math.round(width * 0.02), Math.round(height * 0.01));

      // Pupils
      fill(FaceColour3, FaceColour2, FaceColour1);
      ellipse(FaceX - Math.round(width * 0.02), FaceY - Math.round(height * 0.015), Math.round(width * 0.008), Math.round(height * 0.008));
      ellipse(FaceX + Math.round(width * 0.02), FaceY - Math.round(height * 0.015), Math.round(width * 0.008), Math.round(height * 0.008));

      // Draw the mouth
      arc(FaceX, FaceY, FaceSizeX - Math.round(width * 0.03) , FaceSizeY - Math.round(height * 0.03), 0, 3);
    }
  }
 }
}
 
