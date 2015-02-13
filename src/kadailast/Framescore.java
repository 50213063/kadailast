package kadailast;

import java.awt.BorderLayout;
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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Framescore extends Frame implements ActionListener,WindowListener{

	private TextArea m1 = new TextArea("",15,30);
	
	public Framescore(FrameSystemController controller) {
		// TODO 自動生成されたコンストラクター・スタブ
		addWindowListener(this);
		setTitle("score");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
		
		 DefaultCategoryDataset data = new DefaultCategoryDataset();
		 
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
			 				
			 				data.addValue(score, name, "選手");
			 				
			 			} 
	 		} catch (SQLException e1) { 
	 			// TODO Auto-generated catch block 
	 			e1.printStackTrace(); 
	 		} 
		     


		         JFreeChart chart = 
		           ChartFactory.createBarChart("選手別得点数",
		                                        "",
		                                        "得点数",
		                                        data,
		                                        PlotOrientation.VERTICAL,
		                                        true,
		                                        false,
		                                        false);

		         ChartPanel cpanel = new ChartPanel(chart);
		         add(cpanel, BorderLayout.CENTER);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	
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