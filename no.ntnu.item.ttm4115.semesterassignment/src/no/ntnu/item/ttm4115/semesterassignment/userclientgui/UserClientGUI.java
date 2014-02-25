package no.ntnu.item.ttm4115.semesterassignment.userclientgui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	
	private JFrame frame;
	private JButton request;
	private JTextField address;
	private JTextArea confirmation;
	
	private String id;
	
	public void show(String alias) {
		this.id = alias;
		frame = new JFrame(id);
		frame.setBounds(200, 200, 450, 300);
		frame.getContentPane().setLayout(new BorderLayout());
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
		
		confirmation = new JTextArea();
		confirmation.setEditable(false);
		JScrollPane textScroll = new JScrollPane(confirmation);
		textScroll.setPreferredSize(new Dimension(300, 250));
		frame.add(textScroll, BorderLayout.NORTH);
		
		final String defaultText = "Type address...";
		address = new JTextField(defaultText);
		address.setEditable(true);
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
		frame.add(address, BorderLayout.CENTER);
		
		request = new JButton("Request taxi");
		request.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!address.getText().equals(defaultText)) {
					sendToBlock(REQUEST, address.getText());
					address.setText(defaultText);
				}
			}
		});
		frame.add(request, BorderLayout.SOUTH);
		
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