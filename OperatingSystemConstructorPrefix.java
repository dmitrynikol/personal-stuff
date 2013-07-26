/**
 * Enum used to list different existing operating system.
 * 
 * @author Dmitry Nikolaenko
 * 
 */
public enum OperatingSystemConstructorPrefix {
	WINDOWS("win"), 
	MAC("mac"), 
	LINUX("linux");

	/**
	 * browser css prefix
	 */
	private String prefix;

	private OperatingSystemConstructorPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}
}
