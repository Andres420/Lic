
import java.sql.*;
import java.util.ArrayList;

class DataBase {

    static Connection conn;
    static Statement st;
    static ResultSet rs;
    static String search;
    static String add,modify,delete;
    static String jdbc = "jdbc:postgresql://localhost:5432/postgres";

    public static void Agregar(Persona person) throws ClassNotFoundException, SQLException {
        add = "INSERT INTO cosevi VALUES ("+person.getIdentification()+
                ",'"+person.getName()+"',"+person.getCellphone()+
                ",'"+person.getKindlicense()+"','"+person.getPay()+
                "','"+person.getAppointment()+"')";
        conn = DriverManager.getConnection(jdbc, "postgres", "Admin");
        st = conn.createStatement();
        st.executeUpdate(add);
        conn.close();
    }

    public static void Modificar() {

    }

    public static ArrayList Buscar(String a) throws SQLException {
        ArrayList<Persona> list = new ArrayList<>();
        if (!a.equals("")) {
            conn = DriverManager.getConnection(jdbc, "postgres", "Admin");
            search = "SELECT * FROM cosevi WHERE CAST(cedula AS VARCHAR) ILIKE '"+a+"%' OR nombre ILIKE '"+a+"%';";
            st = conn.createStatement();
            rs = st.executeQuery(search);

            while (rs.next()) {
                Persona person = new Persona(rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("celular"),
                        rs.getString("licencia"),
                        rs.getString("pago"),
                        rs.getString("cita"));
                list.add(person);
            }
            conn.close();
            return list;
        }else{
            return list;
        }

   
    }
    /*INSERT INTO "Cosevi" VALUES (207900237,'Andres Alberto Avila Brenes',88737280,'A2','Si');
    SELECT * FROM "Cosevi" WHERE CAST(cedula AS VARCHAR) LIKE '406%' OR nombre LIKE 'A%';
    
     */
}
