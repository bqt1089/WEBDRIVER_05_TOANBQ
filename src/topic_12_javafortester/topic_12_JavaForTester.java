package topic_12_javafortester;

public class topic_12_JavaForTester {
	public static void main(String args[]) {

		/* ====Boolean===== */
		System.out.println("====Boolean====");
		boolean testResult;
		testResult = true;
		System.out.println("ket qua dung : " + testResult);
		testResult = false;
		System.out.println("ket qua sai : " + testResult);
		System.out.println("=============================");
		
		/* ====Int===== */
		System.out.println("====Int====");
		int cart;
		cart = 2 ;
		System.out.println("So luong gio hang : " + cart);
		cart = cart + 10;
		System.out.println("So luong gio hang sau khi chon: " + cart);
		System.out.println("=============================");
		
		/* ====Double===== */
		System.out.println("====Double====");
		double ketqua;
		ketqua = 8.60 ;
		System.out.println("Ket qua : " + ketqua);
		System.out.println("=============================");
		
		/* ====String===== */
		System.out.println("====String====");
		String name, address, city;
		name = "Toan" ;
		address = "Street";
		city = "Da Nang";
		System.out.println("Name  : " + name);
		System.out.println("Address : " + address);
		System.out.println("City: " + city);
		System.out.println("=============================");
		
		/* ====Operator===== */
		System.out.println("====Operator====");
		int so = 10;
		String ten = "Toan";
		boolean value = false;
		System.out.println("So  : " + so);
		System.out.println("Ten : " + ten);
		System.out.println("Value: " + value);
		System.out.println("=============================");
		
		/* =======Math======== */
		System.out.println("====Math====");
		int a, b= 14 , c= 5;
		a= b + c ;
		System.out.println("Phep cong a = " + a);
		
		a= b - c ;
		System.out.println("Phep tru a = " + a);
		
		a= b * c ;
		System.out.println("Phep nhan a = " + a);
		
		a= b / c ;
		System.out.println("Phep chia lay nguyen a = " + a);
		
		a= b % c ;
		System.out.println("Phep chia lay du a = " + a);
		
		a= b++;
		System.out.println("Tang len 1 : a = " + a);
		
		a= b-- ;
		System.out.println("Giam xuong 1 : a = " + a);
		
		System.out.println("=============================");
		
		/* =======Relation======== */
		System.out.println("====Relation====");
		int tenN = 10, twenty = 20, thirty = 30;
		
		System.out.println("10 Lon hon 20: " + (tenN > twenty));
		System.out.println("30 Lon hon hoac bang 20: " + (thirty >= twenty));
		System.out.println("30 nho hon 20: " + (thirty < twenty));
		System.out.println("30 nho hon hoac bang 20: " + (thirty <= twenty));
		System.out.println("30 bang bang 20 + 10 : " + (thirty == twenty+ tenN));
		System.out.println("30 Khac bang 20+10 " + (thirty != twenty+ tenN));
		System.out.println("=============================");

		/* =======Logic======== */
		System.out.println("====Logic====");
		boolean value1 = true;
		boolean value2 = false;
		System.out.println("Ca 2 deu dung = " + (value1 && value2));
		System.out.println("Mot trong 2 dung = " + (value1 || value2));
		System.out.println("Phu dinh cua True = " + (!value1));
		System.out.println("=============================");

		/* =======Condition======== */
		System.out.println("====Condition====");
		int first = 10;
		int second = 20;
		int third = 30;
		boolean bValue;
		int iValue;
		bValue = (third == first + second) ? true : false;
		System.out.println("Gia tri =  "+ bValue);
		
		iValue = (third == first + second) ? 50 : 100;
		System.out.println("Ket qua = "+ iValue);
		
		iValue = (!(third == first + second)) ? 50 : 100;
		System.out.println("Phu dinh cua ket qua = "+ iValue);
		
		System.out.println("=============================");

		
		
	}
}
