package logicbusiness;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Customer {

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

    public Customer() {
    }

    public Customer(String nombres, String direccion, String telefono, String fechaNac) {
        
        this.nombres = nombres;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
    }
    public Customer(String nombres) {
        this.nombres = nombres;
    }
    public Customer(int id_pro, String descripcion, String director) {
        this.id_pro = id_pro;
        this.descripcion = descripcion;
        this.director = director;
    }

    public Customer(int id_inte, int id_pro, String fechaDesde, String fechaHasta) {
        this.id_inte = id_inte;
        this.id_pro = id_pro;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

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

    public long insert() throws Exception {
        String sentence = "INSERT INTO public.integrantes(" +
"	nombres, direccion, telefono, \"fechaNac\")" +
"	VALUES ( '"+nombres+"', '"+direccion+"', '"+telefono+"', '"+fechaNac+"');";
        
        Conexion conexion = new Conexion();
        return conexion.insertar(sentence);
    }

    public long delete() throws Exception {
        String sentence ="DELETE FROM public.integrantes WHERE nombres='"+nombres+"';" ;
        Conexion conexion = new Conexion();
        return conexion.borrar(sentence);
    }

    public long update() throws Exception {
        String sentence = "UPDATE public.integrantes SET direccion= '"+direccion+"', telefono= '"+telefono+"', \"fechaNac\"= '"+fechaNac+"'  " +
"	WHERE nombres= '"+nombres+"'; ";
        Conexion conexion = new Conexion();
        return conexion.actualizar(sentence);
    }
    
    public List<Customer> select() throws Exception {
        List<Customer> lista = new ArrayList<>();
        
        Conexion conn = new Conexion();
        //String nombres, String direccion, String telefono, String fechaNac
        ResultSet rs = conn.select("select * from integrantes;");
        while(rs.next()) {
            lista.add(new Customer(
                    rs.getString("nombres"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("fechaNac")
            ));
        }
        
        return lista;
    }
    
}
