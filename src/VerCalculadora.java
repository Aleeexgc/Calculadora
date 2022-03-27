

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VerCalculadora extends JFrame  implements KeyListener{

	private JPanel contentPane;

	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VerCalculadora frame = new VerCalculadora();
					frame.addKeyListener(frame);

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	private JLabel resultado;
	private JButton limpiar, dividir, multiplicar, borrar, decimal
	, igual, num0, num1, num2, num3, num4, num5, num6, num7, num8,
	num9, sumar, restar, raiz, portcent;

	String operacion = "";
	private JLabel resultadoF;

	public VerCalculadora() {
		
//		setOpacity(1);
		setType(Type.POPUP);
		setForeground(Color.BLACK);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setFont(new Font("Arial", Font.BOLD, 15));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		setTitle("                                                 CALCULADORA");
		//		setIconImage(Toolkit.getDefaultToolkit().getImage("icono.png"));
		contentPane = new JPanel();		
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[] {62, 0, 45, 39, 43, 43, 42};
		gbl_contentPane.columnWidths = new int[] {0, 0, 4, 0};
		contentPane.setLayout(gbl_contentPane);

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

				if ("Metal".equals(info.getName())) {

					UIManager.setLookAndFeel(info.getClassName());

					break;
				}
			}

		} catch (Exception e) {

			System.err.println("EHHHHHH que el estilo no funciona revisalo");
		}

		añadirBotones();

		//-----------------------------------------------------------------------

		
		
		num0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="0");

			}


		});

		num1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="1");

			}


		});
		num2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="2");

			}


		});
		num3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="3");

			}


		});

		num4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="4");

			}


		});

		num5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="5");

			}


		});

		num6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="6");

			}


		});

		num7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="7");

			}


		});


		num8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="8");

			}


		});


		num9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="9");

			}


		});
		sumar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion+="+");

			}



		});

		restar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resultado.setText(operacion+="-");

			}
		});

		dividir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resultado.setText(operacion+="/");

			}
		});

		raiz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultado.setText(operacion="");
				resultado.setText(operacion+="√");
				resultadoF.setText("0.0");

			}
		});

		multiplicar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resultado.setText(operacion+="*");

			}
		});

		portcent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resultado.setText(operacion+="%");

			}
		});

		decimal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resultado.setText(operacion+=".");

			}
		});
		borrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String str = operacion;

				if (str.length() > 0){
					str = str.substring(0, str.length()-1);
				} else {

					str = "0";

				}
