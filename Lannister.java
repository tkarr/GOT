import java.awt.Rectangle;
import java.util.Random;

/**
 * This class represents a Lannister object.
 *
 * @author Trevor Karr
 * @version 1.0
 */

public class Lannister extends House {

    private static final int MAXAGE = 70;
    private Rectangle rect;
    private String northSouth;

    /**
     * Constructor
     *
     * @param x      The top left x position
     * @param y      The top left y position
     * @param bounds Boundaries for house
     */
    public Lannister(int x, int y, Rectangle bounds) {
        super(x, y, "Lion.png");
        northSouth = "South";
        rect = bounds;
    }

    /**
     * This method determines if the house can reproduce.
     *
     * @param other Other house
     */
    public boolean canReproduceWithHouse(House other) {
        if ((other instanceof Lannister || other instanceof Baratheon)) {
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
        if ((reproduceRate == 0) && (super.age > 30)) {
            House baby = new Lannister(super.xPos, super.yPos, rect);
            return baby;
        }
        return null;
    }

    /**
     * This method returns true when age is over max age.
     *
     */
    public boolean isOld() {
        if (super.age > MAXAGE) {
            return true;
        }
        return false;
    }

    /**
     * This method determines if house can harm another house.
     *
     * @param other The other house
     */
    public boolean canHarmHouse(House other) {
        Random rand = new Random();
        int harmChance = rand.nextInt(10);
        if (((other instanceof Stark) && (harmChance < 6))
            || ((other instanceof Tully) && (harmChance < 8))) {
            return true;
        }
        return false;
    }

    /**
     * This method harms the other house.
     *
     * @param other Other house
     */
    public void harmHouse(House other) {
        other.health = other.health - 25;
    }

    /**
     * This method returns the North/South
     */
    public String getNorthSouth() {
        return northSouth;
    }
}