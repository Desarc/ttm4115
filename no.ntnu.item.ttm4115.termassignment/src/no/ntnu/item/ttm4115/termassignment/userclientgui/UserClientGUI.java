package no.ntnu.item.ttm4115.termassignment.userclientgui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import no.ntnu.item.arctis.runtime.Block;

public class UserClientGUI extends Block {

	public final String REQUEST = "REQUEST";
	public final String EXIT = "EXIT";
	public final String CANCEL = "CANCEL";
	
	private JFrame frame;
	private JButton request, cancel;
	private JTextField address;
	private JTextArea confirmation;
	
	private String id;
	
	public void show(String alias) {
		this.id = alias;
		frame = new JFrame(id);
		frame.setBounds(200, 200, 450, 450);
		frame.getContentPane().setLayout(new GridBagLayout());
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
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 2;
		confirmation = new JTextArea();
		confirmation.setEditable(false);
		JScrollPane textScroll = new JScrollPane(confirmation);
		textScroll.setPreferredSize(new Dimension(450, 300));
		frame.add(textScroll, c);
		
		final String defaultText = "Type address...";
		address = new JTextField(defaultText);
		address.setEditable(true);
		address.setPreferredSize(new Dimension(450, 40));
		address.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (address.getText().equals(defaultText)) {
		    		address.setText("");
		    	}
		    }

		    public void focusLost(FocusEvent e) {
		    	if (address.getText().equals("")) {
		    		address.setText(defaultText);
		    	}
		    }
		});
		c.gridy = 1;
		frame.add(address, c);
		
		request = new JButton("Request taxi");
		request.setPreferredSize(new Dimension(225, 40));
		request.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!address.getText().equals(defaultText)) {
					sendToBlock(REQUEST, address.getText());
					address.setText(defaultText);
				}
			}
		});
		c.gridwidth = 1;
		c.gridy = 2;
		frame.add(request, c);
		
		cancel = new JButton("Cancel");
		cancel.setPreferredSize(new Dimension(225, 40));
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendToBlock(CANCEL);
			}
		});
		c.gridx = 1;
		frame.add(cancel, c);
		
		frame.pack();
		frame.setVisible(true);
	}

	public void displayMessage(String message) {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		confirmation.setText(confirmation.getText()+"\n"+sdf.format(cal.getTime())+": "+message);
	}

	public void displayLocation(String location) {
		frame.setTitle(id+": "+location);
	}
}