package com.cronometro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VP extends JFrame implements ActionListener {

	PanelCrono pi;
	
	public VP() {
		setTitle("Cronómetro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		JPanel ps = new JPanel();
		add(ps, BorderLayout.NORTH);
		JButton b1 = new JButton("Iniciar");
		b1.setActionCommand("B1");
		b1.addActionListener(this);
		ps.add(b1);
		JButton b2 = new JButton("Detener");
		b2.setActionCommand("B2");
		b2.addActionListener(this);
		ps.add(b2);
		pi = new PanelCrono();
		pi.setPreferredSize(new Dimension(200, 200));
		add(pi, BorderLayout.SOUTH);
		pack();
	}
	
	public static void main(String[] args) {
		VP crono = new VP();
		crono.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("B1")) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("Iniciar")) {
				b.setText("Pausa");
				pi.iniciarCrono();
			}
			else if (b.getText().equals("Pausa")) {
				b.setText("Reanudar");
				pi.pausarCrono();
			}
			else if (b.getText().equals("Reanudar")) {
				b.setText("Pausa");
				pi.reanudarCrono();
			}
		}
		else if (e.getActionCommand().equals("B2")) {
			
		}
	}

}
