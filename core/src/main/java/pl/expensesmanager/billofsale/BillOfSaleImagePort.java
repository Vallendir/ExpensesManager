package pl.expensesmanager.billofsale;

/**
 * Port to read text from image.
 */
public interface BillOfSaleImagePort {
	
	/**
	 * Method to read text from image passed as byte array.
	 *
	 * @param billOfSaleImage bill of sale image object
	 * @return text from image
	 */
	String readImageAsString(BillOfSaleImage billOfSaleImage);
	
}
