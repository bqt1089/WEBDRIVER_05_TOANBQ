package topic_12_javafortester;

import org.junit.Assert;

public class topic_12_JavaForTester_Exercise {

	public static void main(String[] args) {
		String text = "Automation Testing Tutorial Online 123456";
		int y = 0;

		System.out.println("===========Dem so ky tu \"a\" trong chuoi ===============");
		String[] arrayChar = text.split("");

		for (int i = 0; i < arrayChar.length; i++) {
			if (arrayChar[i].toLowerCase().equals("a")) {
				y++;
			}
			if (i == arrayChar.length - 1) {
				System.out.println("So lan ky tu \"a\" xuat hien la = " + y);
			}
		}

		System.out.println("===========Kiem tra \"Testing\" co xuat hien trong chuoi hay khong ===============");
		String[] arrayText = text.split(" ");

		for (String elementInArrayText : arrayText) {
			boolean result = elementInArrayText.equals("Testing");
			if (result == true) {
				System.out.println("Chuoi co chua text \"Testing\" = " + result);
				break;
			}
		}

		System.out.println("===========Kiem tra chuoi co bat dau bang  \"Testing\" hay khong ===============");
		String firstIndexOfText = arrayText[0];
		System.out.println(firstIndexOfText);
		boolean indexText = firstIndexOfText.equals("Automation");

		if (indexText == true) {
			System.out.println("Chuoi bat dau bang Automation = " + indexText);
		} else {
			System.out.println("Wrong - Chuoi bi sai");
		}

		System.out.println("===========Kiem tra chuoi co ket thuc bang  \"Online\" hay khong ===============");
		// int lastIndex = arrayText.length-1;
		// String lastTextOfLastIndex = arrayText[lastIndex];
		// System.out.println(lastTextOfLastIndex);
		// boolean compareText = lastTextOfLastIndex.equals("Online");

		// if (compareText == true) {
		// System.out.println("Text of last index = " + lastTextOfLastIndex+ " Last text
		// is " + compareText);
		// } else {
		// System.out.println("Text of last index = " + lastTextOfLastIndex+ " Last text
		// is " + compareText);
		// }

		boolean compareNew = text.endsWith("Online");
		System.out.println("Chuoi ket thuc bang Online = " + compareNew);

		System.out.println("=========== Kiem tra vi tri cua Tutorial trong chuoi ===============");
		int indexTut = text.indexOf("Tutorial");
		System.out.println("Vi tri cua Tutirial trong chuoi = " + indexTut);

		System.out.println("=========== Thay the Online bang Offline ===============");
		String replaceText = text.replace("Online", "Offline");
		System.out.println("New text = " + replaceText);

		System.out.println("=========== Dem bao nhieu so xuat hien trong chuoi ===============");
		int countNum = 0;
		for (int i = 0; i < arrayChar.length; i++) {
			boolean verifyNum = Character.isDigit(text.charAt(i));
			if (verifyNum == true) {
				countNum++;
			}
		}
		System.out.println("So ky tu la so trong chuoi = " + countNum);

	}
}
