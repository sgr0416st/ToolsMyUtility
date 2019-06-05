package sgr.st.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	Properties properties;

	public PropertiesReader(String filePath) throws IOException {
		InputStream inputStream;
		properties = new Properties();
		inputStream = new FileInputStream(filePath);
		properties.load(inputStream);
		inputStream.close();
	}

	public String getProPerty(String key) {
		return properties.getProperty(key);
	}
}
