
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

class Actionlistener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Menu_Aplicacion.btnadd) {
            Menu_Aplicacion.va = new Ventana_Agregar();
            Menu_Aplicacion.va.INITWINDOW();
            Menu_Aplicacion.va.setModal(true);
            Menu_Aplicacion.va.setVisible(true);

        } else if (e.getSource() == Menu_Aplicacion.btnmodify) {
            Menu_Aplicacion.vm = new Ventana_Modificar();
            Menu_Aplicacion.vm.INITWINDOW();
            Menu_Aplicacion.vm.setModal(true);
            Menu_Aplicacion.vm.setVisible(true);

        } else if (e.getSource() == Menu_Aplicacion.btndelete) {
            Menu_Aplicacion.ve = new Ventana_Eliminar();
            Menu_Aplicacion.ve.INITWINDOW();
            Menu_Aplicacion.ve.setModal(true);
            Menu_Aplicacion.ve.setVisible(true);

        } else if (e.getSource() == Ventana_Agregar.btnsave) {
            boolean person = Ventana_Agregar.Person();
            if (person == true) {
                int reply = JOptionPane.showConfirmDialog(null, "Esta seguro?", "Agregar persona", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    try {
                        DataBase.Agregar(Ventana_Agregar.person);
                        Menu_Aplicacion.va.dispose();
                        JOptionPane.showMessageDialog(null, "Informacion guardada");
                    } catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Falta información");
            }
        } else if (e.getSource() == Ventana_Modificar.btnsave_modify) {
            //Guardar modificado a la base de datos
            Menu_Aplicacion.vm.setModal(false);
            Menu_Aplicacion.vm.dispose();
        } else if (e.getSource() == Ventana_Eliminar.btndelete_per) {
            //Borrar persona de base
            Menu_Aplicacion.ve.setModal(false);
            Menu_Aplicacion.ve.dispose();
        }
    }

}
