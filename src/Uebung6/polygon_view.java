package Uebung6;

import java.awt.*;

@SuppressWarnings("serial")
public class polygon_view extends Frame{
	
	
	private polygon_model m_Mod;
	private Color m_polygon_Color;
	JobAttributes jobAtt = new JobAttributes();
	PageAttributes pageAtt = new PageAttributes();
	int counter = 0;
	
	polygon_view(polygon_model mod, Color background, Color polygon_color){
		super("Zufälliges Polynom :D");
		m_Mod = mod;
		setSize(m_Mod.m_maxx, m_Mod.m_maxy);
		setVisible(true);
		setBackground(background);
		m_polygon_Color = polygon_color;
		
		
	}
	
	
	
	public void paint(Graphics g){
		final Insets ins = getInsets();
		final Dimension dim = getSize();

		
		for(int i = 0; i < m_Mod.m_xkoor.length; ++i){
			if(m_Mod.m_xkoor[i] < ins.left)					{	m_Mod.m_xkoor[i] += ins.left;	}
			if(m_Mod.m_xkoor[i] > dim.width - ins.right)	{	m_Mod.m_xkoor[i] -= ins.right;	}
			if(m_Mod.m_ykoor[i] < ins.top)					{		m_Mod.m_ykoor[i] += ins.top;}
			if(m_Mod.m_ykoor[i] > dim.height - ins.bottom)	{	m_Mod.m_ykoor[i] -= ins.bottom;	}
		}
		
		g.setColor(m_polygon_Color);
		g.fillPolygon(m_Mod.m_xkoor, m_Mod.m_ykoor, m_Mod.m_nline);
	
		
	}
	
	public void printTestPage() {
		Toolkit tool = getToolkit();
		PrintJob pJob = tool.getPrintJob(this,"Testseite",jobAtt,pageAtt);
		if (pJob != null) {
			@SuppressWarnings("unused")
			Dimension dim = pJob.getPageDimension();
			@SuppressWarnings("unused")
			Graphics g = pJob.getGraphics();
			pJob.end();
			}
	}
	
}
