package nut;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.SoftBevelBorder;

public class NUT
{

	public static void main(String[] args)
	{
		JFrame MainF = new JFrame();
		JPanel MainP = new JPanel();
		JLabel MainL = new JLabel();
		
		MainF.add(MainP);
		
		MainP.add(MainL, BorderLayout.CENTER);		
		MainP.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
		MainP.setPreferredSize(new Dimension(180,160));
		MainL.setIcon(new ImageIcon(NUT.class.getResource("/nut/nut.png")));
		
		MainF.pack();
		MainF.setLocationRelativeTo(null);
		MainF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		MainF.setVisible(true);
		MouseListener ml = new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				MainP.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				playSound();
				MainP.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				MainP.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
		};
		MainP.addMouseListener(ml);
		

	}

	public static synchronized void playSound() {
		  new Thread(new Runnable() {
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          NUT.class.getResourceAsStream("/nut/nut.wav"));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
}
