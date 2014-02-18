package no.ntnu.item.ttm4115.gui.taxigui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import no.ntnu.item.arctis.runtime.Block;

public class TaxiGUI extends Block {
	
	public final String ON_DUTY = "ON_DUTY";
	public final String OFF_DUTY = "OFF_DUTY";
	public final String AVAILABLE = "AVAILABLE";
	public final String UNAVAILABLE = "UNAVAILABLE";
	public final String CONFIRM = "CONFIRM";
	public final String EXIT = "EXIT";
	
	private JFrame frame;
	private JButton onDuty, offDuty, available, unavailable, confirm;
	private JTextArea textArea;
	
	private String state = "Offline";
	private String id;

	public void show(String id) {
		this.id = id;
		frame = new JFrame(id+": "+state);
		frame.setBounds(200, 200, 450, 300);
		
		frame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
            	sendToBlock(EXIT);
            }
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void windowClosed(WindowEvent e) {
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub		
			}
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub	
			}
        });
		
		onDuty = new JButton("On duty");
		onDuty.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendToBlock(ON_DUTY);
			}
			
		});
		offDuty = new JButton("Off duty");
		offDuty.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendToBlock(OFF_DUTY);
			}
			
		});
		available = new JButton("Available");
		available.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendToBlock(AVAILABLE);
			}
			
		});
		unavailable = new JButton("Unavailable");
		unavailable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendToBlock(UNAVAILABLE);
			}
			
		});
		confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendToBlock(CONFIRM);
			}
			
		});
		
		frame.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
				
		onDuty.setPreferredSize(new Dimension(120, 40));
		frame.add(onDuty, c);
		
		offDuty.setPreferredSize(new Dimension(120, 40));
		c.gridy = 1;
		frame.add(offDuty, c);
		
		available.setPreferredSize(new Dimension(120, 40));
		c.gridy = 2;
		frame.add(available, c);		
		
		unavailable.setPreferredSize(new Dimension(120, 40));
		c.gridy = 3;
		frame.add(unavailable, c);
		
		confirm.setPreferredSize(new Dimension(120, 60));
		c.gridy = 4;
		frame.add(confirm, c);
		
		textArea = new JTextArea();
		JScrollPane textScroll = new JScrollPane(textArea);
		textScroll.setPreferredSize(new Dimension(350, 250));
		
		c.gridheight = 5;
		c.gridx = 1;
		c.gridy = 0;
		frame.add(textScroll, c);
				
		frame.pack();
		frame.setVisible(true);
	}

	public void displayMessage(String message) {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		textArea.setText(textArea.getText()+"\n"+sdf.format(cal.getTime())+": "+message);
	}

	public void setState(String state) {
		this.state = state;
		frame.setTitle(id+": "+state);
	}
}