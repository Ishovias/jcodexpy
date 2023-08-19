package com.JCodexpy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class JCodexpyWindow {

	private JFrame frmJcodexpy;
	private JTextField txtResultado;
	private JButton botonCodificar;
	private JButton botonCopiar;
	private JButton botonSalir;
	private JTextField fraseIngreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCodexpyWindow window = new JCodexpyWindow();
					window.frmJcodexpy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JCodexpyWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJcodexpy = new JFrame();
		frmJcodexpy.setTitle("JCodexpy (by Isho)");
		frmJcodexpy.setBounds(100, 100, 450, 216);
		frmJcodexpy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJcodexpy.getContentPane().setLayout(null);
		
		JLabel etiquetaIngreso = new JLabel("Ingresa palabra o frase-->");
		etiquetaIngreso.setBounds(10, 28, 152, 14);
		frmJcodexpy.getContentPane().add(etiquetaIngreso);
		
		fraseIngreso = new JTextField();
		fraseIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String frase = fraseIngreso.getText();
				
				Encriptador encriptador = new Encriptador();
				encriptador.codifica(frase);
				String resultado = encriptador.getCodificado();
				
				txtResultado.setText(resultado);
			}
		});
		fraseIngreso.setBounds(172, 25, 252, 20);
		frmJcodexpy.getContentPane().add(fraseIngreso);
		fraseIngreso.setColumns(10);
		
		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtResultado.setText("Resultado");
		txtResultado.setBounds(172, 56, 252, 105);
		frmJcodexpy.getContentPane().add(txtResultado);
		txtResultado.setColumns(10);
		
		botonCodificar = new JButton("Codificar");
		botonCodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String frase = fraseIngreso.getText();
				
				Encriptador encriptador = new Encriptador();
				encriptador.codifica(frase);
				String resultado = encriptador.getCodificado();
				
				txtResultado.setText(resultado);
			}
		});
		botonCodificar.setBounds(10, 56, 152, 37);
		frmJcodexpy.getContentPane().add(botonCodificar);
		
		botonCopiar = new JButton("Copiar");
		botonCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String textoCodificado = txtResultado.getText();
				
				CopiadorTexto copiadorTexto = new CopiadorTexto();
				copiadorTexto.copiar(textoCodificado);
				
			}
		});
		botonCopiar.setBounds(10, 104, 152, 23);
		frmJcodexpy.getContentPane().add(botonCopiar);
		
		botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); //salir
			}
		});
		botonSalir.setBounds(10, 138, 152, 23);
		frmJcodexpy.getContentPane().add(botonSalir);
	}
}
