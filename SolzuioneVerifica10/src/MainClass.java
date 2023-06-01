import java.awt.*;
import java.util.Scanner;

public class MainClass
{
	static Scanner in = new Scanner(System.in);

	// Numero di pixel di altezza (righe)
	static int altezza = 500;

	// Numero di pixel di larghezza (colonne)
	static int larghezza = 800;

	// Creo una finestra con un titolo 
	static Finestra finestra = new Finestra("Finestra", larghezza, altezza);

	// Creo una matrice di pixel
	static Color[][] immagine = new Color[altezza][larghezza];

	public static void main(String[] args) 
	{
		for(int i = 100; i >= 0; i--)
		{
			background();
			corona(200-i, 200-i, 90, 80, Color.blue);		
			corona(400, 200-i, 90, 80, Color.black);
			corona(600+i, 200-i, 90, 80, Color.red);		
			corona(300-i, 280+i, 90, 80, Color.yellow);		
			corona(500+i, 280+i, 90, 80, Color.green);
			finestra.disegna(immagine, 0);
		}	
	}

	public static void background()
	{
		for(int i = 0; i < immagine.length; i++)
			for(int j = 0; j < immagine[0].length; j++)
				immagine[i][j] = Color.white;				
	}

	public static void corona(int centro_x, int centro_y, int raggio_ext, int raggio_int, Color c)
	{
		for(int y = 0; y < immagine.length; y++)
		{
			for(int x = 0; x < immagine[0].length; x++)
			{
				int x_q = (int) Math.pow(x - centro_x, 2);
				int y_q = (int) Math.pow(y - centro_y, 2);
				int radq = (int) Math.sqrt(x_q + y_q);
				if (radq < raggio_ext && radq > raggio_int)
					immagine[y][x] = c;				
			}
		}
	}
}