package fernandowirtz.primitiva;

import java.util.Arrays;


public class Primitiva {

	private int[] combinacion;

	public Primitiva() {
		generarCombinacion();
	}

	public int[] getCombinacion() {
		return this.combinacion;
	}

	public void generarCombinacion() {
		this.combinacion = new int[6]; 
		int i=0; 
		this.combinacion[i]=(int)(Math.random()*49+1); 
		for(i = 1; i<this.combinacion.length; i++) { 
			this.combinacion[i]=(int)(Math.random()*49+1); 
				for(int j=0; j<i; j++) { 
					if(this.combinacion[i]== this.combinacion[j]) { 
						i--; 
					} 
				}
		}
		Arrays.sort(this.combinacion);
	}
}
