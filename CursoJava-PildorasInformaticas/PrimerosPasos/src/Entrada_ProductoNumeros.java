import java.util.*;

/**
 * @author freyder
 *
 */
public class Entrada_ProductoNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);

		int x, y, z, resultado;

		System.out.println("Escriba el primer entero: ");
		x = entrada.nextInt();

		System.out.println("Escriba el segundo entero: ");
		y = entrada.nextInt();

		System.out.println("Escriba el tercer entero: ");
		z = entrada.nextInt();

		resultado = x * y * z;

		System.out.println(" El producto de: " + x + " *" + y + " *" + z + " es:" + resultado);

	}

}
