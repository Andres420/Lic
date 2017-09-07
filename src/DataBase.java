
import java.util.ArrayList;

class DataBase {
    
    public static void Agregar(int ced, String name, int cellphone, String license, String pay, String appointment){
    
    }
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
    /*INSERT INTO "Cosevi" VALUES (207900237,'Andres Alberto Avila Brenes',88737280,'A2','Si');
    SELECT * FROM "Cosevi" WHERE CAST(cedula AS VARCHAR) LIKE '406%' OR nombre LIKE 'A%';
    
    */
}
