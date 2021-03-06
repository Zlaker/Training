package ua.training.model.ammunition;

import ua.training.model.product.AbstractProduct;

/**
 * Implementation of <tt>AbstractProduct</tt> abstract class.
 * Describes weapon.
 */
public class Weapon extends AbstractProduct {

    /**
     * Weapon type.
     */
    private WeaponType type;

    /**
     * Constructor of weapon with price, weight, type params.
     * @param price int value of price of weapon
     * @param weight int value of weight of weapon
     * @param type WeaponType value of weapon type
     */
    public Weapon(int price, int weight, WeaponType type) {
        super(price, weight);
        this.type = type;
    }

    //getters & setters

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType damage) {
        this.type = damage;
    }

    /**
     * Enumeration of weapon type.
     */
    public enum WeaponType {
        SWORD(1), SPEAR(2), CROSSBOW(3), MACE(4);

        private int index;

        WeaponType(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}
