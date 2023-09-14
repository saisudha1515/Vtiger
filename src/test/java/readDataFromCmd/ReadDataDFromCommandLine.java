package readDataFromCmd;

import org.testng.annotations.Test;

public class ReadDataDFromCommandLine {
	@Test
	public void readData() {
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		System.out.println(BROWSER);
		System.out.println(URL);
	}
}
