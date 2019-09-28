package usothreads;

public class SincronizandoHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**sincronizacion de hilos*************************************************************************************/
		HilosVarios hilo1= new HilosVarios();
		HilosVarios2 hilo2= new HilosVarios2(hilo1);/* hasta que el hilo1 no termine su ejecucion la tarea del hilo2 no comenzara
		una vez hecho esto da igual el orden en el que se le diga el main que comience la tarea 
		a cualquier hillo*/
		
		hilo2.start();
		hilo1.start();/*comienza la ejecucion del hilo*/
//		
//		try {
//			hilo1.join();/*el metodo join Espera a que este hilo muera para comenzar con otro hilo*/
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		hilo2.start();
//		try {
//			hilo2.join();/*esta instruccion no se va a ejecutar hasta que el hilo1 termine*/
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		/**************************************************************************************************************/
		/**como los hilos estan sincronizados y estan ejecutando sus tareas, el metodo main puede ejecutar sus tareas libremente*/
		System.out.println("Terminadas las tareas");/*esta instruccion no se va ejecutar hasta que el hilo2 termine*/
		
		
		
		/*para distinguir cual pertenece al hilo1 y cual pertenece al hilo 2 en consola se utiliza
		 * el metodo: getName()*/
	}

}
class HilosVarios extends Thread{
	
	
	public void run(){
		
		for(int i=0; i<15; i++){
			System.out.println("Ejecutando hilo " + getName());
			
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class HilosVarios2 extends Thread {
	/**este constructor va recibir un hilo como parametro, con objeto de que cuando sea instanciado se le mande como parametro un hilo, y se ejecute
	 * el constructor cuando haya terminado el hilo que se envio como parametro*/
	public HilosVarios2(Thread hilo) {
		this.hilo=hilo;
	}

	public void run() {
		
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		}/*esta tarea no comience hasta que el hilo que le hemos pasado por parametro al constructor no haya terminado su tarea*/
		
		
		
		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo " + getName());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**campo hilo encapsulado*/
	private Thread hilo;
}