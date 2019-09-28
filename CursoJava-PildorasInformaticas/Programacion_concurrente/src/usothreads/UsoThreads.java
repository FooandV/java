package usothreads;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 * @author freyder
 * 
 * crear Hilos de ejecucion:
 * pasos:
 * 1. crear clase que implemente la interfaz Runnable(metodo run())
 * 2. escribir el código de la tarea dentro del metodo run()
 * 3. instanciar la clase creada y almacenar la instancia en variable de
 * tipo Runnable
 * 4. crear instancia de la clase Thread pasando como parámetro al constructor
 * de Thread el objeto Runnable anterior
 * 5. Poner en marcha el hilo de ejecución con el método start() de la clase Thread
 *
 */
public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}
/**paso:1
 * clase PelotaHilos: clase que implementa la interfaz Runnable y construye el metodo run()*/
class PelotaHilos implements Runnable{
	/**
	 * constructor:recibe un argumento de tipo Pelota y el segundo argumento es
	 * el componente donde la pelota va rebotar, concretamente va recibir la
	 * lamina de tipo Component
	 */
	public PelotaHilos(Pelota unaPelota, Component unComponente){/* */
		
		pelota=unaPelota;
		componente= unComponente;
		
	}
	
	/**paso 2:
	 * Metodo run()
	 * Este metodo es el que contiene el código de la tarea que sea simultanea*/
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
		/**validacion con metodo sleep()*/
//		for (int i=1; i<=3000; i++){
		
		/**
		 * validacion de interrupcion de hilo con metodo de clase interrupted()
		 * mientras no haya sido interrumpido el hilo. el metodo de clase
		 * interrupted(): chequea si el hilo actual ha sido interrumpido,
		 * chequea a cualquier instancia que necesite interrumpir un hilo
		 */
		while (!Thread.interrupted()){ 
		/**
		 * validacion de interrupcion de hilo con metodo isInterrupted()currentThread(); el
		 * Devuelve una referencia al objeto de la secuencia actualmente en ejecución
		 * 
		 */	
//		while (!Thread.currentThread().isInterrupted()){
		
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			
			try { 
				Thread.sleep(4);/*haciendo una pausa de 4 milisegundos*/
			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
////				e.printStackTrace();
//					System.out.println("hilo bloqueado, imposible su interrepcion");
////				System.exit(0);/*con esto al pulsar sobre el boton detener se saldra de la aplicacion*/
					Thread.currentThread().interrupt();
			
			}
		}
		System.out.println("Estado del hilo al terminar: " + Thread.currentThread().isInterrupted());
	
	}
	
	/**campo de clase: pelota; de tipo Pelota*/
	private Pelota pelota;
	/**campo de clase: componente; de tipo Component*/
	private Component componente;
	
}




//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
	
	// Mueve la pelota invirtiendo posición si choca con límites
	
	public void mueve_pelota(Rectangle2D limites){
		/**con las siguientes instrucciones conseguimos que la pelota se vaya moviendo en las coordenadas x y: */
		x+=dx;//incrementa la coordenada x
		y+=dy;//incrementa la coordenada y
		/*********************************************************************************************************/
		
		if(x<limites.getMinX()){/*getMinX() Devuelve la coordenada (X) más pequeña del rectángulo.*/ 
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){/*getMaxX() Devuelve la mayor coordenada (X) del rectángulo*/
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;/*cuando nos encontramos con los limites invertimos las coordenadas x*/
		}
		
		if(y<limites.getMinY()){/* Devuelve la mayor coordenada X del rectángulo*/
			
			y=limites.getMinY();
			
			dy=-dy; /*cuando nos encontramos con los limites invertimos las coordenadas y*/
		}
		
		if(y + TAMY>=limites.getMaxY()){/*Devuelve la mayor coordenada (Y) del rectángulo*/
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posición inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;//cordenada x
	
	private double y=0;//coordenada y
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lámina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lámina y botones------------------------------------------------------------------------------
/**clase que construye el marco*/
class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(600,300,600,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		/**se construyen los botones, poniendolos a la escucha y con su respectiva llamada de eventos
		 * con el metodo actionPerformed():*/
		
		arranca1=new JButton("hilo1");
		
		arranca1.addActionListener(new ActionListener() {/*poniendo el boton a la escucha para que 
		al pulsar sobre el ejecute la correspondiente accion*/
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comienza_el_juego(e);/*se pone el argumento "e" =evento, el cual permitira ser capaz averiguar
				cual boton es el elegido*/
			}
		});
		laminaBotones.add(arranca1);/*agregando el boton a la lamina*/
		//--------------------------------------------
		arranca2=new JButton("hilo2");
		arranca2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comienza_el_juego(e);
			}
		});
		laminaBotones.add(arranca2);/*agregando el boton a la lamina*/
		//-------------------------------------------
		arranca3=new JButton("hilo3");
		arranca3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comienza_el_juego(e);
			}
		});
		laminaBotones.add(arranca3);/*agregando el boton a la lamina*/
		//--------------------------------------------
		detener1=new JButton("detener1");
		detener1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				detener(evento);
			}
		});
		laminaBotones.add(detener1);/*agregando el boton a la lamina*/
		//--------------------------------------------
		detener2=new JButton("detener2");
		detener2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				detener(evento);
			}
		});
		laminaBotones.add(detener2);/*agregando el boton a la lamina*/
		//--------------------------------------------
		detener3=new JButton("detener3");
		detener3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				detener(evento);
			}
		});
		laminaBotones.add(detener3);/*agregando el boton a la lamina*/
		
		
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
		
	
	
	//Añade pelota y la bota 1000 veces
	
	/**Metodo encargada de comenzar la ejecucion del hilo:
	 * el metodo es capaz de diferenciar que boton hemos pulsado
	 * el objeto e de tipo ActionEvent nos va permitir averiguar que boton hemos pulsado*/
	public void comienza_el_juego (ActionEvent e){
					
			Pelota pelota=new Pelota();
			lamina.add(pelota);
			
		/**
		 * paso 3: instanciar la clase creada y almacenar la instancia en
		 * variable de tipo Runnable
		 */
			Runnable r=new PelotaHilos(pelota, lamina);
		/**
		 * paso 4:crear instancia de la clase Thread pasando como parámetro al
		 * constructor
		 */
		if(e.getSource().equals(arranca1)){	
			t1=new Thread(r);/*crea instancia t1*/
			
		/**
		 * 5. Poner en marcha el hilo de ejecución con el método start() de la
		 * clase Thread
		 */
			t1.start();
		}else if(e.getSource().equals(arranca2)){
			t2=new Thread(r);
			t2.start();
			
		}else if(e.getSource().equals(arranca3)){
			t3=new Thread(r);
			t3.start();
		}
	}
	
	/**metodo que detiene la ejecución de un hilo*/
	public void detener(ActionEvent evento){
		
		//t.stop();/*metodo obsoleto por la API Java*/
		if(evento.getSource().equals(detener1)){
			t1.interrupt();//solicitud de detencion del hilo1
		}else if(evento.getSource().equals(detener2)){
			t2.interrupt();//solicitud de detencion del hilo2
		}else if(evento.getSource().equals(detener3)){
			t3.interrupt();//solicitud de detencion del hilo3
		}
	}
	
	
	/**Campo de clase: lamina; de tipo LaminaPelota*/
	private LaminaPelota lamina;
	/**campo de clase: t, de tipo Thread*/
	private Thread t1,t2,t3;/*creacion de 3 hilos independientes*/
	/**creacion de botones*/
	JButton arranca1,arranca2,arranca3, detener1, detener2, detener3;
	
	
	
}

