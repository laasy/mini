package com.cg.lap.controller;

import java.util.List;
import java.util.Scanner;

import com.cg.lap.exception.LAPException;
import com.cg.lap.model.LoanPrograms;
import com.cg.lap.service.LoanService;
import com.cg.lap.service.LoanServiceImpl;

public class Main {

	public static void main(String[] args) throws LAPException {
		Scanner scanner = new Scanner(System.in);
		boolean result = false;
		do {
			System.out.println("enter login id");
			int loginId = scanner.nextInt();
			System.out.println("enter password");
			scanner.nextLine();
			String password = scanner.nextLine();

			LoanService service = new LoanServiceImpl();
			try {
				result = service.validateFields(loginId, password);	

				if (result == true) {
					System.out.println("******Loan Application Processing*******");
					System.out.println("select choice");
					System.out.println("1.View Loan offers provided by home finance provided");
					System.out.println("2.View Loan Applications for a specific loan program ");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						List<LoanPrograms> list = null;
						list = service.viewDetails();
						for (LoanPrograms loan : list) {
							System.out.println("\nProgram Name\t:" + loan.getProgramName() + "\nProgram Description\t:"
									+ loan.getDescription() + "\nProgram Type\t:" + loan.getType()
									+ "\nDuration of years\t:" + loan.getDescription()
									+ "\nMinimum Amount Of Loan You Can Apply\t:" + loan.getMinLoan()
									+ "\nMaximum Amount Of Loan You Can Apply\t:" + loan.getMaxLoan()
									+ "\nRate of Interest\t:" + loan.getInterest() + "\nProofs to be submitted\t:"
									+ loan.getProofs());
						}
						break;
					case 2:List<>
					}

				} else {
					System.out.println("username /password wrong");
				}
			} catch (LAPException e) {
				e.printStackTrace();
			}
		} while (result!= true);
	}

}
