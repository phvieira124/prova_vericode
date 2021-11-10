package dataProviders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;

public class JsonDataReader {

	private String filePath = null;

	public JsonDataReader(String filePath) {
		this.filePath = filePath;
	}

	public JSONObject loaderJson() throws Exception {
		InputStream stream = new FileInputStream(filePath);
		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);
		StringBuilder sb = new StringBuilder();
		JSONObject json = null;
		String line;

		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();

		try {
			json = new JSONObject(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}
}
