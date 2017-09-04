
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Actionlistener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Menu_Aplicacion.btnadd) {
            Ventana_Agregar va = new Ventana_Agregar();
            va.INITWINDOW();
        } else if (e.getSource() == Menu_Aplicacion.btnmodify) {
            Ventana_Modificar vm = new Ventana_Modificar();
            vm.INITWINDOW();
        } else if (e.getSource() == Menu_Aplicacion.btndelete) {
            Ventana_Eliminar ve = new Ventana_Eliminar();
            ve.INITWINDOW();
        }
    }

}
