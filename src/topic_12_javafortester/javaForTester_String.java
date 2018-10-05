package topic_12_javafortester;

public class javaForTester_String {
	public static void main(String[] args) {
		String automation = "Automation Testing";
		String chuoi = "Automation Tutorial";
		String text;

		/* ==========LENGTH=========== */
		System.out.println("============= length Chieu dai chuoi===============");

		int length = automation.length();
		System.out.println("So ki tu = " + length);

		/* ==========CHARTAT=========== */
		System.out.println("============= charAt  Vi tri ki tu===============");

		char kitu = chuoi.charAt(0);
		System.out.println("Ki tu 0 = " + kitu);

		/* ==========CONCATE=========== */
		System.out.println("=============== concate Noi chuoi=============");
		String chuoiNoi = chuoi.concat(" Test noi them");
		System.out.println("Chuoi noi la : " + chuoiNoi);

		/* ==========COMPARE=========== */
		System.out.println("=============== Compare String =============");
		boolean compareValue = automation.equals(chuoi);
		System.out.println("So sanh 2 chuoi String = " + compareValue);

		compareValue = automation.equals(automation);
		System.out.println("So sanh 2 chuoi String = " + compareValue);

		/* ==========INDEX=========== */
		System.out.println("=============== indexOf Vi tri cua tu trong chuoi =============");
		int index = automation.indexOf("Testing");
		System.out.println("Vi tri cua tu \"Testing\" trong chuoi = " + index);

		/* ==========SUBSTRING=========== */
		System.out.println("=============== subString Chuoi con tu vi tri =============");
		String subStringStart = automation.substring(index);
		System.out.println("Chuoi con tu vi tri index = " + subStringStart);

		String subStringEnd = automation.substring(11, 18);
		System.out.println("Chuoi con bat dau tai 11 va ket thuc tai 18  = " + subStringEnd);

		/* ==========REPLACE=========== */
		System.out.println("=============== replace Thay the 1 tu/chuoi bang 1 tu/chuoi khac =============");
		String money = "$100";
		money = money.replace("$", "");

		System.out.println("So sau khi da thay the = " + money);

		double newMoney = Double.parseDouble(money);
		System.out.println("So sau khi da doi qua kieu INT by Double = " + newMoney);

		/* ==========SPLIT=========== */
		System.out.println("=============== split Tach chuoi=============");
		text = "Viewing 72 of 1827 results";

		String[] subString = text.split(" ");
		for (int i = 0; i < subString.length; i++) {
			System.out.println("Vi tri thu " + i + ": " + subString[i]);
		}

		System.out.println("Cat chuoi va chuoi qua kieu int vi tri 1 = " + extractNumberFromString(text, 1));
		System.out.println("Cat chuoi va chuoi qua kieu int vi tri 3 = " + extractNumberFromString(text, 3));

		/* ==========UPPER - LOWER=========== */
		System.out.println("=============== upper and lower case IN hoa IN thuong  =============");
		String upper = automation.toUpperCase();
		String lower = automation.toLowerCase();

		System.out.println("Upper case : " + upper);
		System.out.println("Lower case : " + lower);

		/* ========== TRIM =========== */
		System.out.println("=============== Trim khoang trang 2 dau =============");
		String textKhoangTrang = " \t  \n  Automation Testing  \n";

		System.out.println(textKhoangTrang);

		String trim = textKhoangTrang.trim();
		System.out.println("Ket qua sau khi trim = " + trim);

		/* ========== Convert String / Int to Int / String =========== */
		System.out.println("=============== Convert String / Int to Int / String =============");
		String string = "1000";
		int intT = 5000;

		int convertFromString = Integer.parseInt(string);
		String convertFromInt = String.valueOf(intT);

		System.out.println("Value String after convert to Int = " + convertFromString);
		System.out.println("Value Number after convert to String = " + convertFromInt);

	}

	public static int extractNumberFromString(String text, int number) {
		String[] splitString = text.split(" ");
		int result = Integer.parseInt(splitString[number]);
		return result;
	}
}
