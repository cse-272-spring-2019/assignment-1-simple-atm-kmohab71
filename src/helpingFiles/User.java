package helpingFiles;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.*;

public class User extends Container {
	String username;
	private String password;
	private float balance=0;
	private Queue queueA = new LinkedList();
	//private Transaction[] transactions= new Transaction[5];
	public User(String username, String password)
	{
		this.username=username;
		this.setPassword(password);
	}
	public float getBalance() {
		return balance;
	}
	public void addBalance(float balance) {
		this.balance += balance;
	}
	public void withdrawBalance(float balance) {
		this.balance -= balance;
	}
	private String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean login(String enteredpassword)
	{
		if( ! password.equals(enteredpassword) )
		{
			return false ;
		}
		else return true;
	}


	public void addTransactions(Transaction transactions) {
		this.queueA.add(transactions);
	}
	public Queue getTransactions() {
		return(this.queueA);
	}
}
