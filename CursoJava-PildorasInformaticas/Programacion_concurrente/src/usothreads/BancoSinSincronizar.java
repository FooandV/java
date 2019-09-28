package usothreads;

import java.util.concurrent.locks.*;


/**
 * @author freyder
 *Aplicacion Java que va construir un Banco
 *en el banco se van abrir 100 cuentas corrientes
 *va cargar cada una de esas cuentas corrientes con un saldo inicial de 2000$
 *el saldo total siempre sera: cuentas 2000*100=200.000$
 *el programa se va a encargar de realizar transferencias entre las cuentas  
 *Cada transferencia interna de cada cuenta la va realizar un hilo()Thread,
 *Cuando se realicen transferencias internas de una cuenta a otra el saldo de la cuentaOrigen debe ser modificado, si no se
 *modifica el saldo en las otras cuentas debe ser constante osea el mismo  
 */
public class BancoSinSincronizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Banco b=new Banco();
		
		for(int i=0; i<100; i++){
			
			EjecucionTransferencias r= new EjecucionTransferencias(b, i, 2000);/*parametros del constructor b=canco, i= cuentaOrigen de la 
			que parte la transferencia a cada vuelta de bucle, cuentaOrigen 1,2,3....99; 2000=cantidadMax permitida a transferir*/
			
			Thread t= new Thread(r);
			
			t.start();
			
		}
	}

}
/**esta clase crea 100 cuentas corrientes
 * carga cada una de esas cuentas con 2000$*/
class Banco{
	
	/**constructor: */ 
	public Banco(){
		/**
		 * cuenta: 
		 * nota: cabe destacar que las cuentas corrientes van ha ser
		 * identificadas por un numero: 0,1,2,3,4,5.....99
		 */
		cuentas=new double[100];
		
		/**cargando cada una de las cuentas con 2000$*/
		for (int i=0; i<cuentas.length; i++){
			
			cuentas[i]=2000;
		}
		
//		saldoSuficiente= cierreBanco.newCondition();//con esto se le esta diciendo que el bloqueo: cierreBanco tiene que establecerse de acuerdo
		//a una condicion
	}
	
