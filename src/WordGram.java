/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author Yunyao Zhu
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram object by initializing myWords, myToString, myHash 
	 * @param source the array of words from which myWords array receives String entries
	 * @param start the starting index where the myWords array starts to receive words from the source array
	 * @param size the length of the myWords array
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		// TODO: initialize myWords and ...
		for(int i = 0; i < myWords.length; i ++)
		{
			myWords[i] = source[start + i];
		}
		
		myToString = null;
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * This method returns the length of the myWords array
	 * @return the length of the myWord array
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}

	    // TODO: complete this method
		WordGram wg = (WordGram) o;
		
		if(this.toString().equals(o.toString()) && this.hashCode() == o.hashCode())
		{
			return true;
		}
		return false;
		
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		myHash = toString().hashCode();
		return myHash;
	}
	

	/**
	 * The method create a new object by shifting the words in myWords array in the old 
	 * object down by one and append the last string to the end of the array
	 * @param last the String to be added to the end of the myWords array of the new object
	 * @return the new object with last as the last string in the myWords array
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		
		for(int i = 0; i < this.myWords.length-1; i++)
		{
			wg.myWords[i] = this.myWords[i+1];
		}
		
		wg.myWords[this.myWords.length-1] = last;
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method	
		myToString = String.join(" ", myWords);
		return myToString;
	}
}