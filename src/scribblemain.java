import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings("serial")
public class scribblemain extends JFrame implements ActionListener, MouseListener, MouseMotionListener
{
 Dimension d=new Dimension();
 ImageIcon imgi;
 drawpanel dp;
 JPanel statusp;
 JToolBar jt,jtn;
 JButton rectb,fillrectb,lineb,ellipseb,fillellipseb,alpha,sav,pencil;
 Button bg,fg;
 JLabel mouseactn,xylab,oplab;
 int x=0,y=0,dx=0,dy=0;
 String shape="";
 String alphatxt="";
 int fsize=12;
	public scribblemain() {
		
		super("SCRIBBLE BY JAVA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//System.out.println(d.height);
		//System.out.println(d.width);
		d= Toolkit.getDefaultToolkit().getScreenSize(); //used to get screen resolution of any system
		setSize(d.width-100, d.height-100);
		
		
		//east tool bar
		
		
		jt=new JToolBar("hello",JToolBar.VERTICAL);// icons are placed vertically
	     //jt.setFloatable(false);// to make a toolbar fix in same place
		add(jt,BorderLayout.EAST);
		//jt.add(new JButton("loosu"));
		
		// to put icon
		//imgi= new ImageIcon(getClass().getResource("resources/buckettool.jpg"));// getclass is wer classes r present nd getresorce is wer  img is present
		//jt.add(new JButton(imgi));
		
		imgi = new ImageIcon(getClass().getResource("resources/pencil.jpg"));
		pencil= new JButton(imgi);
		jt.add(pencil);
		
		imgi=new ImageIcon(getClass().getResource("resources/lineb.jpg"));
		lineb = new JButton(imgi);
		jt.add(lineb);
		
		imgi=new ImageIcon(getClass().getResource("resources/rect.jpg"));
		rectb= new JButton(imgi);
		jt.add(rectb);
		
		imgi=new ImageIcon(getClass().getResource("resources/fillrectb.jpg"));
		fillrectb= new JButton(imgi);
		jt.add(fillrectb);
		
		imgi=new ImageIcon(getClass().getResource("resources/ellipseb.jpg"));
		ellipseb= new JButton(imgi);
		jt.add(ellipseb);
		
		imgi=new ImageIcon(getClass().getResource("resources/fillellipseb.jpg"));
		fillellipseb= new JButton(imgi);
		jt.add(fillellipseb);
		
		
		imgi=new ImageIcon(getClass().getResource("resources/alpha.jpg"));
		alpha= new JButton(imgi);
		jt.add(alpha);
		
		//actionlistners
		
		pencil.setActionCommand("pencil");
		pencil.addActionListener(this);
		
		lineb.setActionCommand("line");
		lineb.addActionListener(this);
		
		rectb.setActionCommand("rectangle");
		rectb.addActionListener(this);
		
		fillrectb.setActionCommand("fillrectangle");
		fillrectb.addActionListener(this);
		
		ellipseb.setActionCommand("ellipse");
		ellipseb.addActionListener(this);
		
		fillellipseb.setActionCommand("fillellipse");
		fillellipseb.addActionListener(this);
		
		alpha.setActionCommand("alpha");
		alpha.addActionListener(this);
		//north toolbar
		
		jtn=new JToolBar("northtoolbar",JToolBar.HORIZONTAL);
		add(jtn,BorderLayout.NORTH);
		
		imgi=new ImageIcon(getClass().getResource("resources/sav.jpg"));
		sav= new JButton(imgi);
		jtn.add(sav);
		
		
		//action listeners of north tool bar
		sav.setActionCommand("save");
		sav.addActionListener(this);
		
		dp=new drawpanel();
		add(dp);
		//creation of new btn in north 
		
		jtn.setLayout(new FlowLayout(0, 0, 0));
		
		jtn.add(new JLabel(" background  "));
		bg=new Button("			");
		bg.setBackground(dp.getBackground());
		jtn.add(bg);
		

		jtn.add(new JLabel(" foreground  "));
		fg=new Button("			");
		fg.setBackground(dp.getForeground());
		jtn.add(fg);
		
		//actions for bg and fg colors
		
		bg.setActionCommand("bcolor");
		bg.addActionListener(this);
		
		fg.setActionCommand("fcolor");
		fg.addActionListener(this);
		
		
	dp.addMouseListener(this);
	dp.addMouseMotionListener(this);
	
	
	//statuspanel
	
	statusp=new JPanel();
	mouseactn= new JLabel("Mouse : ");
	xylab=new JLabel("| x :  " + x +"     | y : " + y);
	oplab=new JLabel("| Operation : ");
	
	
	
	statusp.add(mouseactn);
	statusp.add(xylab);
	statusp.add(oplab);
	statusp.setLayout(new GridLayout(1,3));
	add(statusp,BorderLayout.SOUTH);
	
	
		
		
}
	
	public static void main(String[] args)
	{
		scribblemain sm= new scribblemain();
		sm.setVisible(true);
	
	}
	

	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("pencil")){
			oplab.setText("| Operation : Pencil tool");
			shape="pencil";
		}
		if(ae.getActionCommand().equals("line")){
			oplab.setText("| Operation : line tool");
			shape="line";
			
			}
		
