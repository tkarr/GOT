import java.awt.Rectangle;
import java.util.Random;

/**
 * This class represents a Targaryan object.
 *
 * @author Trevor Karr
 * @version 1.0
 */

public class Targaryan extends House {

    private Rectangle rect;
    private String northSouth;

    /**
     * Constructor
     *
     * @param x      The top left x position
     * @param y      The top left y position
     * @param bounds Boundaries for house
     */
    public Targaryan(int x, int y, Rectangle bounds) {
        super(x, y, "Dragon.png");
        northSouth = "None";
        rect = bounds;
    }

    /**
     * This method determines if the house can reproduce.
     *
     * @param other Other house
     */
    public boolean canReproduceWithHouse(House other) {
        if (other instanceof Targaryan) {
            return true;
        }
        return false;
    }

    /**
     * This method creates a new house of same type
     * in same place (with a percent chance)
     *
     * @param other The other house
     */
    public House reproduceWithHouse(House other) {
        Random randy = new Random();
        int reproduceRate = randy.nextInt(10);
        if ((reproduceRate == 0) && ((super.age > 30) && (super.age < 50))) {
            House baby = new Targaryan(super.xPos, super.yPos, rect);
            return baby;
        }
        return null;
    }

    /**
     * This method returns false because Targaryan doesn't age.
     *
     */
    public boolean isOld() {
        return false;
    }

    /**
     * This method determines if house can harm another house.
     *
     * @param other The other house
     */
    public boolean canHarmHouse(House other) {
        if (((other instanceof Stark) || (other instanceof Tully))
            || (other instanceof Lannister)) {
            return true;
        }
        return false;
    }

    /**
     * This method harms the other house.
     */
    public void harmHouse(House other) {
        other.health = other.health - 10;
    }

    /**
     * This method harms the other house.
     *
     * @param other Other house
     */
    public String getNorthSouth() {
        return northSouth;
    }
}