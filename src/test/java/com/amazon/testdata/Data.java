package com.amazon.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Data {
	static Properties prop;

	public Data() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ExternalData\\data.properties");
		prop = new Properties();
		prop.load(fis);
	}

	public String item() {
		return prop.getProperty("data");
	}

	public String delivery() {
		return prop.getProperty("delivery");
	}

	public String avail() {
		return prop.getProperty("avail");
	}
	
	public String browser() {
		return prop.getProperty("browser");
	}
	
	public String amazonUrl() {
		return prop.getProperty("url");
	}
	
	public String product() {
		return prop.getProperty("product");
	}
}
