import java.util.Scanner;
class BankAccount{
	String name;
	String username;
	String password;
	String accountno;
	float balance=0;
	int transactions=0;
	String transactionHistory="";
	public void register(){
		Scanner s=new Scanner(System.in);
		System.out.println("\nEnter Your Name - ");
		this.name=s.nextLine();
		System.out.println("\nEnter Your Username - ");
		this.username=s.nextLine();
		System.out.println("\nEnter Your Password - ");
		this.password=s.nextLine();
		System.out.println("\nEnter Your Account Number - ");
		this.accountno=s.nextLine();
		System.out.println("\nRegistration completed....Kindly Login");
	}
	
	public boolean login(){
		boolean isLogin=false;
		Scanner s=new Scanner(System.in);
		while(!isLogin){
			System.out.println("\nEnter Your Username - ");
			String userName=s.nextLine();
			if(userName.equals(username)){
				while(!isLogin){
					System.out.println("\nEnter Your Password - ");
					String Password=s.nextLine();
					if(Password.equals(password)){
						System.out.println("\nLogin Successfull");
						isLogin=true;
					}
					else{
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else{
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
	
	public void withdraw(){
		System.out.println("\nEnter amount to withdraw - ");
		Scanner s=new Scanner(System.in);
		float amount = s.nextFloat();
		try{
			if(balance>=amount){
				transactions++;
				balance-=amount;
				System.out.println("\nWithdraw successfull");
				String str=amount +" Rs Withdrawn\n";
				transactionHistory=transactionHistory.concat(str);
			}
			else{
				System.out.println("\nInsufficient balance");
			}
		}
		catch(Exception e){}
	}
	
	public void deposit(){
		System.out.println("\nEnter amount to deposit - ");
		Scanner s=new Scanner(System.in);
		float amount = s.nextFloat();
		try{
			if(amount<=10000){
				transactions++;
				balance+=amount;
				System.out.println("\nSuccessfully Deposited");
				String str=amount +" Rs Deposited\n";
				transactionHistory=transactionHistory.concat(str);
			}
			else{
				System.out.println("\nSorry.....Limit is 10000");
			}
		}
		catch(Exception e){}
	}
				
	public void transfer(){
		Scanner s=new Scanner(System.in);
		System.out.println("\nEnter Recepient's Name - ");
		String recepient = s.nextLine();
		System.out.println("\nEnter amount to transfer - ");
		float amount = s.nextFloat();
		try{
			if(balance>=amount){
				if(amount<=10000f){
					transactions++;
					balance-=amount;
					System.out.println("\nSuccessfully Transferred to "+recepient);
					String str=amount +" Rs Transferred to "+ recepient+" \n";
					transactionHistory=transactionHistory.concat(str);
				}
				else{
					System.out.println("\nSorry.....Limit is 10000");
				}
			}
			else{
				System.out.println("\nInsufficient balance");
			}
		}
		catch(Exception e){}
	}
	public void checkBalance(){
		System.out.println("\n"+balance+" Rs");
	}
	public void transHistory(){
		if(transactions==0){
			System.out.println("\nEmpty");
		}
		else{
			System.out.println("\n"+transactionHistory);
		}
	}
}
public class ATMInterface{
	public static int fun(int limit){
		int input=0;
		boolean flag=false;
		while(!flag){
			try{
				Scanner s=new Scanner(System.in);
				input = s.nextInt();
				flag=true;
				if(flag&&input>limit||input<1){
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}
			catch(Exception e){
				System.out.println("Enter only Integer value");
				flag=false;
			}
		};
		return input;
	}
	public static void main(String[] args){
		System.out.println("\n************WELCOME TO SBI ATM SYSTEM**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.println("Enter Your Choice - ");
		int choice = fun(2);
		if(choice==1){
			BankAccount sb=new BankAccount();
			sb.register();
			while(true){
				System.out.println("\n1.Login \n2.Exit");
				System.out.println("Enter Your Choice - ");
				int c = fun(2);
				if(c==1){
					if(sb.login()){
						System.out.println("\n************WELCOME BACK "+sb.name+" **********\n");
						boolean isFinished=false;
						while(!isFinished){
							System.out.println("\n1.Withdrawn \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.println("Enter Your Choice - ");
							int ch = fun(6);
							switch(ch){
								case 1:
								sb.withdraw();
								break;
								case 2:
								sb.deposit();
								break;
								case 3:
								sb.transfer();
								break;
								case 4:
								sb.checkBalance();
								break;
								case 5:
								sb.transHistory();
								break;
								case 6:
								isFinished=true;
								break;
							}
						}
					}
					
				}
				else{
					System.exit(0);
				}
			}
		}
		else{
				System.exit(0);
		}
	}
}
								
				
				
		
	