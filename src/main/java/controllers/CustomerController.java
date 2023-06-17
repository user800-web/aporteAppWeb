package controllers;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logicbusiness.Customer;

@ManagedBean(name = "customerControllerMB")
@ViewScoped
public class CustomerController implements Serializable {
    private int id_inte;
    private String nombres;
    private String direccion;
    private String telefono;
    private String fechaNac;
    private int id_pro;
    private String descripcion;
    private String director;
    private String fechaDesde;
    private String fechaHasta;
    
    

    public int getId_inte() {
        return id_inte;
    }

    public void setId_inte(int id_inte) {
        this.id_inte = id_inte;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    public String save() {        
        System.out.println("conexión");
        Customer customer = new Customer(this.nombres, this.direccion, this.telefono, this.fechaNac);
        try {
            if (customer.insert() == 1) {
                addMessage(FacesMessage.SEVERITY_INFO, "Información", "Integrante creado correctamente.");
                return "confirmation";
            } else {
                return "error";
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            addMessage(FacesMessage.SEVERITY_ERROR, "Información", "Error al guardar los datos.");
            return "error";
        }
    }
    public String actualizar() {        
        Customer customer = new Customer(this.nombres, this.direccion, this.telefono, this.fechaNac);
        try {
            if (customer.update() == 1) {
                addMessage(FacesMessage.SEVERITY_INFO, "Información", "Integrante actualizado correctamente.");
                return "confirmation";
            } else {
                return "error";
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            addMessage(FacesMessage.SEVERITY_ERROR, "Información", "Error al guardar los datos.");
            return "error";
        }
    }
    public String eliminacion() {      
        Customer customer = new Customer(this.nombres);
        try {
            if (customer.delete() == 1) {
                addMessage(FacesMessage.SEVERITY_INFO, "Información", "Integrante eliminado correctamente.");
                return "confirmation";
            } else {
                return "error";
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            addMessage(FacesMessage.SEVERITY_ERROR, "Información", "Error al guardar los datos.");
            return "error";
        }
    }
}
