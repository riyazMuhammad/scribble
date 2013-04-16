import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class drawpanel extends JPanel {
	int[]tx =new int[30000], ty= new int[30000],tdx= new int[30000],tdy= new int[30000];
	int[]rx= new int[30000],ry=new int[30000],rdx=new int[30000],rdy=new int[30000];
	int[]frx=new int[30000],fry=new int[30000],frdx=new int[30000],frdy=new int[30000];
	int[]ex= new int[30000],ey=new int[30000],edx=new int[30000],edy=new int[30000];
	int[]fex=new int[30000],fey=new int[30000],fedx=new int[30000],fedy=new int[30000];
	int[]alphax= new int[30000],alphay=new int[30000];
	int[]penx=new int[30000],peny=new int[30000],pendx=new int[30000],pendy=new int[30000];
	String[] alphatext=new String[300];
	int i=0,alphi=0;
	int[] fsize = new int[30000];
	Color[] lcol = new Color[30000],rcol = new Color[30000],frcol= new Color[30000],ecol= new Color[30000],fecol=new Color[30000],alcol= new Color[30000];
	Color[] pcol=new Color[30000];
	public drawpanel()
	{
		
		setBackground(Color.white);
		setForeground(Color.black);	
		
	}
   public void linepainter(int lx,int ly,int ldx,int ldy,Color col){
	   tx[i]=lx;
	   ty[i]=ly;
	   tdx[i]=ldx;
	   tdy[i]=ldy;
	   lcol[i]=col;
	   repaint();
	   i++;
	   
   }
   
   public void rectpainter(int lx,int ly,int ldx, int ldy,Color col ){
	   rx[i]=lx;
	   ry[i]=ly;
	   rdx[i]=ldx;
	   rdy[i]=ldy;
	   rcol[i]=col;
	   repaint();
	   i++;
   }
   
   public void fillrectpainter(int lx,int ly,int ldx, int ldy,Color col ){
	   frx[i]=lx;
	   fry[i]=ly;
	   frdx[i]=ldx;
	   frdy[i]=ldy;
	   frcol[i]=col;
	   repaint();
	   i++;
   }

   public void ellipsepainter(int lx,int ly,int ldx, int ldy,Color col ){
	   ex[i]=lx;
	   ey[i]=ly;
	   edx[i]=ldx;
	   edy[i]=ldy;
	   ecol[i]=col;
	   repaint();
	   i++;
   }
   
   public void fillellipsepainter(int lx,int ly,int ldx, int ldy,Color col ){
	   fex[i]=lx;
	   fey[i]=ly;
	   fedx[i]=ldx;
	   fedy[i]=ldy;
	   fecol[i]=col;
	   repaint();
	   i++;
   }
   public void penpainter(int lx,int ly,int ldx, int ldy,Color col ){
	   penx[i]=lx;
	   peny[i]=ly;
	   pendx[i]=ldx;
	   pendy[i]=ldy;
	   pcol[i]=col;
	   repaint();
	   i++;
   }
   
   public void alphapainter(int x,int y,Color col,String txt,int fontsize){
	   alphax[alphi]=x;
	   alphay[alphi]=y;
	   alcol[alphi]=col;
	   alphatext[alphi]=txt;
	   fsize[alphi]=fontsize;
	   repaint();
	   alphi++;
   }
   
   public void saver(String fname){
	   Graphics gr;
	   File f1=new File(fname);
	   BufferedImage img=new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	   gr=img.createGraphics();
	   gr.setColor(getBackground());
	   gr.fillRect(0, 0, getWidth(), getHeight());
	   
	   for(int j=0;j<i;j++){
			gr.setColor(lcol[j]);
			gr.drawLine(tx[j],ty[j], tdx[j], tdy[j]);
		}
		for(int j=0;j<i;j++){
			gr.setColor(rcol[j]);
			gr.drawRect(rx[j], ry[j], rdx[j], rdy[j]);
		}
		for(int j=0;j<i;j++){
			gr.setColor(frcol[j]);
			gr.fillRect(frx[j],fry[j], frdx[j], frdy[j]);
		}
		for(int j=0;j<i;j++){
			gr.setColor(ecol[j]);
			gr.drawOval(ex[j],ey[j],edx[j],edy[j]);
		}
		for(int j=0;j<i;j++){
			gr.setColor(fecol[j]);
			gr.fillOval(fex[j], fey[j], fedx[j], fedy[j]);
		}
		
		for(int j=0;j<alphi;j++){
			gr.setColor(alcol[j]);
			gr.setFont(new Font("Dialog", Font.PLAIN, fsize[j]));
			gr.drawString(alphatext[j], alphax[j], alphay[j]);
		}
		for(int j=0;j<i;j++){
			gr.setColor(pcol[j]);
			gr.drawLine(penx[j],peny[j], pendx[j], pendy[j]);
		}
	  try {
		ImageIO.write(img, "jpg", f1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	   
   }
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		for(int j=0;j<i;j++){
			g.setColor(lcol[j]);
			g.drawLine(tx[j],ty[j], tdx[j], tdy[j]);
		}
		for(int j=0;j<i;j++){
			g.setColor(rcol[j]);
			g.drawRect(rx[j], ry[j], rdx[j], rdy[j]);
		}
		for(int j=0;j<i;j++){
			g.setColor(frcol[j]);
			g.fillRect(frx[j],fry[j], frdx[j], frdy[j]);
		}
		for(int j=0;j<i;j++){
			g.setColor(ecol[j]);
			g.drawOval(ex[j],ey[j],edx[j],edy[j]);
		}
		for(int j=0;j<i;j++){
			g.setColor(fecol[j]);
			g.fillOval(fex[j], fey[j], fedx[j], fedy[j]);
		}
		for(int j=0;j<alphi;j++){
			g.setColor(alcol[j]);
			g.setFont(new Font("Dialog", Font.PLAIN, fsize[j]));
			g.drawString(alphatext[j], alphax[j], alphay[j]);
		}
		for(int j=0;j<i;j++){
			g.setColor(pcol[j]);
			g.drawLine(penx[j],peny[j], pendx[j], pendy[j]);
		}
	}
}
