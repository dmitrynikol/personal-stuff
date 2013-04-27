/**
 * Enum used to list different existing browsers and their CSS prefixes.
 * 
 * @author Dmitry Nikolaenko
 *
 */
public enum BrowserConstructorPrefix {
	WEBKIT("webkit"),
	MOZILLA("moz"),
	OPERA("opera"),
	MICROSOFT("ms");
	
	/**
	 * browser prefix
	 */
	private String prefix;
	
	private BrowserConstructorPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix() {
		return prefix;
	}
}
