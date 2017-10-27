/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author User
 */
@Entity
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @OneToOne
    private Usuario usuario;
    
    private boolean pacientes;
    private boolean consultas;
    private boolean estadisticas;
    private boolean agenda;
    private boolean reportes;
    private boolean pagos;
    private boolean opciones;
    private boolean migracion;
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isPacientes() {
        return pacientes;
    }

    public void setPacientes(boolean pacientes) {
        this.pacientes = pacientes;
    }

    public boolean isConsultas() {
        return consultas;
    }

    public void setConsultas(boolean consultas) {
        this.consultas = consultas;
    }

    public boolean isEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(boolean estadisticas) {
        this.estadisticas = estadisticas;
    }

    public boolean isAgenda() {
        return agenda;
    }

    public void setAgenda(boolean agenda) {
        this.agenda = agenda;
    }

    public boolean isReportes() {
        return reportes;
    }

    public void setReportes(boolean reportes) {
        this.reportes = reportes;
    }

    public boolean isPagos() {
        return pagos;
    }

    public void setPagos(boolean pagos) {
        this.pagos = pagos;
    }

    public boolean isOpciones() {
        return opciones;
    }

    public void setOpciones(boolean opciones) {
        this.opciones = opciones;
    }

    public boolean isMigracion() {
        return migracion;
    }

    public void setMigracion(boolean migracion) {
        this.migracion = migracion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return usuario.getId();
    }
    
}
