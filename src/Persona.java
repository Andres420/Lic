/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Extreme pc
 */
public class Persona {
    private int identification;
    private int cellphone;
    private String name;
    private String license;
    
    public Persona(int identification,String name,int cellphone, String license){
        this.identification = identification;
        this.name = name;
        this.cellphone = cellphone;
        this.license = license;
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

}