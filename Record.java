
/**
 * Record Object holds the data of each HuffmanNode Object
 *
 * <p>
 * Date: April 16, 2018
 * </p>
 *
 * @author Evan Pomponio
 * 
 **/

public class Record {

	int frequency;
	char symbol;
	String str;

	/**
	 * Constructor for Record takes the Frequency, Symbol, and Binary representation
	 * of each HuffmanNode.
	 * 
	 * @param c
	 * @param f
	 * @param s
	 */
	public Record(char c, int f, String s) {
		this.frequency = f;
		this.symbol = c;
		this.str = s;
	}

	/**
	 * Accessor for symbol
	 * 
	 * @return char symbol
	 **/
	public char getSymbol() {
		return symbol;
	}

	/**
	 * Accessor for frequency
	 * 
	 * @return int data
	 **/
	public int getFreq() {
		return frequency;
	}

	/**
	 * Accessor for HuffmanCode
	 * 
	 * @return int str
	 **/
	public String getHuffman() {
		return str;
	}

	/**
	 * Returns a string of instance Variables for Record
	 * 
	 * @return String Format
	 */
	public String toString() {
		String STR = "Symbol: " + this.getSymbol() + "\nFrequency: " + this.getFreq() + "\nCode: " + this.getHuffman();
		return STR;
	}
}
