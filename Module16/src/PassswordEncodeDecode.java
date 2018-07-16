import org.apache.commons.codec.binary.Base64;


public class PassswordEncodeDecode {

	public static void main(String[] args) {
		String origPwd="jackiechan";
		byte[] encodedPwd = Base64.encodeBase64(origPwd.getBytes());
		System.out.println("encoded string is: "+ new String(encodedPwd));
		
		byte[] decodedStr=Base64.decodeBase64(encodedPwd);
		System.out.println("decodedstring is : "+ new String(decodedStr));
	}

}
