package Ventanas;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import Ventanas.Darsedebaja.EventoAtrasDarsedebaja;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Hipoteca extends JFrame {

	private JPanel contentPane;
	private JTextField texto_valor;
	private JTextField texto_dinero_necesitar;
	private JTextField texto_tiempo;
	private JTextField texto_TAE;
	private JTextField texto_total;
	private JButton btnRealizar;
	//La ruta para la conexion
	String ruta=Conexion.HacerConexion();
	private int valorvi;
	private int dinerone;
	private int tiempode;
	private int dineromax;
	private double total;
	private String total2;
	public Hipoteca() {
		//Pantalla de Hipoteca
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 430, 423);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel Hipoteca = new JLabel("Hipoteca");
			Hipoteca.setFont(new Font("Tahoma", Font.PLAIN, 20));
			Hipoteca.setBounds(160, 22, 106, 32);
			contentPane.add(Hipoteca);
			
			JLabel Valor = new JLabel("Valor de la vivienda:");
			Valor.setBounds(35, 108, 122, 22);
			contentPane.add(Valor);
			
			texto_valor = new JTextField();
			texto_valor.setHorizontalAlignment(SwingConstants.RIGHT);
			texto_valor.setBounds(186, 109, 122, 20);
			contentPane.add(texto_valor);
			texto_valor.setColumns(10);
			
			JLabel label = new JLabel("€");
			label.setBounds(310, 108, 29, 22);
			contentPane.add(label);
			
			JLabel lblCuantoDineroNecesitas = new JLabel("Cuanto dinero necesitas:");
			lblCuantoDineroNecesitas.setBounds(35, 152, 150, 22);
			contentPane.add(lblCuantoDineroNecesitas);
			
			texto_dinero_necesitar = new JTextField();
			texto_dinero_necesitar.setHorizontalAlignment(SwingConstants.RIGHT);
			texto_dinero_necesitar.setColumns(10);
			texto_dinero_necesitar.setBounds(186, 153, 122, 20);
			contentPane.add(texto_dinero_necesitar);
			
			JLabel label_2 = new JLabel("€");
			label_2.setBounds(310, 152, 29, 22);
			contentPane.add(label_2);
			
			JLabel lblTiempoParaDevolcer = new JLabel("Tiempo para devolver:");
			lblTiempoParaDevolcer.setBounds(35, 195, 150, 22);
			contentPane.add(lblTiempoParaDevolcer);
			
			texto_tiempo = new JTextField();
			texto_tiempo.setHorizontalAlignment(SwingConstants.RIGHT);
			texto_tiempo.setColumns(10);
			texto_tiempo.setBounds(186, 196, 122, 20);
			contentPane.add(texto_tiempo);
			
			JLabel laños = new JLabel("Años");
			laños.setBounds(311, 195, 60, 22);
			contentPane.add(laños);
			
			JLabel label_1 = new JLabel("T.A.E:");
			label_1.setBounds(133, 228, 44, 22);
			contentPane.add(label_1);
			
			texto_TAE = new JTextField();
			texto_TAE.setHorizontalAlignment(SwingConstants.CENTER);
			texto_TAE.setEnabled(false);
			texto_TAE.setText("2.49%");
			texto_TAE.setToolTipText("");
			texto_TAE.setColumns(10);
			texto_TAE.setBounds(186, 227, 122, 20);
			contentPane.add(texto_TAE);
			
			texto_total = new JTextField();
			texto_total.setEnabled(false);
			texto_total.setHorizontalAlignment(SwingConstants.RIGHT);
			texto_total.setColumns(10);
			texto_total.setBounds(200, 331, 140, 20);
			contentPane.add(texto_total);
			
			JLabel lblTotal = new JLabel("Total:");
			lblTotal.setBounds(160, 330, 34, 22);
			contentPane.add(lblTotal);
			
			JLabel lblmes = new JLabel("€/mes");
			lblmes.setBounds(352, 330, 52, 22);
			contentPane.add(lblmes);
			
			JButton btnCalcular = new JButton("Calcular");
			btnCalcular.setBounds(33, 282, 99, 32);
			btnCalcular.addActionListener(new EventoCalcular());
			contentPane.add(btnCalcular);
			
			btnRealizar = new JButton("Realizar");
			btnRealizar.setBounds(200, 282, 89, 32);
			btnRealizar.addActionListener(new EventoRealizar());
			btnRealizar.setEnabled(false);
			contentPane.add(btnRealizar);
			
			
			JButton Atras = new JButton("Volver");
			Atras.addActionListener(new EventoAtras());
			Atras.setBounds(33,350,99,33);
			contentPane.add(Atras);
			
			ImageIcon pantallac = new ImageIcon("Imagenes"+File.separator+"hipoteca-portada-illustracion.png");
			JLabel miEtiqueta = new JLabel(pantallac);
			miEtiqueta.setBounds(0, 0,430,423);
			contentPane.add(miEtiqueta);
			
			
			setLocationRelativeTo(null);
			setResizable(false);
			setUndecorated(true);
			getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
	}
	public class EventoAtras implements ActionListener{
		public void actionPerformed (ActionEvent e){
			//Evento que sirve para volver a la pantalla de Vetanilla
			Ventanilla atras = new Ventanilla();
			atras.setVisible(true);
			dispose();
		}
	}
	public class EventoRealizar implements ActionListener{
		public void actionPerformed (ActionEvent e){
			//Evento que sirve para realizar la Hipoteca
			Ventanilla atras = new Ventanilla();
			valorvi=Integer.parseInt(texto_valor.getText());
			dinerone=Integer.parseInt(texto_dinero_necesitar.getText());
			tiempode=Integer.parseInt(texto_tiempo.getText());
			dineromax=(valorvi*80)/100;
			if(dineromax<dinerone) {
				JOptionPane.showMessageDialog(null,"El dinero que necesitas no puede ser superior al valor de la vivienda");
			}
			else{
				int meses=tiempode*12;
				double dineroinp=dinerone+((dinerone*2.49)/100);
				total=dineroinp/meses;
				total2=Double.toString(total);
				texto_total.setText(total2);
			try {
				Conexion.RealizarHipoteca(ruta,total);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"Se ha realizado la hipoteca correctamente se le cobrara "+total2+"€ al mes");
			atras.setVisible(true);
			dispose();
		}
		}
	}
	public class EventoCalcular implements ActionListener{
		public void actionPerformed (ActionEvent e){
			//Evento que sirve para calcular el dinero minimo que necesitas
			valorvi=Integer.parseInt(texto_valor.getText());
			dinerone=Integer.parseInt(texto_dinero_necesitar.getText());
			tiempode=Integer.parseInt(texto_tiempo.getText());
			dineromax=(valorvi*80)/100;
			if(dineromax<dinerone) {
				JOptionPane.showMessageDialog(null,"El dinero que necesitas no puede ser superior al 80% del valor de la vivienda");
			}
			else{
				int meses=tiempode*12;
				double dineroinp=dinerone+((dinerone*2.49)/100);
				total=dineroinp/meses;
				total2=Double.toString(total);
				texto_total.setText(total2);
				btnRealizar.setEnabled(true);
			}
		}
	}
			
}