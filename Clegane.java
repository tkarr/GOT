import java.awt.Rectangle;

/**
 * This class represents a Clegane object.
 * Fuck the king.
 *
 * @author Trevor Karr
 * @version 1.0
 */

public class Clegane extends House {

    private Rectangle rect;
    private String northSouth;

    /**
     * Constructor
     *
     * @param x      The top left x position
     * @param y      The top left y position
     * @param bounds Boundaries for house
     */
    public Clegane(int x, int y, Rectangle bounds) {
        super(x, y, "Dogs.png");
        rect = bounds;
        northSouth = "None";
    }

    /**
     * This method determines if Clegane can reproduce.
     * Thankfully no.
     *
     * @param other Other house
     */
    public boolean canReproduceWithHouse(House other) {
        return false;
    }

    /**
     * Since Clegane cannot reproduce, this returns null.
     *
     * @param other Other house
     */
    public House reproduceWithHouse(House other) {
        return null;
    }

    /**
     * Clegane never dies from old age.
     */
    public boolean isOld() {
        return false;
    }

    /**
     * This method determines if Clegane can harm another house.
     *
     * @param other The other house
     */
    public boolean canHarmHouse(House other) {
        if ((other instanceof Lannister) || (other instanceof Baratheon)) {
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
        other.health = other.health - 50;
    }

    /**
     * This method returns the North/South
     */
    public String getNorthSouth() {
        return northSouth;
    }
}