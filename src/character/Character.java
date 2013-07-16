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
	private String name;
	private Sex sex;
	/*
	 * Attributes
	 */
	private int hp;
	private int mp;
	private int attackRating;
	private int defenseRating;
	/*
	 * End Attributes
	 */
	ArrayList<Item> inventory;
	
	public Character(String name, String sex, int hp,int mp,int ar, int dr){
		this.setName(name);
		this.setSex(Sex.stringToEnum(sex));
		this.setHp(hp);
		this.setMp(mp);
		this.setAttackRating(ar);
		this.setDefenseRating(dr);
		this.inventory = new ArrayList<>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sex
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the mp
	 */
	public int getMp() {
		return mp;
	}

	/**
	 * @param mp the mp to set
	 */
	public void setMp(int mp) {
		this.mp = mp;
	}

	/**
	 * @return the attackRating
	 */
	public int getAttackRating() {
		return attackRating;
	}

	/**
	 * @param attackRating the attackRating to set
	 */
	public void setAttackRating(int attackRating) {
		this.attackRating = attackRating;
	}

	/**
	 * @return the defenseRating
	 */
	public int getDefenseRating() {
		return defenseRating;
	}

	/**
	 * @param defenseRating the defenseRating to set
	 */
	public void setDefenseRating(int defenseRating) {
		this.defenseRating = defenseRating;
	}
	
	public ArrayList<Item> getInventory(){
		return inventory;
	}
	
	public void addToInventory(Item item){
		inventory.add(item);
	}

}
