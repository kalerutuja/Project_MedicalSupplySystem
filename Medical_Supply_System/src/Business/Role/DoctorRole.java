/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Hospital.Doctor;
import Business.UserAccount.UserAccount;
import java.awt.Component;
import javax.swing.JPanel;
import userinterface.DoctorRole.DoctorWorkAreaJPanel;

/**
 *
 * @author rutuja
 */
public class DoctorRole extends Role{
<<<<<<< HEAD

    @Override
    public Component createWorkArea(JPanel container, UserAccount userAccount, EcoSystem system) {
        Doctor doctor = (Doctor) userAccount.getPerson();
        return new DoctorWorkAreaJPanel(container, doctor, system);
    }

=======
>>>>>>> main
    
}
