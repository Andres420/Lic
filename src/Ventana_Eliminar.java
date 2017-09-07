
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class Ventana_Eliminar extends JDialog {
    
    DefaultTableModel Tabla;
    private JTable table;
    private final JLabel lblsearch = new JLabel("Buscar");
    private final JTextField txtsearch = new JTextField(20);
    private final Font fuente = new Font("Monospaced", Font.BOLD, 16);
    private final Object[] columnsNames = {"Cedula",
        "Nombre",
        "Celular",
        "Licencia",
        "Cita"};
    private final JPanel panel_up = new JPanel(), panel_center = new JPanel(),
            panel_down = new JPanel();
    Object[][] information = {};
    public static ArrayList<Persona> list = new ArrayList<>();
    public static JButton btndelete_per = new JButton("Eliminar");
    
    public void INITWINDOW() {
        COMPONENTS();
        Tabla();
        COMPONENTS_1();
        this.setLayout(new BorderLayout());
        this.add(panel_up,BorderLayout.NORTH);
        this.add(panel_center,BorderLayout.CENTER);
        this.add(panel_down,BorderLayout.SOUTH); 
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    private void COMPONENTS() {
        lblsearch.setFont(fuente);
        txtsearch.setFont(fuente);
        panel_up.add(lblsearch);
        panel_up.add(txtsearch);
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                String buscador = txtsearch.getText();
                list = DataBase.Buscar(buscador);
                Table_Change(list);
            }
        };
        txtsearch.addKeyListener(listener);
    }

    private void COMPONENTS_1() {
        btndelete_per.setFont(fuente);
        btndelete_per.addActionListener(new Actionlistener());
        panel_down.add(btndelete_per);
    }
    
    private void Tabla() {
        Tabla = new DefaultTableModel(information, columnsNames) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        table = new JTable(Tabla);
        table.setFont(fuente);
        JScrollPane js = new JScrollPane(table);
        panel_center.add(js);
        panel_center.setLayout(new BoxLayout(panel_center, BoxLayout.X_AXIS));
        
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