//				str = str.substring(0, str.length()-1);

				resultado.setText(operacion = str);

			}
		});

		limpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resultado.setText("0.0");

				resultadoF.setText("");

				operacion = "";

			}
		});

		igual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultadoF.setText(operacion = String.valueOf(operar(operacion)));
			}

		});


	}

	public void añadirBotones() {
		// Editar resultado
		resultado = new JLabel("0.0");
		resultado.setBackground(SystemColor.activeCaption);
		resultado.setFont(new Font("Arial", Font.BOLD, 35));
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setOpaque(true);
		GridBagConstraints gbc_resultado = new GridBagConstraints();
		gbc_resultado.weighty = 0.7;
		gbc_resultado.anchor = GridBagConstraints.NORTH;
		gbc_resultado.gridwidth = 4;
		gbc_resultado.fill = GridBagConstraints.BOTH;
		gbc_resultado.gridx = 0;
		gbc_resultado.gridy = 0;
		contentPane.add(resultado, gbc_resultado);

		resultadoF = new JLabel("");
		resultadoF.setForeground(Color.GRAY);
		resultadoF.setBackground(SystemColor.activeCaption);
		resultadoF.setFont(new Font("Arial", Font.BOLD, 40));
		resultadoF.setHorizontalAlignment(SwingConstants.RIGHT);
		resultadoF.setOpaque(true);
		GridBagConstraints gbc_resultadoF = new GridBagConstraints();
		gbc_resultadoF.weighty = 1.0;
		gbc_resultadoF.fill = GridBagConstraints.BOTH;
		gbc_resultadoF.gridwidth = 4;
		gbc_resultadoF.insets = new Insets(0, 0, 5, 0);
		gbc_resultadoF.gridx = 0;
		gbc_resultadoF.gridy = 1;
		contentPane.add(resultadoF, gbc_resultadoF);


		//Editar limpiar	
		limpiar = new JButton("C");
		limpiar.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_limpiar = new GridBagConstraints();
		gbc_limpiar.insets = new Insets(0, 0, 5, 5);
		gbc_limpiar.weighty = 1.0;
		gbc_limpiar.weightx = 1.0;
		gbc_limpiar.fill = GridBagConstraints.BOTH;
		gbc_limpiar.gridx = 0;
		gbc_limpiar.gridy = 2;
		contentPane.add(limpiar, gbc_limpiar);


		//Editar dividir
		dividir = new JButton("÷");
		dividir.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_dividir = new GridBagConstraints();
		gbc_dividir.insets = new Insets(0, 0, 5, 5);
		gbc_dividir.weighty = 1.0;
		gbc_dividir.weightx = 1.0;
		gbc_dividir.fill = GridBagConstraints.BOTH;
		gbc_dividir.gridx = 1;
		gbc_dividir.gridy = 2;
		contentPane.add(dividir, gbc_dividir);


		//Editar multiplicar
		multiplicar = new JButton("X");
		multiplicar.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_multiplicar = new GridBagConstraints();
		gbc_multiplicar.insets = new Insets(0, 0, 5, 5);
		gbc_multiplicar.weighty = 1.0;
		gbc_multiplicar.weightx = 1.0;
		gbc_multiplicar.fill = GridBagConstraints.BOTH;
		gbc_multiplicar.gridx = 2;
		gbc_multiplicar.gridy = 2;
		contentPane.add(multiplicar, gbc_multiplicar);


		//Editar borrar
		borrar = new JButton("←");
		borrar.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_borrar = new GridBagConstraints();
		gbc_borrar.insets = new Insets(0, 0, 5, 0);
		gbc_borrar.weighty = 1.0;
		gbc_borrar.weightx = 1.0;
		gbc_borrar.fill = GridBagConstraints.BOTH;
		gbc_borrar.gridx = 3;
		gbc_borrar.gridy = 2;
		contentPane.add(borrar, gbc_borrar);


		//Editar num7
		num7 = new JButton("7");
		num7.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num7 = new GridBagConstraints();
		gbc_num7.insets = new Insets(0, 0, 5, 5);
		gbc_num7.weighty = 1.0;
		gbc_num7.weightx = 1.0;
		gbc_num7.fill = GridBagConstraints.BOTH;
		gbc_num7.gridx = 0;
		gbc_num7.gridy = 3;
		contentPane.add(num7, gbc_num7);


		//Editar num8
		num8 = new JButton("8");
		num8.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num8 = new GridBagConstraints();
		gbc_num8.insets = new Insets(0, 0, 5, 5);
		gbc_num8.weighty = 1.0;
		gbc_num8.fill = GridBagConstraints.BOTH;
		gbc_num8.weightx = 1.0;
		gbc_num8.gridx = 1;
		gbc_num8.gridy = 3;
		contentPane.add(num8, gbc_num8);


		//Editar num9
		num9 = new JButton("9");
		num9.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num9 = new GridBagConstraints();
		gbc_num9.insets = new Insets(0, 0, 5, 5);
		gbc_num9.weighty = 1.0;
		gbc_num9.fill = GridBagConstraints.BOTH;
		gbc_num9.weightx = 1.0;
		gbc_num9.gridx = 2;
		gbc_num9.gridy = 3;
		contentPane.add(num9, gbc_num9);


		//Editar restar
		restar = new JButton("-");
		restar.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_restar = new GridBagConstraints();
		gbc_restar.insets = new Insets(0, 0, 5, 0);
		gbc_restar.weighty = 1.0;
		gbc_restar.weightx = 1.0;
		gbc_restar.fill = GridBagConstraints.BOTH;
		gbc_restar.gridx = 3;
		gbc_restar.gridy = 3;
		contentPane.add(restar, gbc_restar);


		//Editar num4
		num4 = new JButton("4");
		num4.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num4 = new GridBagConstraints();
		gbc_num4.insets = new Insets(0, 0, 5, 5);
		gbc_num4.weighty = 1.0;
		gbc_num4.weightx = 1.0;
		gbc_num4.fill = GridBagConstraints.BOTH;
		gbc_num4.gridx = 0;
		gbc_num4.gridy = 4;
		contentPane.add(num4, gbc_num4);


		//Editar num5
		num5 = new JButton("5");
		num5.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num5 = new GridBagConstraints();
		gbc_num5.insets = new Insets(0, 0, 5, 5);
		gbc_num5.weighty = 1.0;
		gbc_num5.weightx = 1.0;
		gbc_num5.fill = GridBagConstraints.BOTH;
		gbc_num5.gridx = 1;
		gbc_num5.gridy = 4;
		contentPane.add(num5, gbc_num5);

		//Editar num6
		num6 = new JButton("6");
		num6.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num6 = new GridBagConstraints();
		gbc_num6.insets = new Insets(0, 0, 5, 5);
		gbc_num6.weighty = 1.0;
		gbc_num6.weightx = 1.0;
		gbc_num6.fill = GridBagConstraints.BOTH;
		gbc_num6.gridx = 2;
		gbc_num6.gridy = 4;
		contentPane.add(num6, gbc_num6);


		//Editar sumar
		sumar = new JButton("+");
		sumar.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_sumar = new GridBagConstraints();
		gbc_sumar.insets = new Insets(0, 0, 5, 0);
		gbc_sumar.weighty = 1.0;
		gbc_sumar.fill = GridBagConstraints.BOTH;
		gbc_sumar.weightx = 1.0;
		gbc_sumar.gridx = 3;
		gbc_sumar.gridy = 4;
		contentPane.add(sumar, gbc_sumar);


		//Editar num1
		num1 = new JButton("1");
		num1.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num1 = new GridBagConstraints();
		gbc_num1.insets = new Insets(0, 0, 5, 5);
		gbc_num1.weighty = 1.0;
		gbc_num1.fill = GridBagConstraints.BOTH;
		gbc_num1.weightx = 1.0;
		gbc_num1.gridx = 0;
		gbc_num1.gridy = 5;
		contentPane.add(num1, gbc_num1);


		//Editar num2
		num2 = new JButton("2");
		num2.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num2 = new GridBagConstraints();
		gbc_num2.insets = new Insets(0, 0, 5, 5);
		gbc_num2.weighty = 1.0;
		gbc_num2.weightx = 1.0;
		gbc_num2.fill = GridBagConstraints.BOTH;
		gbc_num2.gridx = 1;
		gbc_num2.gridy = 5;
		contentPane.add(num2, gbc_num2);


		//Editar num3
		num3 = new JButton("3");
		num3.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num3 = new GridBagConstraints();
		gbc_num3.insets = new Insets(0, 0, 5, 5);
		gbc_num3.weighty = 1.0;
		gbc_num3.fill = GridBagConstraints.BOTH;
		gbc_num3.weightx = 1.0;
		gbc_num3.gridx = 2;
		gbc_num3.gridy = 5;
		contentPane.add(num3, gbc_num3);


		//Editar raiz
		raiz = new JButton("√");
		raiz.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_raiz = new GridBagConstraints();
		gbc_raiz.insets = new Insets(0, 0, 5, 0);
		gbc_raiz.weighty = 1.0;
		gbc_raiz.weightx = 1.0;
		gbc_raiz.fill = GridBagConstraints.BOTH;
		gbc_raiz.gridx = 3;
		gbc_raiz.gridy = 5;
		contentPane.add(raiz, gbc_raiz);


		//Editar porcent
		portcent = new JButton("%");
		portcent.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_portcent = new GridBagConstraints();
		gbc_portcent.insets = new Insets(0, 0, 0, 5);
		gbc_portcent.weighty = 1.0;
		gbc_portcent.fill = GridBagConstraints.BOTH;
		gbc_portcent.weightx = 1.0;
		gbc_portcent.gridx = 0;
		gbc_portcent.gridy = 6;
		contentPane.add(portcent, gbc_portcent);


		//Editar num0
		num0 = new JButton("0");
		num0.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_num0 = new GridBagConstraints();
		gbc_num0.insets = new Insets(0, 0, 0, 5);
		gbc_num0.weighty = 1.0;
		gbc_num0.fill = GridBagConstraints.BOTH;
		gbc_num0.weightx = 1.0;
		gbc_num0.gridx = 1;
		gbc_num0.gridy = 6;
		contentPane.add(num0, gbc_num0);


		//Editar decimal
		decimal = new JButton(",");
		decimal.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_decimal = new GridBagConstraints();
		gbc_decimal.insets = new Insets(0, 0, 0, 5);
		gbc_decimal.weighty = 1.0;
		gbc_decimal.weightx = 1.0;
		gbc_decimal.fill = GridBagConstraints.BOTH;
		gbc_decimal.gridx = 2;
		gbc_decimal.gridy = 6;
		contentPane.add(decimal, gbc_decimal);


		//Editar igual
		igual = new JButton("=");
		igual.setFont(new Font("Arial", Font.BOLD, 30));
		GridBagConstraints gbc_num4_1_3 = new GridBagConstraints();
		gbc_num4_1_3.weightx = 1.0;
		gbc_num4_1_3.weighty = 1.0;
		gbc_num4_1_3.fill = GridBagConstraints.BOTH;
		gbc_num4_1_3.gridx = 3;
		gbc_num4_1_3.gridy = 6;
		contentPane.add(igual, gbc_num4_1_3);

	}

	private Double operar(String op) {

		int pos = op.indexOf('+') ;

		if (pos != -1 && !op.contains("%")) {

			if (op.charAt(0) == '-') {

				return -operar(op.substring(1,pos)) + operar(op.substring(pos+1)); 

			} else {
				return operar(op.substring(0,pos)) + operar(op.substring(pos+1)); 

			}
			
		} else  {

			pos = op.indexOf('-') ;

			if (pos != -1 && !op.contains("%")) {

				if (pos == 0 && !op.contains("*") && !op.contains("/")) { // Comprueba que el primer numero sea negativo y NO haya operaciones de multiplicacion o division despues

					return -operar(op.substring(1,op.lastIndexOf('-'))) - operar(op.substring(op.lastIndexOf('-')+1)); // Devuelve la operacion excluyendo el primer - y se coloca a la hora de calcularlo

				} else  if (op.charAt(0) == '-') { // Comprueba que el primer numero sea negativo y SI haya operaciones de multiplicacion o division despues

					if (op.contains("*")) { // Comprueba que hay multiplicacion

						pos = op.indexOf('*') ;

						if (op.contains("*-")) { // Comprueba que hay concatenacion de signos

							return -operar(op.substring(1,pos)) * -operar(op.substring(pos+2));  // Devuelve el resultado ignorando los signos que hacen negativos a los valores y se colocan al calcularlos

						} else {

							return -operar(op.substring(1,pos)) * operar(op.substring(pos+1));  // Devuelve el resultado de una multiplicacion con el primer numero negativo

						}

					} else { // Lo mismo que lo anterior pero con divisiones
						
						pos = op.indexOf('/') ; 

						if (op.contains("/-")) {

							return -operar(op.substring(1,pos)) / -operar(op.substring(pos+2)); 

						} else {

							return -operar(op.substring(1,pos)) / operar(op.substring(pos+1)); 

						}
					}


				} else { // Operaciones similares a las anteriores pero sin que el primer numero sea negativo

					if (op.contains("*-")) {

						pos = op.indexOf('*') ;

						return operar(op.substring(0,pos)) * -operar(op.substring(pos+2)); 

					} else if (op.contains("/-")) {

						pos = op.indexOf('/') ;

						return operar(op.substring(0,pos)) / -operar(op.substring(pos+2)); 

					} else { // Esta es una resta normal que acepta la concatenacion de estas

						return operar(op.substring(0,op.lastIndexOf('-'))) - operar(op.substring(op.lastIndexOf('-')+1)); 

					}


				} 

			} else  {

				pos = op.indexOf('*') ;

				if (pos != -1 && !op.contains("-")) {

					return operar(op.substring(0,pos)) * operar(op.substring(pos+1)); 

				} else  {

					pos = op.indexOf('/');

					if (pos != -1 && !op.contains("-")) {

						return operar(op.substring(0,pos)) / operar(op.substring(pos+1)); 

					} else {

						pos = op.indexOf('√');

						if (pos != -1) {

							return Math.sqrt(operar(op.substring(pos+1)));

						} else {

							int pos1;
							pos = op.indexOf('%');

							double resultado;

							if (pos != -1) {

								if (op.contains("-")) {

									pos1 = op.indexOf('-');

									resultado = Double.parseDouble((op.substring(0, pos1))) * ( Double.parseDouble(op.substring(pos1+1, pos)) /100);

									return resultado=Double.parseDouble((op.substring(0, pos1))) - resultado; 

								} else if (op.contains("+")) {

									pos1 = op.indexOf('+');

									resultado = Double.parseDouble((op.substring(0, pos1))) * ( Double.parseDouble(op.substring(pos1+1, pos)) /100);

									return resultado=Double.parseDouble((op.substring(0, pos1))) + resultado; 

								} else {

									return 	resultado = Double.parseDouble((op.substring(0, pos))) * ( Double.parseDouble(op.substring(pos+1)) /100);

								}

							}
						}
					}
				}
			}


		}

		return Double.parseDouble(op);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		resultado.setText(operacion+=e.getKeyChar());
	}


}
