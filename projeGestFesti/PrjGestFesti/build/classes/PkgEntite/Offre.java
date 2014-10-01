package PkgEntite;
// Generated 27 mars 2014 16:00:27 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Offre generated by hbm2java
 */
public class Offre  implements java.io.Serializable {


     private OffreId id;
     private Typechambre typechambre;
     private Etablissement etablissement;
     private byte offNbchambres;
     private Set attributions = new HashSet(0);

    public Offre() {
    }

	
    public Offre(OffreId id, Typechambre typechambre, Etablissement etablissement, byte offNbchambres) {
        this.id = id;
        this.typechambre = typechambre;
        this.etablissement = etablissement;
        this.offNbchambres = offNbchambres;
    }
    public Offre(OffreId id, Typechambre typechambre, Etablissement etablissement, byte offNbchambres, Set attributions) {
       this.id = id;
       this.typechambre = typechambre;
       this.etablissement = etablissement;
       this.offNbchambres = offNbchambres;
       this.attributions = attributions;
    }
   
    public OffreId getId() {
        return this.id;
    }
    
    public void setId(OffreId id) {
        this.id = id;
    }
    public Typechambre getTypechambre() {
        return this.typechambre;
    }
    
    public void setTypechambre(Typechambre typechambre) {
        this.typechambre = typechambre;
    }
    public Etablissement getEtablissement() {
        return this.etablissement;
    }
    
    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
    public byte getOffNbchambres() {
        return this.offNbchambres;
    }
    
    public void setOffNbchambres(byte offNbchambres) {
        this.offNbchambres = offNbchambres;
    }
    public Set getAttributions() {
        return this.attributions;
    }
    
    public void setAttributions(Set attributions) {
        this.attributions = attributions;
    }




}


