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
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
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
	 * Complete this comment
	 * @return
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
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
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