/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
@Entity
public class Paciente implements Serializable {

    @OneToMany(mappedBy = "paciente")
    private List<Factura> facturas;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    private static final long serialVersionUID = 1L;
    @Id    
    private String id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String celular;
    private Date fchNac;
    private byte[] foto;
    private String mail;
    private boolean activo;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFchNac() {
        return fchNac;
    }

    public void setFchNac(Date fchNac) {
        this.fchNac = fchNac;
    }

    public byte[] getFoto() {
        return foto;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }    

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public List<Consulta> getConsultas() {
        return consultas;
    }

    public ArrayList<Consulta> getConsultasPagas() {
        ArrayList<Consulta> lista = new ArrayList<>();
        
        Iterator<Consulta> it = this.getConsultas().iterator();
        while (it.hasNext()) {
            Consulta next = it.next();
            if(next.isPaga()){
                lista.add(next);
            }
        }
        return lista;
    }
    
    public ArrayList<Consulta> getConsultasImpagas() {        
        
        ArrayList<Consulta> lista = new ArrayList<>();        
        
        Iterator<Consulta> it = this.getConsultas().iterator();
        while (it.hasNext()) {
            Consulta next = it.next();
            if(!next.isPaga()){
                lista.add(next);
            }
        }        
        return lista;
    }
    
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    
    public Double getDeuda(){
        Double deuda = 0.0;
        Iterator<Consulta> it = this.getConsultas().iterator();
        while (it.hasNext()) {
            Consulta next = it.next();
             
            deuda += (next.getMonto() - next.getMontoPagado());            
        }
        return deuda;
    }                
    
    public ArrayList<Pago> getPagos(){
        ArrayList<Pago> lista = new ArrayList<>();
        
        Iterator<Consulta> it = this.getConsultas().iterator();
        while (it.hasNext()) {
            Consulta con = it.next();
            Iterator<Pago> pagos = con.getPagos().iterator();
            while (pagos.hasNext()) {
                Pago next = pagos.next();
                lista.add(next);
            }
        }
        return lista;
    }
    
    //Transforma el array de bytes en la foto
    public ImageIcon getFotoImage() {
        Image aux = new ImageIcon(foto).getImage();
        
        //El valor 150, depende del tamaño del visor a utilizar
        ImageIcon perfil = new ImageIcon(aux.getScaledInstance(228, 235, Image.SCALE_DEFAULT));
        return perfil;
    }

 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
}
