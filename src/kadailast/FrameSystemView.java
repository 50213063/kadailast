package kadailast;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FrameSystemView extends Frame implements ActionListener,WindowListener{

	private Button button1 = new Button("表示");
	private Button button2 = new Button("グラフ");
	
	private TextArea m1 = new TextArea("",15,30);
	
	public FrameSystemView(FrameSystemController controller) {
		// TODO 自動生成されたコンストラクター・スタブ
		addWindowListener(this);
		setTitle("FrameSystem");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(button1);
		add(m1);
		add(button2);
		
		
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getSource() == button1){
			int id;
			float score;
			String name; 
			ResultSet rs; 
			MySQL mysql = new MySQL(); 
			rs = mysql.selectAll();		 
			
			try { 
			 			while(rs.next()){ 
			 				id = rs.getInt("id"); 
			 				name = rs.getString("name"); 
			 				score = rs.getFloat("score");
			 				
			 				m1.append("ID：" + id); 
			 				m1.append("\n");
			 				m1.append("名前：" + name); 
			 				m1.append("\n");
			 				m1.append("得点数：" + score);
			 				m1.append("\n");
			 				m1.append("************");
			 				m1.append("\n");
			 			} 
			 		} catch (SQLException e1) { 
			 			// TODO Auto-generated catch block 
			 			e1.printStackTrace(); 
			 		} 

		}else{
			FrameSystemController controller = new FrameSystemController();
			Framescore chart = new Framescore(controller);

			chart.setBounds(5,5,655,455);
			chart.setVisible(true);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ

		System.exit(0);

	
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}