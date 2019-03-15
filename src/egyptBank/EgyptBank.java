package egyptBank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import helpingFiles.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;
import java.util.*;

public class EgyptBank implements ActionListener {
	/*JFrame frame;
	JPanel LoginPanel, MainPanel, DepositPanel, WithdrawPanel,HistoryPanel,cardPane;
	CardLayout card;
	public EgyptBank() {
		User user1=new User("pick","1234");
		ATM atm=new ATM(10000,100);
		frame = new JFrame("ATM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		LoginPanel = new JPanel();
		MainPanel = new JPanel();
		DepositPanel = new JPanel();
		WithdrawPanel = new JPanel();
		HistoryPanel = new JPanel();
		cardPane = new JPanel();

		LoginPanel.setBackground(Color.DARK_GRAY);
		MainPanel.setBackground(Color.DARK_GRAY);
		DepositPanel.setBackground(Color.DARK_GRAY);
		WithdrawPanel.setBackground(Color.DARK_GRAY);
		HistoryPanel.setBackground(Color.DARK_GRAY);

		final JPasswordField EnteredPassword =new JPasswordField(30);
		LoginPanel.add(EnteredPassword);

		JButton signin = new JButton("sign in");
		signin.addActionListener(this);
		LoginPanel.add(signin);
		signin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String password = new String(EnteredPassword.getPassword());
				if (user1.login(password)){
					card.next(cardPane);
				}else
				{
					JOptionPane.showMessageDialog(frame,
							"Password is not correct");
				}
			}
		});



		JButton withdraw = new JButton("withdraw");
		withdraw.addActionListener(this);
		MainPanel.add(withdraw);
		withdraw.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				card.show(cardPane,"Withdraw Panel");
			}
		});

		JButton deposit = new JButton("deposit");
		deposit.addActionListener(this);
		MainPanel.add(deposit);
		deposit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				card.show(cardPane,"Deposit Panel");
			}
		});
		JButton history = new JButton("history");
		history.addActionListener(this);
		MainPanel.add(history);
		history.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				card.show(cardPane,"history Panel");
			}
		});

		JLabel lblAmount = new JLabel("Amount");
		JTextField Amount = new JTextField(20);
		lblAmount.setLabelFor(Amount);
		DepositPanel.add(lblAmount);
		DepositPanel.add(Amount);
		JButton enter = new JButton("Enter");
		enter.addActionListener(this);
		DepositPanel.add(enter);
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = Amount.getText();
				int amount = Integer.parseInt(text);
				atm.addToBalance(user1,amount);
				//card.previous(cardPane);
			}
		});


		cardPane.setLayout(card);
		cardPane.add(LoginPanel, "login Panel");
		cardPane.add(MainPanel, "Main Panel");
		cardPane.add(DepositPanel, "Deposit Panel");
		cardPane.add(WithdrawPanel, "Withdraw Panel");
		cardPane.add(HistoryPanel, "History Panel");
		frame.add(cardPane);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	public static void main(String args[]) {
		EgyptBank test = new EgyptBank();
	}*/
	JFrame frame;
	JPanel LoginPanel, MainPanel, DepositPanel, WithdrawPanel,HistoryPanel,cardPane;
	CardLayout card;
	public EgyptBank() {
		User user1=new User("pick","1234");
		ATM atm=new ATM(10000,100);
		frame = new JFrame("ATM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		LoginPanel = new JPanel();
		MainPanel = new JPanel();
		DepositPanel = new JPanel();
		WithdrawPanel = new JPanel();
		HistoryPanel = new JPanel();
		cardPane = new JPanel();

		LoginPanel.setBackground(Color.DARK_GRAY);
		MainPanel.setBackground(Color.DARK_GRAY);
		DepositPanel.setBackground(Color.DARK_GRAY);
		WithdrawPanel.setBackground(Color.DARK_GRAY);
		HistoryPanel.setBackground(Color.DARK_GRAY);

		//LoginPanel
		final JPasswordField EnteredPassword =new JPasswordField(30);
		LoginPanel.add(EnteredPassword);

		JButton signin = new JButton("sign in");
		signin.addActionListener(this);
		LoginPanel.add(signin);
		signin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String password = new String(EnteredPassword.getPassword());
				if (user1.login(password)){
					card.next(cardPane);
				}else
				{
					JOptionPane.showMessageDialog(frame,
							"Password is not correct");
				}
			}
		});
		//MainPanel
		JButton withdraw = new JButton("withdraw");
		withdraw.addActionListener(this);
		MainPanel.add(withdraw);
		withdraw.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				card.show(cardPane,"Withdraw Panel");
			}
		});

		JButton deposit = new JButton("deposit");
		deposit.addActionListener(this);
		MainPanel.add(deposit);
		deposit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				card.show(cardPane,"Deposit Panel");
			}
		});
		JButton history = new JButton("history");
		history.addActionListener(this);
		MainPanel.add(history);
		history.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				card.show(cardPane,"history Panel");
			}
		});
		//DepositPanel
		JLabel lblAmount = new JLabel("Amount");
		JTextField Amount = new JTextField(20);
		lblAmount.setLabelFor(Amount);
		DepositPanel.add(lblAmount);
		DepositPanel.add(Amount);
		JButton enter = new JButton("Enter");
		JButton back = new JButton("back");
		enter.addActionListener(this);
		DepositPanel.add(enter);
		DepositPanel.add(back);
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = Amount.getText();
				int amount = Integer.parseInt(text);
				atm.addToBalance(user1,amount);
				Transaction transaction = new Transaction("Deposit",amount);
				user1.addTransactions(transaction);
				card.show(cardPane,"Main Panel");			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(cardPane,"Main Panel");
			}});

		//WithdrawPanel
		JLabel WithAmount = new JLabel("Amount");
		JTextField WAmount = new JTextField(20);
		WithAmount.setLabelFor(WAmount);
		WithdrawPanel.add(WithAmount);
		WithdrawPanel.add(WAmount);
		JButton Wenter = new JButton("Enter");
		JButton Wback = new JButton("back");
		Wenter.addActionListener(this);
		Wback.addActionListener(this);
		WithdrawPanel.add(Wenter);
		WithdrawPanel.add(Wback);
		Wenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textW = WAmount.getText();
				int amountW = Integer.parseInt(textW);
				if(atm.withdraw(user1,amountW)==0)
					{
					card.previous(cardPane);
					Transaction transaction = new Transaction("Withdraw",amountW);
					user1.addTransactions(transaction);
					card.show(cardPane,"Main Panel");

					}
				else
					{
						JOptionPane.showMessageDialog(frame,
								"insuffient money!!");
					}
			}
		});
		Wback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(cardPane,"Main Panel");
			}});

		//HistoryPanel
		Object[][] data = new Object[user1.getTransactions().size()][3];
		Iterator iterator =user1.getTransactions().iterator();
		int i=0;
		while(iterator.hasNext(){
			Transaction element = (Transaction) iterator.next();
			data[i][0] = i;
			data[i][1] = element.transactionType;
			data[i][2] = element.value;
			i++;
		}


		Object[] columnNames = { "number", "type", "amount" };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		card = new CardLayout();
		cardPane.setLayout(card);
		cardPane.add(LoginPanel, "login Panel");
		cardPane.add(MainPanel, "Main Panel");
		cardPane.add(DepositPanel, "Deposit Panel");
		cardPane.add(WithdrawPanel, "Withdraw Panel");
		cardPane.add(HistoryPanel, "History Panel");
		frame.add(cardPane);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//card.next(cardPane);
	}
	public static void main(String args[]) {
		EgyptBank test = new EgyptBank();
	}

}

