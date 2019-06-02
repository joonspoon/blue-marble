

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class BlueMarble {
	File getImageOnDate(int year, int month, int day, boolean enhanced) {
		String dateAsString = year + "-" + month + "-" + day;
		String quality = enhanced ? "enhanced" : "natural";
		String metaQueryURL = "https://epic.gsfc.nasa.gov/api/" + quality + "/date/" + dateAsString;
		System.out.println(metaQueryURL);
		InputStream metaInfoStream = null;
		try {
			metaInfoStream = new URL(metaQueryURL).openStream();
			String metaInfoJSON = IOUtils.toString(metaInfoStream, "UTF-8").replace("[", "");
			metaInfoStream.close();
			System.out.println(metaInfoJSON);
			JSONObject json = new JSONObject(metaInfoJSON);
			String imageName = (String) json.get("image");
			String caption = (String) json.get("caption");
			
			
			URL url = new URL("https://api.nasa.gov/EPIC/archive/" + quality + "/" + dateAsString.replace('-', '/')
			+ "/png/" + imageName + ".png?api_key=DEMO_KEY");
			File file = new File(url.getFile());
			return file;
//			FileUtils.copyURLToFile(
//					new URL("https://api.nasa.gov/EPIC/archive/" + quality + "/" + dateAsString.replace('-', '/')
//							+ "/png/" + imageName + ".png?api_key=DEMO_KEY"),
//					new File("images/" + dateAsString + quality + ".png"), 1000, 1000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
