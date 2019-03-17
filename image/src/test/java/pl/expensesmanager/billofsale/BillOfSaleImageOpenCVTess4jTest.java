package pl.expensesmanager.billofsale;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.config.Tess4jConfiguration;
import pl.expensesmanager.image.OpenCVOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BillOfSaleImageOpenCVTess4jTest {
	
	private Tess4jConfiguration tess4j = new Tess4jConfiguration().setTrainDataLocation("tessdata");
	
	private OpenCVOperations opencv = new OpenCVOperations();
	
	private BillOfSaleImageOpenCVTess4j billOfSaleImageOpenCVTess4j = new BillOfSaleImageOpenCVTess4j(tess4j, opencv);
	
	@Test
	void readImageAsString_okay() throws IOException {
		// Given
		String expectedText = "TEST";
		File loadFile = new File(Paths.get("test.jpg")
		                              .toAbsolutePath()
		                              .toString());
		BillOfSaleImage billOfSaleImage = new BillOfSaleImage("image/jpeg", FileUtils.readFileToByteArray(loadFile));
		
		// When
		String readText = billOfSaleImageOpenCVTess4j.readImageAsString(billOfSaleImage);
		
		// Then
		assertThat(readText).isEqualTo(expectedText);
	}
	
}