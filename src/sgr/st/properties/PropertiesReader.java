package sgr.st.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	Properties properties;

	public PropertiesReader(String filePath) {
		InputStream inputStream;
		properties = new Properties();
		try {
			inputStream = new FileInputStream(filePath);
			properties.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public String getProPerty(String key) {
		return properties.getProperty(key);
	}
}
