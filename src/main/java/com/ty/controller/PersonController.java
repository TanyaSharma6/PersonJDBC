package com.ty.controller;
import java.util.Scanner;

import com.ty.dao.PersonDao;
import com.ty.dto.Person;

public class PersonController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p= new Person();
				
//		p.setId(7);
//		p.setName("Praveen");
//		p.setPhone(57686857);
//		p.setEmail("prashant@gmail.com");
//		p.setPassword("prashant@123");
//		p.setAge(31);
		
		PersonDao pd= new PersonDao();
		
//		pd.savePerson(p);
//		pd.updatePerson(p);
//		pd.deletePerson(p);
//		pd.getAllData();
//		pd.getDataById(2);
//		pd.validatePerson(p);

		
		boolean run = true;
		
		while(run) {
			Scanner sc= new Scanner(System.in);
			System.out.println("Choose from the List: ");
			System.out.println("1. Insert Data");
			System.out.println("2. Update Data");
			System.out.println("3. Delete Data");
			System.out.println("4. Show All Data");
			System.out.println("5. Show Data By Its ID \n");
			System.out.println("Your Choice: ");
			
			int choice =sc.nextInt();
			switch(choice) {
			
			case 1:{
				
				System.out.println("Enter your Data: \n ");
				
				System.out.println("Id : \n");
				int userId=sc.nextInt();
				
				System.out.println("Name :\n");
				String userName=sc.next();

				System.out.println("Phone No. :\n");
				Long userPhone=sc.nextLong();
				
				System.out.println("Email id :\n");
				String userEmail=sc.next();
				
				System.out.println("Password :\n");
				String userPassword=sc.next();
				
				System.out.println("Age :\n");
				int userAge=sc.nextInt();
				
				p.setId(userId);
				p.setName(userName);
				p.setPhone(userPhone);
				p.setEmail(userEmail);
				p.setPassword(userPassword);
				p.setAge(userAge);
				
				pd.savePerson(p);
			}
				break;
			
			case 2:
			{
				System.out.println("Update Your Age by Name \n");
				
				System.out.println("Enter your Age: \n");
				int userAge=sc.nextInt();
				
				System.out.println("Enter your Name: \n");
				String userName=sc.next();
				
				p.setId(userAge);
				p.setName(userName);
				
				pd.updatePerson(p);
			}
				break;
				
			case 3:
			{
				System.out.println("Delete The Data by Name \n");
				
				System.out.println("Enter your Name: ");
				String userName=sc.next();
				
				p.setName(userName);
				
				pd.deletePerson(p);

			}
				break;
				
			case 4:
				pd.getAllData();
				break;
			
			case 5:
				
				System.out.println("Enter the ID: ");
				int userId= sc.nextInt();
				pd.getDataById(userId);
			
				break;
			default:
				System.out.println("Please select available options from the list");
				run = false;
					 break;
			}
			
			
		}
		
				
			}
		
		}