	/** metodo: transferencia; que realice las transferecias, el metodo necesita manejar
	 * cuenta de oritgen, cuenta destino, cantidad de dinero a transferir
	 * los hilos estan sincronizados, cada que un hilo ingrese a ejecutar el codigo del metodo este se bloquea a travez del metodo:lock() que
	 * pertenece a la interfaz 
	 * @throws InterruptedException */
	public  void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad){
		
		cierreBanco.lock();//bloquea el codigo para que no entre otro hilo
		
		try{
			if(cuentas[cuentaOrigen]<cantidad){/*este condicional evalua si la cantidada de la cuenta origen es inferior
//			a la cantidad de dinero que queremos transferir*/
				System.out.println("---CANTIDAD INSUFICIENTE: " + "cuentaOrigen: "+ cuentaOrigen + "... SALDO_cuentaOrigen: " + cuentas[cuentaOrigen] + "..." + "Cantidad a transferir: "+cantidad);
			
			
//			while(cuentas[cuentaOrigen]<cantidad){
					
						return; /*para que retorne el flujo de ejecucion del programa a donde se hizo la llamada al metodo transferencia*/
						
//					saldoSuficiente.await();/*esto permanece el hilo a la espera*/
				
//					wait();/*el hilo se pone a la espera*/
							
					}else{
						System.out.println("----CANTIDAD OK ---- " + cuentaOrigen);
					}
					
					System.out.println("hilo #:"+Thread.currentThread());/*con esto conseguimos que imprima en pantalla el hilo que va realizar la transferencia*/
				
					/*realizando transferencia: descontando a cuentaOrigen, la cantidad que queremos transferir*/
					cuentas[cuentaOrigen]-=cantidad;//dinero que sale de la cuenta origen
					
					System.out.printf("%10.2f de  cuentaOrigen:%d , para cuentaDestino:%d", cantidad, cuentaOrigen, cuentaDestino);//imprimiendo la cantidad con 2 decimales, 
					//de cuentaOrigen para cuentaDestino
					
					cuentas[cuentaDestino]+=cantidad;//incrementa la cantidad que se quito en la cuentaOrigen en cuentaDestino
					
					System.out.printf(" saldo total: %10.2f%n", getSaldoTotal());// imprimiendo el saldo total de las cuentas, dandole formato
					
//					saldoSuficiente.signalAll();//este metodo despierta a todos los hilos que estan a la espera para informarles su transaccion
					
//					notifyAll();//informara todos los hilos que esten a la espera de que se pueden ejecutar y que vuelvan a revisar la condicion
				 }	
			finally{
					 cierreBanco.unlock();//desbloquea el código para que empiece otro hilo a ejecutar el mismo metodo transferencia()
					}
	}
	
			
	/**
	 * metodo getSaldoTotal() permite obtener la suma del saldo de cada una de
	 * las cuentas, es decir el saldo total del Banco
	 */
	public double getSaldoTotal() {

		double suma_cuentas = 0;

		for (double a : cuentas) {// bucle foreach: va recorriendo el cuentas[]
									// y va asignando cada valor de cada
									// posicion en a

			suma_cuentas += a; /*
								 * suma_centas: almacena la suma de las cuentas
								 * alojadas en el array cuentas[]
								 */
		}
		return suma_cuentas;
	}
	
	/**campo de clase cuentas encapsulado, 
	 * final= osea que sera una constante para que no se pueda modificar
	 * double= porque va ser de tipo double
	 *  array donde se almacenaran las 100 cuentas*/
	private final double[]cuentas;
	/**cierreBanco: instancia perteneciente a la clase ReentranLock, concretamente un campo
	encapsulado de la clase ReentranLock el cual es implementado por la interfaz Lock s*/
	private Lock cierreBanco=new ReentrantLock();
	/**Este campo de clase de tipo Conditio: sera utilizado validar si hay saldo suficiente en la cuenta*/
//	private Condition saldoSuficiente;
	
}

class EjecucionTransferencias implements Runnable{
	
	/**Constructor:EjecucionTransferencias*/
	public  EjecucionTransferencias(Banco b, int de, double max) {
		banco=b;
		deLaCuenta=de;
		cantidadMax=max;
	}
	
	
	/**run(): metodo que va a ejecutar cada hilo, es el que va arrancar cada una de las transferencias */
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){//para crear un bucle infinito, es decir que va ejecutar infinitas transferencias
				
				/*
				 * En primer lugar hay que especificar cual va ser la cuentaDestino,
				 * y la cuentaDestino va ser aleatoria, no va ser siempre la misma,
				 * es por ello que se utilizara el metodo random() de clase Math
				 */
				int paraLaCuenta=(int)(100*Math.random());/*cuenta destino: ejemplo: Math.random()=0,256987*100= 25,6987 pero como se
				le esta haciendo el casting(int) entonces bota lo decimal y queda un numero entero osea: 25*/
				
				double cantidad=cantidadMax*Math.random();/*cantidad a transferir*/
				
				banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
				
				/*para que todo esto lo haga de una forma lenta, hay que dormir un hilo para que nos permita ver en consola toda la información*/
				
				Thread.sleep((int)(Math.random()*10));/*con el metodo random queda aleatorio que duerme cada hilo*/
//				Thread.sleep(1000);
				
			}
		}catch(InterruptedException e){
			
		}
	}
	/**campo de clase Banco*/
	private Banco banco;
	/**campo de clase: deLaCuenta, campo donde se almacena la cuenta origen, es decir de la que parte*/
	private int deLaCuenta;
	/**campo de clase: cantidadMax, cantidad maxima permitida para cada cuenta*/
	private double cantidadMax;
}

