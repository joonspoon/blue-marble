package hellofx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.curiousworks.BlueMarble;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlueMarbleController {

	@FXML
	private ImageView image;

	@FXML
	private DatePicker datePicker;

	@FXML
	void updateDate(ActionEvent event) {
		
		BlueMarble blueMarble = new BlueMarble();
//		blueMarble.setDate(datePicker.getValue().getYear() + "-0" + datePicker.getValue().getMonthValue() + "-" + datePicker.getValue().getDayOfMonth());
		blueMarble.setDate("2018-0" + datePicker.getValue().getMonthValue() + "-" + datePicker.getValue().getDayOfMonth());
		blueMarble.setEnhanced(true);
//		Image value = new Image(BlueMarble.getMostRecentImage());
		image.setImage(new Image(blueMarble.getImage()));
	}


}
