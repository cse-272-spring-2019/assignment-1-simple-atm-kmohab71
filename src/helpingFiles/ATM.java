package helpingFiles;

public class ATM 
{
	int credit;
	int faka;
	private int state;
	public ATM(int credit, int faka)
	{
		this.credit=credit;
		this.faka=faka;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	public void addToBalance(User user, int amount)
	{
		user.addBalance(amount);
		if(amount%10==0 || amount%10==5)
		{
			this.credit+=amount;
		}
		else if((amount%10) < 5)
		{
			this.faka+=amount%10;
			this.credit+=amount-amount%10;
		}
		else
		{
			this.faka+=amount%10-5;
			this.credit+=amount-amount%10+5;
		}
	}
	public int withdraw(User user, int amount)
	{
		user.withdrawBalance(amount);
		if(this.credit>=amount && this.faka>=amount%10 && user.getBalance()>=amount) 
		{
			user.withdrawBalance(amount);
			if(amount%10==0 || amount%10==5)
			{	
				this.credit-=amount;
			}
			else if((amount%10) < 5)
			{
				this.faka-=amount%10;
				this.credit-=amount-amount%10;
			}
			else
			{
				this.faka-=amount%10-5;
				this.credit-=amount-amount%10+5;
			}
			return 0;
		}else if(user.getBalance()<=amount)
		{
			System.out.println("Balance is not sufficiant");
			return 1;
		}
		else if(this.credit>=amount && this.faka<amount%10)
		{
			user.withdrawBalance(amount);
			System.out.println("faka in the machine is not sufficiant ");
			this.credit-=amount-amount%10;
			return 2;
		}
		else 
		{
			System.out.println("cash in the machine is not sufficiant ");
			return 3;
		}	
	}
}
