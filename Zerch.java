package robozed;
import robocode.*;

import java.awt.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Zerch - a robot by (your name here)
 */
public class Zerch extends robocode.AdvancedRobot
{
  double enemyDistance;
  double enemyRelativeAngle;
  double enemyX;
  double enemyY;
  double enemyPosition;
  double enemyVelocity;
  double enemyHeading;
  double enemyAbsoluteAngle;
  
  double enemyExtrapolatedAbsoluteBearing;

    /**
     * run: Zerch's default behavior
     */
    public void run() {
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:

        // setColors(Color.red,Color.blue,Color.green); // body,gun,radar

        // Robot main loop

      // setAdjustGunForRobotTurn(true);
      // setAdjustRadarForGunTurn(true);
      turnGunRight(90);

      while(true) {
            // Replace the next 4 lines with any behavior you would like
            setAhead(250);
            setTurnGunRight(360);
            // setTurnRadarRight(360);
            // back(300);
            execute();
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Replace the next line with any behavior you would like

      // double getEnemyPosition = ;

      enemyDistance      = e.getDistance();
      enemyRelativeAngle = e.getBearingRadians();
      enemyAbsoluteAngle = enemyRelativeAngle + getHeadingRadians();
      enemyX      = (enemyDistance * Math.sin(enemyAbsoluteAngle) + getX());
      enemyY      = (enemyDistance * Math.cos(enemyAbsoluteAngle) + getY());
      // enemyPosition      = 
      enemyVelocity      = e.getVelocity();
      enemyHeading       = e.getHeadingRadians();
      fire(1);

    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        // back(10);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
      System.out.println(e.getBearing());
      turnRight(e.getBearing() + 90);
    }

    public void onPaint(Graphics2D g) {
      int robotCornerX = (int) (getX() - getWidth()  / 2);
      int robotCornerY = (int) (getY() - getHeight() / 2);
      int arrowLength = 100;
      int pointEndX = (int) (arrowLength * Math.sin(getHeadingRadians()) + getX());
      int pointEndY = (int) (arrowLength * Math.cos(getHeadingRadians()) + getY());
      g.setColor(Color.orange);
      g.drawLine((int) getX(), (int) getY(), pointEndX, pointEndY);
      g.drawRect((int) robotCornerX, (int) robotCornerY, (int) getHeight(), (int) getWidth());


      // draw a box around the enemy
      

      
      g.setColor(Color.red);
      g.drawLine((int) getX(), (int) getY(), (int) enemyX, (int) enemyY);
    }

}
