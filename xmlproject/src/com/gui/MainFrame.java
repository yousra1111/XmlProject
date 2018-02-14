package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sql.rowset.spi.XmlReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.svg.SvgWriter;
import com.xml.XmlException;
import com.xml.XmlWriter;

public class MainFrame extends JFrame {
	private JPanel menuPanel=new JPanel();
	private PaintPanel paintPanel;
	public  MainFrame() {
		paintPanel=new PaintPanel(this);
		JButton convertToXmlBtn=new JButton("convertir en XML");
		JButton convertToSvgBtn=new JButton("convertir en SVG");
		JButton clear =new JButton("CLEAR");
		menuPanel.add(convertToXmlBtn,RIGHT_ALIGNMENT);
		menuPanel.add(convertToSvgBtn,RIGHT_ALIGNMENT);
		menuPanel.add(clear,LEFT_ALIGNMENT);
		add(menuPanel,BorderLayout.SOUTH);
		paintPanel.setBackground(new Color(160,160,160));
		add(paintPanel);
		//traitment btn
		convertToSvgBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SvgWriter svgWriter=new SvgWriter(); 
				try {
					svgWriter.convert(paintPanel.getSegments());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		convertToXmlBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				XmlWriter xmlWriter=new XmlWriter();
				try {
					xmlWriter.convert(paintPanel.getSegments());
					JOptionPane.showMessageDialog(null, "fichier xml est cree correctement","ok",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(XmlException e1) {
					JOptionPane.showMessageDialog(null, "fichier xml n'est pas  cree correctement","message d'erreur",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
	
clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					paintPanel.repaint();
					paintPanel.getSegments().clear();
			}
		});
			
		//app
		setTitle ("Application XML" );
		setSize(750,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new MainFrame();
	}

}
