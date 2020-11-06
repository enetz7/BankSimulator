package Ventanas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import Ventanas.LoginVentanilla.InicioSesion;
import java.time.LocalDate;
import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
public class CrearCuenta1 extends JFrame{
	private JLabel DNI,Nombre,Apellido,FechaNa,Dire,titulo,fechas,Tipo;
	private JComboBox combo;
	public JButton boton1,boton2;
	public JTextField textArea1,textArea2,textArea3;
	public JFormattedTextField textArea4;
	public JTextField textArea5; 
	int suma=0;
	int [] sumador3= {6,3,7,9,10,5,8,4,2,1};
	int resultado;
	int suma2;
	int digitoControl;
	private int numero,numero2;
	//La ruta para la conexion
	String ruta=Conexion.HacerConexion();
public CrearCuenta1() {
	//Ventana de Crear Cuenta
	setTitle("Crear Cuenta");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0,0,650,500);
	JPanel miPanel=new JPanel();
	miPanel.setLayout(null);
	setContentPane(miPanel);
	titulo= new JLabel("Crear Cuenta");
	titulo.setBounds(170,-140,380,380);
	titulo.setFont(new Font("Courier New", Font.ITALIC,40));
	miPanel.add(titulo);
	DNI=new JLabel("DNI: ");
	DNI.setBounds(40,20,200,200);
	miPanel.add(DNI);
	Nombre= new JLabel("Nombre: ");
	Nombre.setBounds(40,60,200,200);
	miPanel.add(Nombre);
	Apellido=new JLabel("Apellido: ");
	Apellido.setBounds(40,100,200,200);
	miPanel.add(Apellido);
	FechaNa=new JLabel("Fecha Nacimiento: ");
	FechaNa.setBounds(40,140,200,200);
	miPanel.add(FechaNa);
	fechas=new JLabel("(yyyy-mm-dd)");
	fechas.setBounds(40,160,200,200);
	fechas.setForeground(Color.BLUE);
	miPanel.add(fechas);
	Dire=new JLabel("Dirección: ");
	Dire.setBounds(40,180,200,200);
	miPanel.add(Dire);
	Tipo=new JLabel("Tipo: ");
	Tipo.setBounds(40,220,200,200);
	miPanel.add(Tipo);
	combo=new JComboBox();
	combo.addItem("Cuenta bancaria");
	combo.addItem("Cuenta de ahorro");
	combo.addItem("Cuenta nómina");
	combo.addItem("Cuenta de valores");
	combo.setBounds(200,310,200,20);
	miPanel.add(combo);
	textArea1= new JTextField();
	textArea1.setBounds(200,110,200,20);
	miPanel.add(textArea1);
	textArea2= new JTextField();
	textArea2.setBounds(200,150,200,20);
	miPanel.add(textArea2);
	textArea3= new JTextField();
	textArea3.setBounds(200,190,200,20);
	miPanel.add(textArea3);
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	textArea4 = new JFormattedTextField(df);
	textArea4.setBounds(200,230,200,20);
	miPanel.add(textArea4);
	textArea5= new JTextField();
	textArea5.setBounds(200,270,200,20);
	miPanel.add(textArea5);
	boton1=new JButton("Crear Cuenta");
	boton1.setBounds(450,400,160,50);
	boton1.addActionListener(new CrearCuenta());
	miPanel.add(boton1);
	boton2=new JButton("Volver");
	boton2.setBounds(35,400,160,50);
	boton2.addActionListener(new VolverAtras());
	miPanel.add(boton2);
	ImageIcon fondo= new ImageIcon("Imagenes"+File.separator+"Login.jpg");
	JLabel miEtiqueta= new JLabel(fondo);
	miEtiqueta.setBounds(0, 0,650,500);
	miPanel.add(miEtiqueta);
	setLocationRelativeTo(null);
	setResizable(false);
	setUndecorated(true);
	getRootPane().setWindowDecorationStyle(JRootPane.NONE);
}
public class CrearCuenta implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		//Evento que sirve para generar Cuenta
		try {
			String dni=textArea1.getText();
			String nombre=textArea2.getText();
			String apellido=textArea3.getText();
			String fecha=textArea4.getText();
			String direccion=textArea5.getText();
			String tipo=combo.getSelectedItem().toString();
			numero=NumeroRandomCuenta()*10;
			numero2=NumeroRandomPin()*10;
			String numCuenta="ES71003020530"+CrearNumeroControl(numero)+numero;
			numCuenta.replace("-", "");
			int pin=numero2;
			Conexion.CrearCuenta(dni,nombre,apellido,fecha,direccion,numCuenta,tipo,pin,ruta);
		}catch(SQLException e1){
			e1.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException eu) {
			JOptionPane.showMessageDialog(null,"Ese usuario ya existe ");
		}
	}
}
public class VolverAtras implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		//Evento que sirve volver a la pantalla de login de Ventanilla
		LoginVentanilla vent=new LoginVentanilla();
		vent.setVisible(true);
		dispose();
	}
}
public int NumeroRandomCuenta() {
	//Metodo que sirve para crear un numero de cuenta aleatorio
	int random1=(int)Math.floor((Math.random()*899999999+100000000));
	return random1;
}
public int NumeroRandomPin() {
	//Metodo que sirve para crear un PIN aleatorio
	int random2=(int)Math.floor((Math.random()*899+100));
	return random2;
}
public int CrearNumeroControl(int numero) {
	//Metodo que sirve para generar bien el Numero de Control
	int resultado=0;suma=0;digitoControl=0;suma2=0;
	int i=0;
	while(numero!=0) {
		resultado=numero%10;
		numero=numero/10;
		suma=suma+(resultado*sumador3[i]);
		i++;
		suma2=suma%11;
		digitoControl=11-suma2;
	}
	return digitoControl;
}
}