
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main {

    private final JFrame window = new JFrame("CITAS COSEVI");
    private final JLabel lbltittle = new JLabel("INICIAR SESION"),
            lblaccount = new JLabel("Cuenta:"),
            lblpsword = new JLabel("Clave:");
    private final JButton btnstart = new JButton("Iniciar Sesion");
    private final JTextField account = new JTextField(15);
    private final JPasswordField password = new JPasswordField(15);
    private final Font fuente = new Font("Monospaced", Font.BOLD, 30);
    private final JPanel panel_up = new JPanel(),
            panel_down = new JPanel(),
            panel_center = new JPanel();

    private void WINDOW() {
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
        lbltittle.setFont(fuente);
        panel_up.add(lbltittle);
    }

    private void COMPONENT_CENTER() {
        panel_center.setLayout(new BoxLayout(panel_center, BoxLayout.Y_AXIS));
        panel_center.add(lblaccount);
        panel_center.add(account);
        panel_center.add(lblpsword);
        panel_center.add(password);

    }

    private void COMPONENTS_DOWN() {
        panel_down.add(btnstart);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass_1 = password.getPassword();
                try {
                    if ((account.getText().equals("KIKE")) && (String.valueOf(pass_1).equals("KIKE2017"))) {
                        Menu_Aplicacion ma = new Menu_Aplicacion();
                        ma.INIT_WINDOW();
                        window.dispose();
                    } else {
                        password.setText("");
                        JOptionPane.showMessageDialog(null, "Cuenta o clave incorrecta");
                    }
                } catch (HeadlessException ex) {
                    ex.printStackTrace();
                }
            }
        };
        btnstart.addActionListener(listener);
    }

    public static void main(String[] args) {
        Main mn = new Main();
        mn.WINDOW();
        
        /*Menu_Aplicacion mn = new Menu_Aplicacion();
        mn.INIT_WINDOW();*/
    }
}
