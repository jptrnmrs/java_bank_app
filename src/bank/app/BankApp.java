package bank.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Account> accounts = new ArrayList<>();
	
	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("----------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			if(selectNo==1) {
				creatAccount();
			} else if(selectNo==2) {
				acountList();
			} else if(selectNo==3) {
				deposit();
			} else if(selectNo==4) {
				withdraw();
			} else if(selectNo==5) {
				run=false;
			} 
		}
		System.out.println("프로그램 종료");
	}
	private static void creatAccount() {
		System.out.println("----------------- 계좌생성 ----------------");
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine().trim();
		System.out.print("계좌주: ");
		String owner = scanner.nextLine().trim();
		System.out.print("초기입금액: ");
		int balance = Integer.parseInt(scanner.nextLine().trim());
		accounts.add(new Account(ano,owner,balance));
		System.out.println("결과: 계좌가 생성되었습니다.");
	}
	private static void acountList() {
		System.out.println("----------------- 계좌목록 ----------------");
		for(Account acc : accounts) {
			System.out.println(acc.getAno()+" "+acc.getOwner()+" "+acc.getBalance());
		}
	}
	private static void deposit() {
		System.out.println("------------------ 예금 -----------------");
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine().trim();
		System.out.print("예금액: ");
		int input = Integer.parseInt(scanner.nextLine().trim());
		Account acc = findAccount(ano);
		acc.setBalance(acc.getBalance()+input);
		System.out.println("결과: 예금이 성공되었습니다.");
	}
	private static void withdraw() {
		System.out.println("------------------ 출금 -----------------");
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine().trim();
		System.out.print("예금액: ");
		int input = Integer.parseInt(scanner.nextLine().trim());
		Account acc = findAccount(ano);
		acc.setBalance(acc.getBalance()-input);
		System.out.println("결과: 출금이 성공되었습니다.");
		
	}
	private static Account findAccount(String ano) {
		Account findAcc = null;
		for(Account acc : accounts) {
			if(acc.getAno().equals(ano)) {
				findAcc=acc;
				break;
			}
		}
		return findAcc;
	}
		

}
