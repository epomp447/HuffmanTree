
public class Record {
	
		 int frequency;
		 char symbol;
		 String str;
		public Record(char c,int f,String s) {
			this.frequency = f;
			this.symbol = c; 
			this.str = s;
		}

		public char getSymbol() {
			return symbol;
		}
		public int getFreq() {
			return frequency;
		}

		public String getHuffman() {
			return str;
		}
		
		public String toString() {
			String STR="Symbol: "+this.getSymbol()+"\nFrequency: "+this.getFreq()+"\nCode: "+this.getHuffman();
			return STR;
		}
}
