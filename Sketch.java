import java.util.Random;
import processing.core.PApplet;

/**
* A program Sketch.java that uses methods with parameters to draw composite objects at various locations.
* @author: H. Rahukulan
*
*/

public class Sketch extends PApplet {
  
  /**
  * Called once at the beginning of execution, put your size all in this method
  */
 public void settings() {
  // Image Size
  size(500, 500);
 }

  /** 
  * Called once at the beginning of execution.  Add initial set up
  * values here i.e background, stroke, fill etc.
  */
 public void setup() {
  // Background Features
  background(52, 151, 227);
  noLoop();
 }

  /** 
  * Called repeatedly, anything drawn to the screen goes here
  */
 public void draw() {
  noStroke();

  // Inserting values in parameters
  for (int intRow = 0; intRow <= 3; intRow ++) {
    for (int intColumn = 0; intColumn <= 3; intColumn ++) {
      HouseDrawing((float) intColumn / 4 * width / 2 + (width / 25), (float) intRow / 4 * height + (height / 10), intRow);
  }
}
  for (int intRow = 1; intRow <= 3; intRow ++) {
    for (int intColumn = 1; intColumn <= 3; intColumn ++) {
      HappyFaceDrawing((float) intColumn / 4 * width, (float) intRow / 4 * height, intRow);
  }
}
}

  /**
  * A method that draws a house ordered in rows and columns given x and y coordinates and colour.
  *
  * @param HouseX
  * @param HouseY
  * @param intHouseColour
  * @author H. Rahukulan
  */
  public void HouseDrawing(float HouseX, float HouseY, int intHouseColour) {
        
    // House
    if (intHouseColour == 0) {
      fill(242, 24, 24);
    }
    else if (intHouseColour == 1) {
      fill(230, 142, 28);
    }
    else if (intHouseColour == 2) {
      fill(223, 230, 28);
    }
    else if (intHouseColour == 3) {
      fill(29, 153, 8);
    }
    rect(HouseX * 2, HouseY , width / 10, height / 10);
        
    // Roof
    fill(13, 1, 23);
    triangle(HouseX * 2 - Math.round(height * 0.025), HouseY, HouseX * 2 + Math.round(height * 0.05), HouseY - Math.round(height * 0.075), HouseX * 2 + Math.round(height * 0.13), HouseY);

    // Door
    fill(237, 61, 2);
    rect(HouseX * 2 + Math.round(width * 0.035), HouseY + Math.round(height * 0.04), Math.round(width * 0.03), Math.round(height * 0.06));
  }
 
  /**
  * A boolean method used to determine if a number is even or odd.
  *
  * @param OddOrEvenNumber
  * @return Returns true if even, false if odd.
  * @author H. Rahukulan
  */
  public boolean ColourChecker(float OddOrEvenNumber) {
    if (OddOrEvenNumber % 2 == 0) {
      return true; 
    }
    else {
      return false;
    }
    }

  /**
  * A method that draws a happy face in rows and columns given x and y coordinates and colour.
  *
  * @param FaceX
  * @param FaceY
  * @param intHappyFaceColour
  * @author H. Rahukulan
  */
  public void HappyFaceDrawing(float FaceX, float FaceY, int intHappyFaceColour) {
      
    // Face
    if (intHappyFaceColour == 1) {
      fill(10, 120, 171);
    }
    else if (intHappyFaceColour == 2) {
      fill(7, 53, 222);
    }
    else if (intHappyFaceColour == 3) {
      fill(143, 58, 222);
    }
    ellipse(FaceX, FaceY, width / 10, height / 10);

    // Outer Eye
    Random RandomOddOrEven = new Random();
    int OuterEyeColourMaker = RandomOddOrEven.nextInt(0, 2);
      
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
    fill(242, 24, 24);
    ellipse(FaceX - Math.round(width * 0.02), FaceY - Math.round(height * 0.015), Math.round(width * 0.008), Math.round(height * 0.008));
    ellipse(FaceX + Math.round(width * 0.02), FaceY - Math.round(height * 0.015), Math.round(width * 0.008), Math.round(height * 0.008));

    // Draw the mouth
    arc(FaceX, FaceY, width / 10 - Math.round(width * 0.03) , height / 10 - Math.round(height * 0.03), 0, 3);
    }
 }