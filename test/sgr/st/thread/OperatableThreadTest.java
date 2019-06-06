package sgr.st.thread;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatableThreadTest extends Frame implements ActionListener{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		new OperatableThreadTest();
	}

	Label lbl1;
	Button btnRun1;
	Button btnWait1;
	Button btnRestart1;
	Button btnEnd1;

	OperatableThread t1 = null;

	public OperatableThreadTest(){
		this.setTitle("OperatableThreadTest");
		this.setSize(400,300);
		this.setLayout(new GridLayout(2,1));

		lbl1 = new Label();
		this.add(lbl1);
		Panel p1 = new Panel();
		btnRun1 = new Button("Run");
		btnRun1.addActionListener(this);
		btnWait1 = new Button("Wait");
		btnWait1.addActionListener(this);
		btnRestart1 = new Button("Restart");
		btnRestart1.addActionListener(this);
		btnEnd1 = new Button("End");
		btnEnd1.addActionListener(this);
		p1.add(btnRun1);
		p1.add(btnWait1);
		p1.add(btnRestart1);
		p1.add(btnEnd1);
		this.add(p1);

		t1 = new SleepThread();
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRun1){
			t1.start();
		}else if (e.getSource() == btnWait1){
			t1.halt();
		}else if (e.getSource() == btnRestart1){
			t1.restart();
		}else if (e.getSource() == btnEnd1){
			t1.close();
			try {
				t1.join();
			} catch (InterruptedException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			this.dispose();
			System.exit(0);
		}
	}
}

class SleepThread extends OperatableThread{
	@Override
	protected void doRepeatedTask() {
		try {
			System.out.println("sleep");
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}