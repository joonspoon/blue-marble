package hellofx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.print.attribute.standard.PrinterLocation;

import javafx.css.converter.StringConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EarthController {

	BlueMarble blueMarble = new BlueMarble();

	@FXML
	private ImageView EarthImage;

	@FXML
	private DatePicker datePicker;

	@FXML
	private RadioButton enhancedImage;

	@FXML
	private Button getImageButton;

	@FXML
	 void handleButtonAction(ActionEvent event) {
		LocalDate date = datePicker.getValue();
		String dateString = null;
		 if (date != null) {
		        dateString = date.toString();
		        blueMarble.setDate(dateString);
		    } else {
		        blueMarble.setDate(LocalDate.now().minusDays(1).toString());
		    }		
		if (enhancedImage.isSelected()) {
			LocalDate dateForEnhanced = date;
			LocalDate dateImagesAvail = LocalDate.of(2020, 6, 1);
			int diff = dateForEnhanced.compareTo(dateImagesAvail);
			System.out.println(dateForEnhanced);
			if (diff <= 0) {
				blueMarble.setEnhanced(enhancedImage.isSelected());
			} else {
				System.out.println(
						"Enhanced images are not available for the date selected.  Unenhanced image will be shown.");
			}

			blueMarble.setEnhanced(enhancedImage.isSelected());
		}
		Image image = new Image(blueMarble.getImage());
		
		EarthImage.setImage(image);
		
	}
	 
	
//	 public void initialize(URL location, ResourceBundle resources) {
//	        // TODO Auto-generated method stub
//	        getImageButton.setOnAction(this::handleButtonAction);
//	    }
	 

}
