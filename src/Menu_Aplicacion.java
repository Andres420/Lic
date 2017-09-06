
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Menu_Aplicacion {

    DefaultTableModel Tabla;
    private final Object[] columnsNames = {"Cedula",
        "Nombre",
        "Celular",
        "Licencia",
        "Cita"};
    Object[][] information = {};
    private ArrayList<Persona> list = new ArrayList<>();
    public static JFrame window = new JFrame("MENU");
    public static JButton btnadd = new JButton("Agregar Persona"),
            btnmodify = new JButton("Modificar Persona"),
            btndelete = new JButton("Eliminar Persona");
    private final JLabel lblsearch = new JLabel("Buscar: ");
    private final JTextField search = new JTextField();
    private final Font fuente = new Font("Monospaced", Font.BOLD, 18);
    private final JPanel panel_up = new JPanel(),
            panel_down = new JPanel(),
            panel_center = new JPanel();
    private JTable table;

    public void INIT_WINDOW() {
        COMPONENT_UP();
        COMPONENT_CENTER();
        COMPONENTS_DOWN();
        window.setLayout(new BorderLayout());
        window.add(panel_up, BorderLayout.NORTH);
        window.add(panel_center, BorderLayout.CENTER);
        window.add(panel_down, BorderLayout.SOUTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(true);
        window.pack();
        window.setLocationRelativeTo(null);
    }

    private void COMPONENT_UP() {
        btnadd.setFont(fuente);
        btnmodify.setFont(fuente);
        btndelete.setFont(fuente);
        panel_up.add(btnadd);
        panel_up.add(btnmodify);
        panel_up.add(btndelete);
        btnadd.addActionListener(new Actionlistener());
        btnmodify.addActionListener(new Actionlistener());
        btndelete.addActionListener(new Actionlistener());
    }

    private void COMPONENT_CENTER() {
        Tabla = new DefaultTableModel(information,columnsNames)
            {
                @Override
                public boolean isCellEditable(int row, int col)
                {
                    return false;
                }
            };        
        table = new JTable(Tabla);
        table.setFont(fuente);
        JScrollPane js = new JScrollPane(table);
        panel_center.add(js);
        panel_center.setLayout(new BoxLayout(panel_center, BoxLayout.X_AXIS));

    }

    private void COMPONENTS_DOWN() {
        panel_down.setLayout(new BoxLayout(panel_down, BoxLayout.X_AXIS));
        search.setFont(fuente);
        lblsearch.setFont(fuente);
        panel_down.add(lblsearch);
        panel_down.add(search);
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String buscador = search.getText();
                list = DataBase.Buscar(buscador);
                Table_Change(list);
            }
        };
        search.addKeyListener(listener);

    }

    private void Table_Change(ArrayList list) {
        int numFilas = Tabla.getRowCount();
        
        if (numFilas > 0) {
            for (int i = numFilas - 1; i >= 0; i--) {
                Tabla.removeRow(i);
            }
        }
        
        Tabla.setNumRows(list.size());
        
        for (int k = 0; k < list.size(); k++) {
            Persona person = (Persona) list.get(k);
            Tabla.setValueAt(person.getIdentification(), k, 0);
            Tabla.setValueAt(person.getName(), k, 1);
            Tabla.setValueAt(person.getCellphone(), k, 2);
            Tabla.setValueAt(person.getKindlicense(), k, 3);
            Tabla.setValueAt(person.getPay(), k, 4);
        }
    }
}
