
import java.util.ArrayList;

class DataBase {
    
    public static ArrayList Buscar(String a) {
        ArrayList<Persona> list = new ArrayList<>();
        Persona person = new Persona (207900323,"Carlos asd",24600454,"A2","no");
        list.add(person);
        Persona person_1 = new Persona (207900323,"Carlos asd",24600454,"A2","no");
        list.add(person_1);
        Persona person_2 = new Persona (207900323,"Carlos asd",24600454,"A2","no");
        list.add(person_2);
        Persona person_3 = new Persona (207900323,"Carlos asd",24600454,"A2","no");
        list.add(person_3);
        Persona person_4 = new Persona (207900323,"Carlos asd",24600454,"A2","no");
        list.add(person_4);
        return list;
    }
    
}
