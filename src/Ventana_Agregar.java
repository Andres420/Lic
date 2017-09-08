
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class Ventana_Agregar extends JDialog {

    public static boolean Person() {
        boolean person_real = false;
        if (!identification.getText().equals("")) {
            if (!name.getText().equals("")) {
                if (!cellphone.getText().equals("")) {
                    if (jrbpago_si.isSelected() == true) {
                        String k = (String) kind_license.getSelectedItem();

                        if (jrbcita_si.isSelected() == true) {
                            person_real = true;
                            person = new Persona(Integer.parseInt(identification.getText()), name.getText().toLowerCase(),
                                    Integer.parseInt(cellphone.getText()),
                                    k,
                                    "Si",
                                    "Si");
                        } else if (jrbcita_no.isSelected() == true) {
                            person_real = true;
                            person = new Persona(Integer.parseInt(identification.getText()), name.getText().toLowerCase(),
                                    Integer.parseInt(cellphone.getText()),
                                    k,
                                    "Si",
                                    "No");
                        }

                    } else if (jrbpago_no.isSelected() == true) {
                        String k = (String) kind_license.getSelectedItem();

                        if (jrbcita_si.isSelected() == true) {
                            person_real = true;
                            person = new Persona(Integer.parseInt(identification.getText()), name.getText().toLowerCase(),
                                    Integer.parseInt(cellphone.getText()),
                                    k,
                                    "No",
                                    "Si");
                        } else if (jrbcita_no.isSelected() == true) {
                            person_real = true;
                            person = new Persona(Integer.parseInt(identification.getText()), name.getText().toLowerCase(),
                                    Integer.parseInt(cellphone.getText()),
                                    k,
                                    "No",
                                    "No");
                        }
                    }
                }
            }
        }
        return person_real;
    }

    private static final String[] list_combo = {"A1", "A2", "A3", "B1", "B2", "B3", "B4",
        "C1", "C2", "D1", "D2", "D3", "E1", "E2"};
    private final JPanel panel_identification = new JPanel(),
            panel_name = new JPanel(), panel_cellphone = new JPanel(),
            panel_save = new JPanel(), panel_appoinrment = new JPanel();
    private final JPanel panel_license = new JPanel(), panel_pay = new JPanel();
    private final JLabel lblide = new JLabel("Cedula: "), lblname = new JLabel("Nombre: "),
            lblcel = new JLabel("Celular: "), lbllicense = new JLabel("Tipo de licencia: "),
            lblpay = new JLabel("Tiene pago: ");
    private final Font fuente = new Font("Monospaced", Font.BOLD, 18);
    public static JTextField identification = new JTextField("", 15), name = new JTextField("", 15),
            cellphone = new JTextField("", 15);
    public static JRadioButton jrbpago_si = new JRadioButton("Si"), jrbpago_no = new JRadioButton("No"),
            jrbcita_si = new JRadioButton("Si"), jrbcita_no = new JRadioButton("No");
    private static final JComboBox kind_license = new JComboBox(list_combo);
    public static JButton btnsave = new JButton("Guardar");
    public static Persona person;

    public void INITWINDOW() {
        Panel_Name();
        Panel_Identification();
        Panel_Cellphone();
        Panel_License();
        Panel_Pay();
        Panel_Appointment();
        Panel_Save();
        this.add(panel_identification);
        this.add(panel_name);
        this.add(panel_cellphone);
        this.add(panel_license);
        this.add(panel_pay);
        this.add(panel_appoinrment);
        this.add(panel_save);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void Panel_Identification() {
        lblide.setFont(fuente);
        panel_identification.add(lblide);
        identification.setFont(fuente);
        panel_identification.add(identification);
    }

    private void Panel_Name() {
        lblname.setFont(fuente);
        panel_name.add(lblname);
        name.setFont(fuente);
        panel_name.add(name);
    }

    private void Panel_Cellphone() {
        lblcel.setFont(fuente);
        panel_cellphone.add(lblcel);
        cellphone.setFont(fuente);
        panel_cellphone.add(cellphone);
    }

    private void Panel_License() {
        lbllicense.setFont(fuente);
        panel_license.add(lbllicense);
        kind_license.setFont(fuente);
        panel_license.add(kind_license);
    }

    private void Panel_Pay() {
        lblpay.setFont(fuente);
        panel_pay.add(lblpay);
        jrbpago_si.setFont(fuente);
        jrbpago_no.setFont(fuente);
        ButtonGroup group = new ButtonGroup();
        group.add(jrbpago_si);
        group.add(jrbpago_no);
        panel_pay.add(jrbpago_si);
        panel_pay.add(jrbpago_no);

    }

    private void Panel_Save() {
        btnsave.setFont(fuente);
        panel_save.add(btnsave);
        btnsave.addActionListener(new Actionlistener());
    }

    private void Panel_Appointment() {
        JLabel lblcita = new JLabel("Tiene la cita: ");
        lblcita.setFont(fuente);
        panel_appoinrment.add(lblcita);
        jrbcita_si.setFont(fuente);
        jrbcita_no.setFont(fuente);
        ButtonGroup group = new ButtonGroup();
        group.add(jrbcita_si);
        group.add(jrbcita_no);
        panel_appoinrment.add(jrbcita_si);
        panel_appoinrment.add(jrbcita_no);
    }

}
