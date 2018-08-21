/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pharmacy.entity;

/**
 *
 * @author mcs
 */
public class Prescriptiondetail {
     private String DoctorName;
     private Prescriptiondetail_PK prescriptiondetail_PK;
     

    public Prescriptiondetail() {
    }

    public Prescriptiondetail(String DoctorName, Prescriptiondetail_PK prescriptiondetail_PK) {
        this.DoctorName = DoctorName;
        this.prescriptiondetail_PK = prescriptiondetail_PK;
        
    }
    public Prescriptiondetail(String DoctorName,String PID,String MID) {
        this.DoctorName = DoctorName;
        this.prescriptiondetail_PK= new Prescriptiondetail_PK(PID, MID);
        
    }

    /**
     * @return the DoctorName
     */
    public String getDoctorName() {
        return DoctorName;
    }

    /**
     * @param DoctorName the DoctorName to set
     */
    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
    }

    /**
     * @return the prescriptiondetail_PK
     */
    public Prescriptiondetail_PK getPrescriptiondetail_PK() {
        return prescriptiondetail_PK;
    }

    /**
     * @param prescriptiondetail_PK the prescriptiondetail_PK to set
     */
    public void setPrescriptiondetail_PK(Prescriptiondetail_PK prescriptiondetail_PK) {
        this.prescriptiondetail_PK = prescriptiondetail_PK;
    }

   
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
