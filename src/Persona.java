
public class Persona {
    private int identification;
    private int cellphone;
    private String name;
    private String license;
    private String pay; 
    private String appointment;
    
    public Persona(int identification,String name,int cellphone, String license,String pay,String appointment){
        this.identification = identification;
        this.name = name;
        this.cellphone = cellphone;
        this.license = license;
        this.pay = pay;
        this.appointment = appointment;
    }
    
    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public String getKindlicense() {
        return license;
    }

    public void setKindlicense(String license) {
        this.license = license;
    }
    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

}
