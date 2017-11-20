package com.cronometro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Crono extends JFrame implements ActionListener {
	
	private JButton b1, b2;
	
	public Crono() {
		setTitle("Cronometro");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		JPanel ps = new JPanel();
		add(ps, BorderLayout.NORTH);
		b1 = new JButton("Iniciar");
		b1.addActionListener(this);
		b1.setActionCommand("B1");
		ps.add(b1);
		b2 = new JButton("Detener");
		b2.addActionListener(this);
		b2.setActionCommand("B2");
		ps.add(b2);
		PanelCrono pi = new PanelCrono();
		pi.setPreferredSize(new Dimension(200, 200));
		add(pi, BorderLayout.SOUTH);
		this.pack();
				
	}
	public static void main(String[] args) {
		Crono crono = new Crono();
		crono.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("B1")) {
			
		}
		else if (e.getActionCommand().equals("B2")) {
			
		}
//		if((JButton) e.getSource() == b1) {
//			
//		}
//		else if((JButton) e.getSource() == b2) {
//			
//		}
	}
}
