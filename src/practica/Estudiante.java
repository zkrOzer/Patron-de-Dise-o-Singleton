/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author krOzer
 */
@Entity
@Table(name = "ESTUDIANTE", catalog = "", schema = "ADMINISTRADOR")
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByNumcontrolL", query = "SELECT e FROM Estudiante e WHERE e.numcontrolL = :numcontrolL")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estudiante.findByEdad", query = "SELECT e FROM Estudiante e WHERE e.edad = :edad")
    , @NamedQuery(name = "Estudiante.findBySexo", query = "SELECT e FROM Estudiante e WHERE e.sexo = :sexo")
    , @NamedQuery(name = "Estudiante.findBySemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = :semestre")
    , @NamedQuery(name = "Estudiante.findByCreditos", query = "SELECT e FROM Estudiante e WHERE e.creditos = :creditos")
    , @NamedQuery(name = "Estudiante.findByIdcarrera", query = "SELECT e FROM Estudiante e WHERE e.idcarrera = :idcarrera")})
public class Estudiante implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMcontrolL")
    private Integer numcontrolL;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "EDAD")
    private Integer edad;
    @Column(name = "SEXO")
    private Character sexo;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "CREDITOS")
    private Integer creditos;
    @Column(name = "IDCARRERA")
    private Integer idcarrera;

    public Estudiante() {
    }

    public Estudiante(Integer numcontrolL) {
        this.numcontrolL = numcontrolL;
    }

    public Integer getNumcontrolL() {
        return numcontrolL;
    }

    public void setNumcontrolL(Integer numcontrolL) {
        Integer oldNumcontrolL = this.numcontrolL;
        this.numcontrolL = numcontrolL;
        changeSupport.firePropertyChange("numcontrolL", oldNumcontrolL, numcontrolL);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        Integer oldEdad = this.edad;
        this.edad = edad;
        changeSupport.firePropertyChange("edad", oldEdad, edad);
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        Character oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        Integer oldSemestre = this.semestre;
        this.semestre = semestre;
        changeSupport.firePropertyChange("semestre", oldSemestre, semestre);
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        Integer oldCreditos = this.creditos;
        this.creditos = creditos;
        changeSupport.firePropertyChange("creditos", oldCreditos, creditos);
    }

    public Integer getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Integer idcarrera) {
        Integer oldIdcarrera = this.idcarrera;
        this.idcarrera = idcarrera;
        changeSupport.firePropertyChange("idcarrera", oldIdcarrera, idcarrera);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numcontrolL != null ? numcontrolL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // botones: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.numcontrolL == null && other.numcontrolL != null) || (this.numcontrolL != null && !this.numcontrolL.equals(other.numcontrolL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practica.Estudiante[ numcontrolL=" + numcontrolL + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
