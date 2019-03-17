package pl.expensesmanager.config;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.context.annotation.Configuration;

import java.awt.image.BufferedImage;
import java.nio.file.Paths;

/**
 * Configuration class for Tesseract Java.
 */
@Configuration
public class Tess4jConfiguration {
	
	private static final String PATH_TO_TRAINING_DATA = "image/tessdata";
	
	private static final String TRAINING_DATA_LANGUAGE = "eng";
	
	private static Tesseract tesseract = null;
	
	private static String trainingDataLocation = null;
	
	/**
	 * If the location will change this method sets a new one. Mostly for tests
	 *
	 * @param trainDataLocation location of trainign data
	 * @return Tess4jConfiguration
	 */
	public Tess4jConfiguration setTrainDataLocation(String trainDataLocation) {
		trainingDataLocation = trainDataLocation;
		return this;
	}
	
	/**
	 * Method to get text from buffered image.
	 *
	 * @param bufferedImage buffered image object
	 * @return read text from image
	 * @throws TesseractException throws if IO fail
	 */
	public String readFromBufferedImage(BufferedImage bufferedImage) throws TesseractException {
		return getInstance().doOCR(bufferedImage);
	}
	
	/**
	 * Get the instance of Tesseract object to execute operations on OCR.
	 *
	 * @return Tesseract object
	 */
	public static Tesseract getInstance() {
		if (tesseract == null) {
			synchronized (Tesseract.class) {
				tesseract = new Tesseract();
				
				tesseract.setDatapath(Paths.get(
					(trainingDataLocation == null) ? PATH_TO_TRAINING_DATA : trainingDataLocation)
				                           .toAbsolutePath()
				                           .toString());
				tesseract.setLanguage(TRAINING_DATA_LANGUAGE);
			}
		}
		return tesseract;
	}
	
}
