import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class H {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<String> historial, JFrame Calculadora) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					H window = new H(historial, Calculadora);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public H(ArrayList<String> historial, JFrame Calculadora) {
		initialize(historial, Calculadora);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> historial, JFrame Calculador) {
		try {
		    UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 478, 372);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 442, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 0, 422, 229);
		panel.add(textArea);
		for(int i = 0; i < historial.size(); i++) {
			textArea.setText(textArea.getText() + historial.get(i) + "\n");
		}
	}
}
