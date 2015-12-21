import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Random;

/**
 * The abstract House for the Game of Thrones Simulation
 * @author Trevor Karr
 * @version 1.0
 */

public abstract class House {

    protected int xPos, yPos, age, health, xDisplacement, yDisplacement;
    protected String northSouth, houseType, imageFilename;
    private ImageIcon image;

    /**
     * Constructor
     *
     * @param x top left x position
     * @param y top left y position
     * @param fn name of file for image
     */
    public House(int x, int y, String fn) {
        imageFilename = fn;
        this.image = new ImageIcon(imageFilename);
        this.xPos = x;
        this.yPos = y;
        this.age = 0;
        this.health = 100;
    }

    /**
     * Checks if North or South house (special abilities)
     * Moves in a random direction
     */
    public void move() {
        Random rand = new Random();
        if (this.getNorthSouth().equals("North") && (this.yPos < 300)) {
            this.health += 5;
            xDisplacement = 20 - rand.nextInt(40);
            yDisplacement = 20 - rand.nextInt(40);
        } else if (this.getNorthSouth().equals("South") && (this.yPos > 300)) {
            xDisplacement = 40 - rand.nextInt(80);
            yDisplacement = 40 - rand.nextInt(80);
        } else {
            xDisplacement = 20 - rand.nextInt(40);
            yDisplacement = 20 - rand.nextInt(40);
        }
        this.age++;
        this.health--;
        if (((xDisplacement + this.xPos) < 510)
            && ((xDisplacement + this.xPos) > 0)) {
            this.xPos += xDisplacement;
        }
        if (((yDisplacement + this.yPos) < 540)
            && ((yDisplacement + this.yPos) > 0)) {
            this.yPos += yDisplacement;
        }

    }

    /**
     * Uses corners to check if other house is within bounds
     * @param other The house that this house collides with
     * @return true if collision
     */
    public boolean collidesWithHouse(House other) {
        int xDist = Math.abs(this.xPos - other.xPos);
        int yDist = Math.abs(this.yPos - other.yPos);
        if ((xDist < 90) && (yDist < 60)) {
            return true;
        }
        return false;
    }

    /**
     * Kills house, sets health to 0
     */
    public void die() {
        this.health = 0;

    }

    /**
     * Gets type of house
     * @return houseType Name of House
     */
    public String getHouseType() {
        return this.houseType;
    }

    /**
     * Checks if house is dead.
     */
    public boolean isDead() {
        if (this.health == 0) {
            return true;
        }
        return false;
    }

    /**
     * Should draw the House at its location.
     * @param g Image of House
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }

    /**
     * This method determines if houses can reproduce
     * @param other The other house
     */
    public abstract boolean canReproduceWithHouse(House other);

    /**
     * This method creates a new house based on reproduction limits
     * @Param other The other house
     */
    public abstract House reproduceWithHouse(House other);

    /**
     * This method returns true if house is
     * older than max age for house.
     */
    public abstract boolean isOld();

    /**
     * This method returns true if it can harm the house.
     * @param other House in collision
     */
    public abstract boolean canHarmHouse(House other);

    /**
     * This method harms the other house.
     * Harm is based on a percent
     */
    abstract void harmHouse(House other);

    /**
     * This method gets whether the house is
     * a North House, South House, or neither.
     */
    public abstract String getNorthSouth();
}
