/**
 * 
 */
package character;

import items.Item;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

/**
 * @author Sachin 
 * @description 
 *  Character class acts as the base for all characters in the
 *  game.
 *  Contains attributes present in all characters
 *  List of objects ie Inventory 
 */
public class Character extends ImageView {
	String name;
	String sex;
	/*
	 * Attributes
	 */
	int HP;
	int MP;
	int AttackRating;
	int DefenseRating;
	/*
	 * End Attributes
	 */
	ArrayList<Item> inventory;

}
