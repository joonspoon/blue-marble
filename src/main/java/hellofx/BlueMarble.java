package hellofx;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class BlueMarble {
	
	private String API_KEY = "7u1nv3v73ROS0u2F65J7w14pnGpjzwCv6cruBzes";
	private String dateAsString;
	private String quality = "natural";
	private String caption;
	private String nasaImageName;

	public static InputStream getMostRecentImage() {
		BlueMarble blueMarble = new BlueMarble();
		blueMarble.setDate(LocalDate.now().minusDays(1).toString());
		return blueMarble.getImage();
	}
	
	public void setDate(String date) {
		this.dateAsString = date;
	}
	
	public InputStream getImage() {
		try {
			getMetaData();

			URL url = new URL("https://api.nasa.gov/EPIC/archive/" + quality + "/" + dateAsString.replace('-', '/')
					+ "/png/" + this.nasaImageName + ".png?api_key=" + API_KEY);
			return url.openStream();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void getMetaData() throws IOException, MalformedURLException {
		String metaQueryURL = "https://epic.gsfc.nasa.gov/api/" + quality + "/date/" + dateAsString;
		InputStream metaInfoStream = new URL(metaQueryURL).openStream();
		String metaInfoJSON = IOUtils.toString(metaInfoStream, "UTF-8").replace("[", "");
		System.out.println(metaInfoJSON);
		metaInfoStream.close();
		JSONObject json = new JSONObject(metaInfoJSON);
		this.nasaImageName = (String) json.get("image");
		this.caption = (String) json.get("caption");
	}

	public String getCaption() {
		return this.caption;
	}

	public void setEnhanced(boolean b) {
		this.quality = "enhanced";
	}
}
