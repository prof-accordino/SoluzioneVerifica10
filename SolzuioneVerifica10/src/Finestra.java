import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Finestra extends JFrame
{
	private static final long serialVersionUID = 1L;
	private ImagePanel imagePanel;

	public Finestra(String titolo, int larghezza, int altezza)
	{		
		//Imposto il titolo
		setTitle(titolo);
		
		// Inizializzo il pannello che contiene l'immagine
		imagePanel = new ImagePanel(larghezza, altezza);
		
		// Aggiungo il pannello alla finestra
		add(imagePanel);
		
		// Metto la finestra al centro dello schermo
		setLocationRelativeTo(null);
		
		// Imposto le dimensioni
		setSize(larghezza, altezza);
		
		// Imposto la chiusura del programma quando chiudo la finestra
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Rende la finestra visibile
		setVisible(true);
	}

	public void disegna(Color[][] immagine, int ritardo)
	{
		imagePanel.disegna(immagine);		

		try 
		{
			TimeUnit.MILLISECONDS.sleep(ritardo);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		// Adatto la dimensione della finestra al pannello con l'immagine
	}

	private class ImagePanel extends JPanel 
	{
		private static final long serialVersionUID = 1L;
		// Crea una variabile per memorizzare l'immagine da disegnare
		private BufferedImage buffered_image;

		public ImagePanel(int w, int h)
		{
			setSize(w, h);
			buffered_image = new BufferedImage(w, h, EXIT_ON_CLOSE);
		}

		// Sovrascrive il metodo paintComponent per disegnare l'immagine
		@Override
		protected void paintComponent(Graphics g) 
		{
			super.paintComponent(g);
			// Disegna l'immagine usando l'oggetto Graphics
			g.drawImage(buffered_image, 0, 0, this);
		}

		// Metodo per cambiare l'immagine del pannello
		public void disegna(Color[][] immagine) 
		{
			for (int i = 0; i < buffered_image.getHeight(); i++)
				for (int j = 0; j < buffered_image.getWidth(); j++)
					buffered_image.setRGB(j, i, immagine[i][j].getRGB());

			// Richiede al pannello di ridisegnarsi
			repaint();
		}
	}
}