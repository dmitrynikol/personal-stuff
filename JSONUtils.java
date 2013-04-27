import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

/**
 * GWT. Provides methods for easy extraction of values ​​from JSON object.
 * 
 * @author Dmitry Nikolaenko
 * 
 */
public final class JSONUtils {
	public static String getStringValue(JSONObject object, String keyName) {
		if (object.containsKey(keyName)) {
			if (object.get(keyName).isString() != null) {
				return object.get(keyName).isString().stringValue();
			}
		}
		return "";
	}

	public static Long getLongValue(JSONObject object, String keyName) {
		if (object.containsKey(keyName)) {
			JSONValue jsonValue = object.get(keyName);

			if (jsonValue == null) {
				return 0L;
			}

			if (jsonValue.isString() != null) {
				return Long.parseLong(jsonValue.isString().stringValue());
			} else if (jsonValue.isNumber() != null) {
				return (long) jsonValue.isNumber().doubleValue();
			} else {
				return 0L;
			}
		} else {
			return 0L;
		}
	}

	public static int getIntValue(JSONObject object, String keyName) {
		if (object.containsKey(keyName)) {
			final JSONValue value = object.get(keyName);
			
			if (value != null && value.isNumber() != null) {
				return (int) value.isNumber().doubleValue();
			}
		}
		return -1;
	}

	public static Double getDoubleValue(JSONObject object, String keyName) {
		if (object.containsKey(keyName)) {
			JSONValue jsonValue = object.get(keyName);

			if (jsonValue == null) {
				return 0.0;
			}

			if (jsonValue.isString() != null) {
				return Double.parseDouble(jsonValue.isString().stringValue());
			} else if (jsonValue.isNumber() != null) {
				return jsonValue.isNumber().doubleValue();
			} else {
				return 0.0;
			}
		} else {
			return 0.0;
		}
	}

	public static List<String> getStringList(JSONObject object, String listName) {
		List<String> list = new LinkedList<String>();
		if (object.containsKey(listName)) {
			JSONArray array = object.get(listName).isArray();
			if (array == null) {
				return list;
			}
			for (int i = 0; i < array.size(); i++) {
				if (array.get(i).isString() == null) {
					continue;
				}
				list.add(array.get(i).isString().stringValue());
			}
		}
		return list;
	}

	public static boolean getBooleanValue(JSONObject object, String keyName) {
		if (object != null) {
			if (object.containsKey(keyName) && object.get(keyName).isNull() != JSONNull.getInstance()) {
				return object.get(keyName).isBoolean().booleanValue();
			} else {
				return false;
			}
		}
		return false;
	}

	public static JSONArray stringsToJsonArray(List<String> list) {
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			array.set(i, new JSONString(list.get(i).toString()));
		}
		return array;
	}

	public static JSONArray stringsToJsonArray(Set<String> set) {
		JSONArray array = new JSONArray();
		int i = 0;
		for (String value : set) {
			array.set(i, new JSONString(value));
			i++;
		}
		return array;
	}

	public static JSONArray stringsToJsonArray(String[] list) {
		JSONArray arr = new JSONArray();
		for (int i = 0; i < list.length; i++) {
			arr.set(i, new JSONString(list[i].toString()));
		}
		return arr;
	}

	public static int intFromDouble(double value) {
		return Double.valueOf(value).intValue();
	}

	public static int intFromNumber(JSONNumber value) {
		if (value == null) {
			throw new IllegalArgumentException("value is null");
		}
		return Double.valueOf(value.doubleValue()).intValue();
	}

	public static String[] stringsArrayFromJSON(JSONArray array) {
		if (array == null || array.isNull() == JSONNull.getInstance()) {
			throw new IllegalArgumentException("array value is null");
		}
		String[] strings = new String[array.size()];
		for (int i = 0; i < array.size(); i++) {
			strings[i] = array.get(i).isString().stringValue();
		}
		return strings;
	}
}