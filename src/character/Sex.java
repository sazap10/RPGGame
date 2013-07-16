/**
 * 
 */
package character;

/**
 * @author Sachin
 *
 */
public enum Sex {
	MALE,FEMALE;
	
	public static Sex stringToEnum(String str){
		Sex sex = null;
		if(str.toLowerCase().equals("male"))
			sex = MALE;
		else if(str.toLowerCase().equals("female"))
			sex = FEMALE;
		return sex;
	}
}
