
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


class Ventana_Modificar extends JDialog{

    
        DefaultTableModel Tabla;
    private final Object[] columnsNames = {"Cedula",
        "Nombre",
        "Celular",
        "Licencia",
        "Cita"};
    private final String[] list_combo ={"A1","A2","A3","B1","B2","B3","B4",
    "C1","C2","D1","D2","D3","E1","E2"};
    private final JComboBox kind_license = new JComboBox(list_combo);
    Object[][] information = {};
    private ArrayList<Persona> list = new ArrayList<>();
    private final JLabel lblsearch = new JLabel("Buscar: "),lblname = new JLabel("Nombre: "),
            lblidentification = new JLabel("Cedula: "),lblcellphone = new JLabel("Celular: "),
            lblkindlicense = new JLabel("Licencia: "),lblpay = new JLabel("Pagó: ");
    private final JTextField search = new JTextField(20),name = new JTextField(20),
            identification = new JTextField(20),cellphone = new JTextField(20);
    private final Font fuente = new Font("Monospaced", Font.BOLD, 16);
    private final JPanel panel_up = new JPanel(),
            panel_license_pay = new JPanel(),panel_center = new JPanel(),
            panel_name = new JPanel(),panel_identification = new JPanel(),
            panel_cellphone = new JPanel(),panel_save = new JPanel();
    private JTable table;
    private final JRadioButton jrbpago_si= new JRadioButton("Si"),jrbpago_no = new JRadioButton("No"); 
    public static JButton btnsave_modify = new JButton("Guardar");
    
    public void INITWINDOW() {
        Buscar();
        Tabla();
        Identification();
        Name();
        Cellphone();
        License_Pay();
        Save();
        this.add(panel_up);
        this.add(panel_center);
        this.add(panel_identification);
        this.add(panel_name);
        this.add(panel_cellphone);
        this.add(panel_license_pay);
        this.add(panel_save);
        this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void Buscar() {
        panel_up.setLayout(new BoxLayout(panel_up, BoxLayout.X_AXIS));
        search.setFont(fuente);
        lblsearch.setFont(fuente);
        panel_up.add(lblsearch);
        panel_up.add(search);
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

    private void Tabla() {
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

    private void Name() {
        lblname.setFont(fuente);
        name.setFont(fuente);
        panel_name.add(lblname);
        panel_name.add(name);
    }

    private void Identification() {
        lblidentification.setFont(fuente);
        identification.setFont(fuente);
        panel_identification.add(lblidentification);
        panel_identification.add(identification);
    }

    private void Cellphone() {
        lblcellphone.setFont(fuente);
        cellphone.setFont(fuente);
        panel_cellphone.add(lblcellphone);
        panel_cellphone.add(cellphone);
    }

    private void License_Pay() {
        lblkindlicense.setFont(fuente);
        lblpay.setFont(fuente);
        kind_license.setFont(fuente);
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(jrbpago_si);
        buttons.add(jrbpago_no);
        jrbpago_si.setFont(fuente);
        jrbpago_no.setFont(fuente);
        panel_license_pay.add(lblkindlicense);
        panel_license_pay.add(kind_license);
        panel_license_pay.add(lblpay);
        panel_license_pay.add(jrbpago_si);
        panel_license_pay.add(jrbpago_no);
    }
    
    private void Save(){
        btnsave_modify.setFont(fuente);
        panel_save.add(btnsave_modify);
        btnsave_modify.addActionListener(new Actionlistener());
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
