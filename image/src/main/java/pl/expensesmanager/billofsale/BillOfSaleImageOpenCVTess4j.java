package pl.expensesmanager.billofsale;

import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.config.Tess4jConfiguration;
import pl.expensesmanager.image.OpenCVOperations;

import java.awt.image.BufferedImage;

import static pl.expensesmanager.exception.InternalExceptionFactory.ioExceptionException;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class BillOfSaleImageOpenCVTess4j implements BillOfSaleImagePort {
	
	private final Tess4jConfiguration tess4j;
	
	private final OpenCVOperations opencv;
	
	@Override
	public String readImageAsString(BillOfSaleImage billOfSaleImage) {
		loadNativeLibrary();
		
		Mat sourceImageFromBytes = opencv.convertBytesToMat(billOfSaleImage.getImageAsBytes());
		Mat resizedImage = opencv.createMatCopyBasedOnAnotherParameters(sourceImageFromBytes);
		opencv.resizeOriginalImageTo(sourceImageFromBytes, resizedImage, 8d);
		
		Mat gaussianBlur = opencv.makeGaussianBlur(resizedImage, 1);
		Imgproc.cvtColor(gaussianBlur, gaussianBlur, Imgproc.COLOR_RGB2GRAY);
		
		Mat threshold = opencv.makeAdaptativeThreshold(gaussianBlur, 89, 6);
		Mat sharpImage = opencv.makeSharpness(threshold);
		BufferedImage imageMatAsBufferedImage = opencv.matToBufferedImage(sharpImage);
		
		try {
			return tess4j.readFromBufferedImage(imageMatAsBufferedImage)
			             .trim();
		} catch (TesseractException e) {
			throw ioExceptionException(
				e,
				"Cannot read from Mat to BufferedImage. Probably something went wrong of execute operations to read text from image."
			);
		}
	}
	
	/**
	 * Method to load native OpenCV library. There is needed to set Path variable of path to the OpenCV in system
	 */
	private void loadNativeLibrary() {
		nu.pattern.OpenCV.loadShared();
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
}
