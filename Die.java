package mydicegame;

import java.util.Random;

/**
 * This class represents a Die.
 * @author  Trong Nguyen
 * @version 1.0
 */
public class Die {
    private int numberOfSides;

    /**
     * A constructor that takes a numberOfSides argument for Die.
     * @param numberOfSides int : the number of sides of the die
     */
    public Die(int numberOfSides) {
        if (numberOfSides > 1) {
            this.numberOfSides = numberOfSides;
        }
    }

    /**
     * A default constructor for Die.
     */
    public Die() {
        this(6);
    }

    /**
     * Rolls the die and returns a random number.
     * @return  int : the die number rolled
     */
    public int roll() {
        Random random = new Random();
        return random.nextInt(this.numberOfSides) + 1;
    }

    /**
     * Get the number of sides of the Die.
     * @return  int : the number of sides of the die
     */
    public int getSides() {
        return this.numberOfSides;
    }
}
