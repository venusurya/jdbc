package jdbc_maven_eb9;

import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the Id");
		System.out.println("Enter the Id TO be Updated ");
//		System.out.println("Enter the Id To Be Deleted");
		int id = scanner.nextInt();
//		System.out.println("Enter the Name");
		System.out.println("Enter the Name Name To Updated");
		String name = scanner.next();
//		System.out.println("Enter the Phone");
//		long phone=scanner.nextLong();
		Person person = new Person();
// 		person.setId(id);
//		person.setName(name);
//		person.setPhone(phone);
		PersonCRUD crud = new PersonCRUD();
		try {
//			 crud.savePerson( person);
			crud.updatePerson(person);
//			crud.deletePerson(id);
//			crud.getAllPerson();
		} catch (Exception e) {
			System.out.println("404 NOT FOUND");
		}

	}

}
