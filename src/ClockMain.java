import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

class cThread extends Thread {
	private JLabel cLabel;
	
	public cThread(JLabel cLabel) {
		this.cLabel = cLabel;
	}
	
	@Override
	public void run() {
		while(true) {
			Calendar c = Calendar.getInstance();
			// 현재 날짜, 시간 , 분, 초 값을 가진 객체 얻기
			int date = c.get(Calendar.DATE);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			String clockText = Integer.toString(hour);
			clockText = clockText.concat(":");
			//스트링객체는 수정 불가능 이므로, concat(concatenation)으로 붙임
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			cLabel.setText(clockText);
		}
	}
}

public class ClockMain extends JFrame {
	
	public  ClockMain() {
		super("Digital Clock Making");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel cLabel = new JLabel();
		cLabel.setFont(new Font("Gothic", Font.ITALIC,80));
		c.add(cLabel);
		
		cThread th = new cThread(cLabel);
		setSize(500,400);
		setVisible(true);
		th.start();
	}
	public static void main(String[] args) {
		new ClockMain();

	}

}
