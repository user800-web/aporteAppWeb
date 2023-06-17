package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import logicbusiness.Customer;

@ManagedBean(name = "listInteControllerMB")
@ViewScoped
public class ListInteControllerMB {
    private List<Customer> listIntegrantes = new ArrayList<>();

    public ListInteControllerMB() {
        Customer c = new Customer();
        try {
            this.listIntegrantes = c.select();
        } catch (Exception ex) {
            Logger.getLogger(ListInteControllerMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Customer> getListIntegrantes() {
        return listIntegrantes;
    }

    public void setListIntegrantes(List<Customer> listIntegrantes) {
        this.listIntegrantes = listIntegrantes;
    }
    
    

    
}
