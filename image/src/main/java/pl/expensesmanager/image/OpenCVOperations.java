package pl.expensesmanager.image;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_UNCHANGED;
import static org.opencv.imgcodecs.Imgcodecs.imdecode;
import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.imageBlurIntensityException;
import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.imageResizeMultiplierException;
import static pl.expensesmanager.util.BasicValidator.validateDouble;
import static pl.expensesmanager.util.BasicValidator.validateInteger;

/**
 * Represents OpenCV operations used to read bill of sale pictures.
 */
@Component
public class OpenCVOperations {
	
	private static final int IMAGE_FORMAT_AFTER_CONVERSION_FROM_BYTES = CV_LOAD_IMAGE_UNCHANGED;
	
	private static final int ADAPTATIVE_THRESHOLD_ALGORYTHM = Imgproc.ADAPTIVE_THRESH_MEAN_C;
	
	private static final int ADAPTATIVE_THRESHOLD_TYPE = Imgproc.THRESH_BINARY;
	
	/**
	 * Method to convert image as byte array to Mat object.
	 *
	 * @param fileAsBytes image as bytes
	 * @return image as Mat object
	 */
	public Mat convertBytesToMat(byte[] fileAsBytes) {
		return imdecode(new MatOfByte(fileAsBytes), IMAGE_FORMAT_AFTER_CONVERSION_FROM_BYTES);
	}
	
	/**
	 * Method to rewrite rows, cols and type to the new Mat object
	 *
	 * @param originalMat Mat object from which data will be copied
	 * @return new Mat object based on original Mat data
	 */
	public Mat createMatCopyBasedOnAnotherParameters(Mat originalMat) {
		return new Mat(originalMat.rows(), originalMat.cols(), originalMat.type());
	}
	
	/**
	 * Resize original image to improve readability
	 *
	 * @param source      image which will be resized
	 * @param destination Mat object to which original image will be resized
	 * @param multiplier  multiply original size, if resizing is not needed the value should be = 1
	 */
	public void resizeOriginalImageTo(Mat source, Mat destination, Double multiplier) {
		if (validateDouble(multiplier) == 0) {
			throw imageResizeMultiplierException();
		}
		Imgproc.resize(source, destination,
		               new Size(destination.width() * multiplier, destination.height() * multiplier)
		);
	}
	
	/**
	 * Method to create Gaussian blur to image.
	 *
	 * @param source    image on which Gaussian blur will be applied
	 * @param intensity intensity of Gaussian blur
	 * @return mat object with image contain Gaussian blur
	 */
	public Mat makeGaussianBlur(Mat source, Integer intensity) {
		if (validateInteger(intensity) == 0) {
			throw imageBlurIntensityException();
		}
		Mat blur = createMatCopyBasedOnAnotherParameters(source);
		Imgproc.GaussianBlur(source, blur, new Size(0, 0), intensity);
		
		return blur;
	}
	
	/**
	 * Method to apply binary threshold to image.
	 *
	 * @param source              image on which threshold will be applied
	 * @param blockSize           size of a pixel neighborhood that is used to calculate a threshold value for the pixel: 3, 5, 7, and so on
	 * @param constantToSubstract constant subtracted from the mean or weighted mean, normally, it is positive but may be zero or negative as well.
	 * @return mat object with image contain binary threshold
	 */
	public Mat makeAdaptativeThreshold(Mat source, int blockSize, int constantToSubstract) {
		Mat treshold = createMatCopyBasedOnAnotherParameters(source);
		Imgproc.adaptiveThreshold(source, treshold, 256, ADAPTATIVE_THRESHOLD_ALGORYTHM, ADAPTATIVE_THRESHOLD_TYPE,
		                          blockSize, constantToSubstract
		);
		
		return treshold;
	}
	
	/**
	 * Method to sharpen image
	 *
	 * @param source image on which sharpness will be applied
	 * @return sharpen image
	 */
	public Mat makeSharpness(Mat source) {
		Mat sharpening = createMatCopyBasedOnAnotherParameters(source);
		Core.addWeighted(source, 1.5, sharpening, -0.5, 0, sharpening);
		
		return sharpening;
	}
	
	/**
	 * Convert mat image to buffered image object
	 *
	 * @param source image which will be transformed to BufferedImage
	 * @return mat image as buffered image
	 */
	public BufferedImage matToBufferedImage(Mat source) {
		return (BufferedImage) HighGui.toBufferedImage(source);
	}
	
}
