/**
 *
 */
package sgr.st.properties;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author satousuguru
 *
 */
class PropertiesReaderTest {

	PropertiesReader propertiesReader;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		propertiesReader  = new PropertiesReader(System.getProperty("user.dir") + "/test/sample.properties");
	}

	/**
	 * {@link sgr.st.properties.PropertiesReader#getProPerty(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	void testGetProPerty() {
		assertEquals(propertiesReader.getProPerty("test_key"), "test_value");
	}

}
