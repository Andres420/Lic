
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Menu_Aplicacion {
    private ArrayList list = new ArrayList();
    private final JFrame window = new JFrame("MENU");
    public static JButton btnadd = new JButton("Agregar Persona"),
            btnmodify = new JButton("Modificar Persona"),
            btndelete = new JButton("Eliminar Persona");
    private final JLabel lblsearch = new JLabel("Buscar: ");
    private final JTextField search = new JTextField(10);
    private final Font fuente = new Font("Monospaced", Font.BOLD, 15);
    private final JPanel panel_up = new JPanel(),
            panel_down = new JPanel(),
            panel_center = new JPanel();
    private final JTable table = new JTable();
    public void INIT_WINDOW() {
        COMPONENT_UP();
        COMPONENT_CENTER();
        COMPONENTS_DOWN();
        window.setLayout(new BorderLayout());
        window.add(panel_up, BorderLayout.NORTH);
        window.add(panel_center, BorderLayout.CENTER);
        window.add(panel_down, BorderLayout.SOUTH);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
    }

    private void COMPONENT_UP() {
        panel_up.setLayout(new BoxLayout(panel_up, BoxLayout.X_AXIS));
        panel_up.add(btnadd);
        panel_up.add(btnmodify);
        panel_up.add(btndelete);
        btnadd.addActionListener(new Actionlistener());
        btnmodify.addActionListener(new Actionlistener());
        btndelete.addActionListener(new Actionlistener());
    }

    private void COMPONENT_CENTER() {
        panel_center.setLayout(new BoxLayout(panel_center, BoxLayout.X_AXIS));
        search.setFont(fuente);
        panel_center.add(lblsearch);
        panel_center.add(search);
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                String buscador = search.getText();
                list = DataBase.Buscar(buscador);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        search.addKeyListener(listener);
    }

    private void COMPONENTS_DOWN() {
        //Crear tabla
    }
}
