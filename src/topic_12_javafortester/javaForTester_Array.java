package topic_12_javafortester;

public class javaForTester_Array {

	public static void main(String[] args) {
		/* ===INIT Aray === */
		int y = 0;
		int i = 0;
		String[] testingPart = new String[4];
		testingPart[0] = "Manual";
		testingPart[1] = "Automation";
		testingPart[2] = "Performance";
		testingPart[3] = "Sercurity";

		String[] testing = { "Auto1", "manual1", "performance", "sercurity" };

		System.out.println("===============================================");

		int number1 = testingPart.length;
		int number2 = testing.length;

		do {
			System.out.println("Type Test for " + y + ": " + testingPart[y]);
			y++;
		} while (y < number1);

		System.out.println("===============================================");
		while (i < number2) {
			System.out.println("Type Test for " + i + ": " + testing[i]);
			i++;
		}
		System.out.println("===============================================");

		String[] length = { "Xoai", "Du Du", "Dua", "Thom" };

		/* =====For Each====== */
		for (String testLength : length) {
			System.out.println("Nuoc Trai Cay : " + testLength);
		}

		System.out.println("==============For Each=================================");

		/* ====Parse Array to Method===== */
		parse_Array_To_Method(testing);
		System.out.println("=================Parse Array==============================");

		parse_Array_To_Method(testingPart);

		System.out.println("===================Return Array============================");
		String[] newArray = return_Array_To_Method();
		for (String array : newArray) {
			System.out.println(" Cac gia tri trong mang : " + array);
		}

	}

	public static void parse_Array_To_Method(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Gia tri " + (i + 1) + " trong mang : " + array[i]);
		}
	}

	public static String[] return_Array_To_Method() {
		String[] arrayMethod = { "Developer", "Tester", "Business Analysist" };
		return arrayMethod;
	}
}
