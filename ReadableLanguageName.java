import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * GWT. Enumeration with readable language form.
 * 
 * @author Dmitry Nikolaenko
 *
 */
public enum ReadableLanguageName {
	
	EN("en") { 
		@Override public String getReadableName() { return commonStrings.england(); }
	}, 
	RU("ru") { 
		@Override public String getReadableName() { return commonStrings.russian(); }
	}, 
	UK("uk") { 
		@Override public String getReadableName() { return commonStrings.ukraine(); }
	}, 
	ES("es") { 
		@Override public String getReadableName() { return commonStrings.spain(); }
	}, 
	IT("it") { 
		@Override public String getReadableName() { return commonStrings.italy(); }
	}, 
	FR("fr") { 
		@Override public String getReadableName() { return commonStrings.france(); }
	}, 
	DE("de") { 
		@Override public String getReadableName() { return commonStrings.germany(); }
	}, 
	ZH("zh") { 
		@Override public String getReadableName() { return commonStrings.china(); }
	};
	
	private String languageId;
	
	private final static CommonStrings commonStrings = GWT.create(CommonStrings.class);
	
	private ReadableLanguageName(String languageId) {
		this.languageId = languageId;
	}
	
	public String getLanguageId() {
		return languageId;
	}
	
	/**
	 * Provides a readable language object.
	 * 
	 * @param language that you want to get
	 * @return enumeration item with readable language form
	 */
	public static ReadableLanguageName safeValueOf(final String language) {
		try {
			return ReadableLanguageName.valueOf(language.toUpperCase());
		} catch (final IllegalArgumentException ex) {
			return EN;
		}
	}

	public abstract String getReadableName();
}