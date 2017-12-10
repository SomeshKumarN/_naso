package naso.utils;

import naso.data.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class InputPropReader {

	public static Properties properties;

	static {
		try {
			properties = new Properties();
			FileInputStream propertiesFIS = new FileInputStream(Constants.INPUT_PROP_PATH);
			properties.load(propertiesFIS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getValueOf(String key) {
		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return null;
	}

	public static void setValueOf(String key, String value) {
		properties.setProperty(key, value);
	}
}