		if(ae.getActionCommand().equals("rectangle")){
			oplab.setText("| Operation : Rectangle Tool");
			shape="rectangle";
				}
		
		if(ae.getActionCommand().equals("fillrectangle")){
			oplab.setText("| Operation : Fill rectangle Tool");
			shape="fill rectangle";
			}
		
		if(ae.getActionCommand().equals("ellipse")){
			
			oplab.setText("| Operation : Ellipse");
			shape="ellipse";
			}
		
		if(ae.getActionCommand().equals("fillellipse")){
			oplab.setText("| Operation : fill ellipse");
			shape="fill ellipse";
			}
		
		if(ae.getActionCommand().equals("rubber")){
			oplab.setText("| Operation : rubber");
			shape="rubber";
			}
		
		
		if(ae.getActionCommand().equals("bcolor")){
			
			Color c=JColorChooser.showDialog(this, "select a color", dp.getBackground());
			dp.setBackground(c);
			bg.setBackground(c);
			
	//in dis we r changing butn background and as wel as forgrd
			}
		
		if(ae.getActionCommand().equals("fcolor")){
			Color c=JColorChooser.showDialog(this, "select a color",dp.getForeground());
			fg.setBackground(c);
			}
		if(ae.getActionCommand().equals("alpha")){
			shape="alpha";
			oplab.setText("| Operation : Alphabet tool(Click where to enter text)");
			
		}
		if(ae.getActionCommand().equals("save")){
			JFileChooser jc = new JFileChooser();
			jc.showSaveDialog(this);
			jc.getSelectedFile();
			dp.saver(jc.getSelectedFile().toString());
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		mouseactn.setText("Mouse : Dragged");
		
		if(shape.equals("pencil")){
			int nx,ny;
			nx=me.getX();
			ny=me.getY();
			dp.penpainter(x, y, nx, ny,fg.getBackground());
			x=nx;
			y=ny;
		}
		}

	@Override
	public void mouseMoved(MouseEvent me) {
		x=me.getX();
		y=me.getY();
		xylab.setText("| x :  " + x +"     | y : " + y);
		
		mouseactn.setText("Mouse : Moved");
		
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		mouseactn.setText("Mouse : Clicked");
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		mouseactn.setText("Mouse : Entered");
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		mouseactn.setText("Mouse : Exited");
	}

	@Override
	public void mousePressed(MouseEvent me) {
		mouseactn.setText("Mouse : Pressed");
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		mouseactn.setText("Mouse : Released");

		if(shape.equals("line"))
		{
			dx=me.getX();
			dy=me.getY();
			dp.linepainter(x, y, dx, dy,fg.getBackground());
			
			
		}
		if(shape.equals("rectangle"))
		{
			dx=me.getX()-x;
			dy=me.getY()-y;
			dp.rectpainter(x, y, dx, dy,fg.getBackground());
			
		}
		
		if(shape.equals("fill rectangle"))
		{
			dx=me.getX()-x;
			dy=me.getY()-y;
			dp.fillrectpainter(x, y, dx, dy,fg.getBackground());			
		}
		
		if(shape.equals("ellipse"))
		{
			dx=me.getX()-x;
			dy=me.getY()-y;
			dp.ellipsepainter(x, y, dx, dy,fg.getBackground());
			
		}
		if(shape.equals("fill ellipse"))
		{
			dx=me.getX()-x;
			dy=me.getY()-y;
			dp.fillellipsepainter(x, y, dx, dy,fg.getBackground());
			
		}
		if(shape.equals("alpha")){
			dx=me.getX();
			dy=me.getY();
			final JFrame alphaframe= new JFrame("What text u need at : "+dx+" , " +dy); 
			alphaframe.setVisible(true);
			alphaframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			alphaframe.setSize(500, 300);
			alphaframe.setLocation((d.width-alphaframe.getWidth())/2,(d.height-alphaframe.getHeight())/2);
			final TextArea jt = new TextArea();
			alphaframe.add(jt);
			JPanel bpan=new JPanel();
			JButton ok=new JButton("Ok");
			bpan.add(ok);
			
			JButton clr = new JButton("Clear");
			bpan.add(clr);
			clr.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					jt.setText("");
					
				}
			});
			alphaframe.add(bpan,BorderLayout.SOUTH);
			
			JPanel fpan = new JPanel();
			JLabel flab = new JLabel("Font Size:");
			fpan.add(flab);
			final JLabel fsizelab = new JLabel("12");
			fpan.add(fsizelab);
			final JSlider js = new JSlider(JSlider.HORIZONTAL, 0, 100, 12);
			js.setPaintTicks(true);
			js.setPaintLabels(true);
			js.setMajorTickSpacing(10);
			js.setMinorTickSpacing(5);
			
			js.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent ce) {
					fsize=js.getValue();
					jt.setFont(new Font("Dialog",Font.PLAIN	,fsize));
					fsizelab.setText(""+fsize);
				}
			});

			ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					alphatxt=jt.getText();
					dp.alphapainter(dx,dy,fg.getBackground(),alphatxt,fsize);
					fsize=12;
					alphaframe.dispose();
				}
			});
			fpan.add(js);
			alphaframe.add(fpan,BorderLayout.NORTH);
			
		}
		
	}

}
