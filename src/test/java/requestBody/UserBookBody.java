package requestBody;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;

import pojoPayload.AuthAPIPayload;
import pojoPayload.UserBooksPayload;
import utilities.BaseUtils;

public class UserBookBody extends BaseUtils{

	public static UserBooksPayload inValid_BookId() throws IOException
	{
		int invalidBookId=Integer.parseInt(excelutils.getCellData("Sheet1", 0, 1));
		//System.out.println("The data in excel"+invalidBookId);
		userbookspayload.setId(invalidBookId);
		
		return userbookspayload;
	}
	
	public static AuthAPIPayload authencationBody() throws IOException
	{
		authapipayload.setClientName(excelutils.getCellData("Auth", 0, 1));
		authapipayload.setClientEmail(RandomStringUtils.randomAlphabetic(2)+excelutils.getCellData("Auth", 1, 1));
		//System.out.println(RandomStringUtils.randomAlphabetic(2)+excelutils.getCellData("Auth", 1, 1));
		return authapipayload;
	}
	
	public static UserBooksPayload SubmitOrderBody() throws NumberFormatException, IOException {
		int invalidBookId=Integer.parseInt(excelutils.getCellData("Sheet1", 1, 1));
		userbookspayload.setBookId(invalidBookId);
		userbookspayload.setCustomerName(excelutils.getCellData("Sheet1", 2, 1));
		return userbookspayload;
	}
	public static String UpdateOrderBody() {
		String customername =userbookspayload.getCustomerName()+RandomStringUtils.randomAlphabetic(4);
		
		return customername;
	}
}
