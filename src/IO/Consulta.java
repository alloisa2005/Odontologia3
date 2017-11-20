/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class Consulta implements Serializable, Comparable<Consulta> {

    @OneToMany(mappedBy = "consulta")
    private List<LineaFactura> lineaFacturas;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descripcion;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    private Double monto;
    private boolean paga;
    
    @ManyToOne()
    private Paciente paciente;
    
    @ManyToOne
    private Medico medico;
    
    @ManyToMany
    private List<Pago> pagos;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<LineaFactura> getLineaFacturas() {
        return lineaFacturas;
    }

    public void setLineaFacturas(List<LineaFactura> lineaFacturas) {
        this.lineaFacturas = lineaFacturas;
    }
    
    public Double getMontoPagado(){
        Double montoPagado = 0.0;
        
        Iterator<Pago> it = this.getPagos().iterator();
        while (it.hasNext()) {
            montoPagado += it.next().getMonto();
        }
        return montoPagado;
    }        
    
    public Double getMontoAdeudado(){
        Double montoAdeudado = 0.0;
        Double montoPagos = 0.0;
        
        Iterator<Pago> it = this.getPagos().iterator();
        while (it.hasNext()) {
            Pago next = it.next();
            
            montoPagos += next.getMonto();
        }
        return this.getMonto() - montoPagos;
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
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }

    @Override
    public int compareTo(Consulta o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
