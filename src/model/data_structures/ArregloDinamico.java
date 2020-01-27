package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable<T>> implements IArregloDinamico {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		
		tamanoMax = max;
		tamanoAct = 0;
		elementos = (T[]) new Comparable[max];
	}

	public void agregar( Object dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T[ ] copia = elementos;
			elementos =  (T[]) new Comparable[tamanoMax];

			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = (T) dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) {
		// TODO implementar
		T elemento = elementos[i];

		return  elemento;	
	}

	public T buscar(Object dato) {

		T datoBuscado = null;

		for ( int i = 0; i < tamanoAct; i++)
		{
			if(elementos[i].compareTo((T)dato)==0)
			{
				datoBuscado = elementos[i];
			}
		} 
		return datoBuscado;
	}

	public T eliminar(Object dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.

		T datoBuscado = null;

		for ( int i = 0; i < tamanoAct; i++)
		{
			if(elementos[i].compareTo((T) dato)==0)
			{
				datoBuscado = elementos[i];
				tamanoAct--;
				for(int j = i; j < tamanoAct-1; j++) 
				{
					elementos[j]=elementos[j+1];
				}
				break;
			}
		} 
		return   datoBuscado;
	}
}
