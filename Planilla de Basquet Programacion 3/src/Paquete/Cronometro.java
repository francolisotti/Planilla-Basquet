package Paquete;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cronometro extends JFrame implements Runnable, ActionListener{

	JLabel tiempo;
	Integer minutos = 12 , segundos = 0, milesimas = 0;
	Thread hilo;
	boolean cronometroActivo;
	boolean pausar;
	boolean llegoA0=false;

	public Cronometro()    {
		setTitle("Cronometro");
		setSize( 500, 200 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLayout( new BorderLayout() );

		//Etiqueta donde se colocara el tiempo 
		tiempo = new JLabel( "12:00:000" );
		tiempo.setFont( new Font( Font.SERIF, Font.BOLD, 50 ) );
		tiempo.setHorizontalAlignment( JLabel.CENTER );
		tiempo.setForeground( Color.WHITE );
		tiempo.setBackground( Color.BLACK );
		tiempo.setOpaque( true );

		add( tiempo, BorderLayout.CENTER );

		//Boton iniciar
		JButton btn = new JButton( "Iniciar" );
		btn.addActionListener( this );
		add( btn, BorderLayout.NORTH );

		//Boton reiniciar muestra tiempo inicial
		JButton btnP = new JButton( "Reiniciar" );
		btnP.addActionListener( this );
		add( btnP, BorderLayout.EAST );

		// frena el tiempo
		JButton btnD = new JButton( "Detener" );
		btnD.addActionListener( this );
		add( btnD, BorderLayout.WEST );

		this.setLocationRelativeTo( null );
		setVisible( true );

	}

	public void run()
	{
		String min="", seg="", mil="";
		try {

			while(pausar){
				//Mientras cronometroActivo sea verdadero entonces seguira
				//restando el tiempo
				while( cronometroActivo ) 
				{  
					Thread.sleep( 1 );

					if(milesimas > 0) {
						milesimas=milesimas-1;
					}
					else
					{
						milesimas = 999;
						if(segundos > 0) {
							segundos--;
						}
						else
						{
							segundos = 59;
							if(minutos > 0)
							{
								minutos--;
							}
							else
							{
								reiniciarCronometro();
								llegoA0=true;
							}
						} 
					}


					//Esto solamente es estetica para que siempre este en formato
					//00:00:000
					if( minutos < 10 ) min = "0" + minutos;
					else min = minutos.toString();
					if( segundos < 10 ) seg = "0" + segundos;
					else seg = segundos.toString();
					if( milesimas < 10 ) mil = "00" + milesimas;
					else if( milesimas < 100 ) mil = "0" + milesimas;
					else mil = milesimas.toString();

					//Colocamos en la etiqueta la informacion
					tiempo.setText( min + ":" + seg + ":" + mil );

				}
			}
		}catch(Exception e){System.out.println("Error en el run");}
		//Si llego a 0 se deja en 00:00:000

		tiempo.setText( "12:00:000" );
		if (llegoA0==true)
		{
			tiempo.setText( "00:00:000" );

			llegoA0=false;
			minutos = 12;
			segundos = 0;
			milesimas = 0;

		}
	}

	//Esto es para el boton iniciar y reiniciar
	public void actionPerformed( ActionEvent evt ) 
	{
		Object o = evt.getSource();
		if( o instanceof JButton ) {
			JButton btn = (JButton)o;
			if( btn.getText().equals("Iniciar") ){
				iniciarCronometro();
			}
			if( btn.getText().equals("Reiniciar") ) {
				reiniciarCronometro();
			}
			if( btn.getText().equals("Detener") ) {
				pararCronometro();
			}
		}
	}

	//Iniciar el cronometro poniendo cronometroActivo 
	//en verdadero para que entre en el while
	public void iniciarCronometro() 
	{
		if (cronometroActivo==false) //para que no lo vuelva a iniciar si ya est� iniciado
		{                            //y noacelere el tiempo 
			cronometroActivo = true;
			pausar = true;
			hilo = new Thread( this );
			hilo.start();
		}

	}

	//Esto es para parar el cronometro
	public void pararCronometro()
	{
		cronometroActivo = false;
		pausar = true ;
	}

	//reiniciar el cronometro a tiempo inicial
	public void reiniciarCronometro()
	{
		cronometroActivo = false;
		pausar = false;
		tiempo.setText("12:00:000");
		minutos=12;
		segundos=0;
		milesimas=0;
	}

	public String getTiempoActual()
	{
		return minutos+":"+segundos+":"+milesimas;
	}

	public static void main(String[] args) 
	{
		new Cronometro();
	}

}