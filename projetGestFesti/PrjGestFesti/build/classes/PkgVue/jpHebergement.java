/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgVue;

import PkgEntite.Etablissement;
import PkgEntite.Offre;
import PkgEntite.OffreId;
import PkgEntite.Typechambre;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Transaction;





/**
 *
 * @author DrkuHybride
 */
public final class jpHebergement extends javax.swing.JPanel {

    /**
     * Creates new form jpHebergement
     */
    
    public jpHebergement() 
    {
         initComponents();
         chargerEtabl();
         
    }
    
        // procédure de chargement de la liste déroulante des etablissements
        private void chargerEtabl()
        {
            /** 
             * on recupere les informations de la table Etablissement
             * puis on ajoute à la liste un élément avec le nom de l'établissement
            */
            String sReq = "From Etablissement";           
            jfPrincipal.getSession().beginTransaction();
            Query q = jfPrincipal.getSession().createQuery(sReq); 
            jcmbEtablissement.removeAllItems();            
            Iterator etabli = q.iterate(); 
            while (etabli.hasNext())
            {
                Etablissement unEtab = (Etablissement) etabli.next();
                jcmbEtablissement.addItem(unEtab.getEtaNom());
            }  
         }
        
        // fonction permettant de récuperer l'id de l'établissement avec le nom de l'établissement
        private String getEtabId(String pEtabNom)
        {       
            /** 
             * on recupere avec une requete sql l'id correspond au nom d'etablissement
             * puis on le retourne avec EtabId
            */
            String sReq = "From Etablissement Where Eta_Nom = ?";
            jfPrincipal.getSession().beginTransaction();
            Query q = jfPrincipal.getSession().createQuery(sReq);
            q.setParameter(0, pEtabNom);
            Etablissement  unEtab = (Etablissement)q.uniqueResult();          
            String EtabId =  (String) unEtab.getEtaId();
            return EtabId;                  
        }
       
         // procedure de chargement de la liste déroulante des types de chambres
        private void chargerTypCh()
        {
            /** 
             * on recupere tous les ids de la table type chambre et on les ajoute
             * dans la liste deroulante
             */
            String sReq = "From Typechambre";            
            jfPrincipal.getSession().beginTransaction();
            Query q = jfPrincipal.getSession().createQuery(sReq); 
            jcmbTypeCh.removeAllItems();          
            Iterator typch = q.iterate(); 
            while (typch.hasNext())
            {
                Typechambre uneTypech = (Typechambre) typch.next();
                jcmbTypeCh.addItem(uneTypech.getTchId());
            }           
       }
     
        
        // procedure de chargement des chambres avec l'id de l'établissement
        private void chargerChambres(String pEtaId)
        {
            /*
             * on charge le tableau de la liste des types de chambre correspondant 
             * à l'établissement selectionné dans la liste déroulante associée
             */
            int nbligne;
            int i;
            nbligne = jtableChambres.getRowCount();
            if(nbligne >= 0)
            {
                for(i=0;i <nbligne; i++)
                {
                    ((DefaultTableModel)jtableChambres.getModel()).removeRow(0);
                }
                String sReq = "From Offre Where Off_Etablissement = ?";
                Query q = jfPrincipal.getSession().createQuery(sReq);
                q.setParameter(0, pEtaId);
                Iterator tch = q.iterate();             
                while(tch.hasNext())
                {
                    Offre uneOffre = (Offre) tch.next();
                    ((DefaultTableModel) jtableChambres.getModel()).addRow(new Object[] {uneOffre.getTypechambre().getTchId(), uneOffre.getTypechambre().getTchLibelle(),  uneOffre.getOffNbchambres()});
                }
            
            
        }
    }
     
     // procedure de chargement des chambres avec l'id de l'établissement
     private void chargerNbChambres(String pEtaId, String pTchId)
     {        
         /** 
          * on charge le nombre de chambres correspondant à l'id de l'établissement et l'id du
          * type de chambre. Le nombre de chambres sera ensuite transmis au texte
          */
         String sReq = "From Offre Where Off_Etablissement = ? And Off_Typechambre = ?";
         Query q = jfPrincipal.getSession().createQuery(sReq);
         q.setParameter(0, pEtaId);
         q.setParameter(1, pTchId);
         Offre uneOffre = (Offre) q.uniqueResult();
        try
            {   
             Byte nbCh = uneOffre.getOffNbchambres();
               jtNbCh.setText(nbCh.toString());
            }
        catch (Exception e)
            {
                jtNbCh.setText("0");
            }
     }
     
     // procedure de modification des chambres avec l'id de l'établissement, l'id de type chambre et le nombre de chambres
     private void modifierNbChambres (String pEtaId, String pTchId, String pNbTyp)
     {
        /**
         * on recupere les offres avec l'id de l'établissement et l'id de type chambre
         * si il y a une offre on modifie le nombre de chambres 
         * sinon on créé une offre avec les données en paramètre.
         */
        int reply = JOptionPane.showConfirmDialog(null, "Voulez-vous réellement modifier ces informations ?", "Attention", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
        {
            String sReq = "From Offre Where Off_Typechambre = ? And Off_Etablissement = ?";
            Query q = jfPrincipal.getSession().createQuery(sReq);
            q.setParameter(0, pTchId);
            q.setParameter(1, pEtaId);
            Offre uneOffre = (Offre) q.uniqueResult();        
            String EtaId = (String) pEtaId;
            String TchId = (String) pTchId;
            Byte NbTyp = Byte.parseByte(pNbTyp);
            try
               {                
                    uneOffre.setOffNbchambres(NbTyp);
                    Transaction tx = jfPrincipal.getSession().beginTransaction();
                    tx.commit();
                    jfPrincipal.getSession().update(uneOffre);
                }
             catch (Exception e)
                {
                    OffreId uneOffreId = new OffreId(EtaId, TchId);
                    Typechambre uneTypCh = (Typechambre)jfPrincipal.getSession().load(Typechambre.class, TchId);
                    Etablissement unEta = (Etablissement)jfPrincipal.getSession().load(Etablissement.class, EtaId);
                    Offre uneOffreAdd =new Offre(uneOffreId, uneTypCh, unEta, NbTyp);
                    Transaction tx = jfPrincipal.getSession().beginTransaction();
                    jfPrincipal.getSession().save(uneOffreAdd); 
                    tx.commit();                                                                          
                } 
        }
     }
     
     // recuperation de l'id d'un etablissement avec le nom d'etablissement
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableChambres = new javax.swing.JTable();
        jlHebergementTitre = new javax.swing.JLabel();
        jcmbEtablissement = new javax.swing.JComboBox();
        jcmbTypeCh = new javax.swing.JComboBox();
        jtNbCh = new javax.swing.JTextField();
        jpModifier = new javax.swing.JButton();
        jlTypCh = new javax.swing.JLabel();
        jlNbCh = new javax.swing.JLabel();
        jbRecharger = new javax.swing.JButton();

        jtableChambres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Type", "Libelle", "Nombre chambres"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableChambres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableChambresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableChambres);

        jlHebergementTitre.setText("Hébergement");

        jcmbEtablissement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Collège de Moka" }));
        jcmbEtablissement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcmbEtablissementMouseClicked(evt);
            }
        });
        jcmbEtablissement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbEtablissementActionPerformed(evt);
            }
        });

        jcmbTypeCh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbTypeChActionPerformed(evt);
            }
        });

        jtNbCh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNbChActionPerformed(evt);
            }
        });

        jpModifier.setText("Modifier");
        jpModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpModifierActionPerformed(evt);
            }
        });

        jlTypCh.setText("Type chambre:");

        jlNbCh.setText("Nombre chambres:");

        jbRecharger.setText("Recharger");
        jbRecharger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRechargerMouseClicked(evt);
            }
        });
        jbRecharger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRechargerActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(23, 23, 23)
                        .add(jlTypCh)
                        .add(18, 18, 18)
                        .add(jcmbTypeCh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(49, 49, 49)
                        .add(jlNbCh)
                        .add(18, 18, 18)
                        .add(jtNbCh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(151, 151, 151)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jlHebergementTitre)
                            .add(layout.createSequentialGroup()
                                .add(jcmbEtablissement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jbRecharger)
                                .add(8, 8, 8))))
                    .add(layout.createSequentialGroup()
                        .add(164, 164, 164)
                        .add(jpModifier)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jlHebergementTitre)
                .add(30, 30, 30)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jcmbEtablissement, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jbRecharger))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 25, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 172, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jcmbTypeCh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jtNbCh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jlTypCh)
                    .add(jlNbCh))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpModifier)
                .add(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtableChambresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableChambresMouseClicked
        // TODO add your handling code here:
          
    }//GEN-LAST:event_jtableChambresMouseClicked

    private void jcmbEtablissementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbEtablissementActionPerformed
        // TODO add your handling code here:
        // code permettant de récupérer l'id correspondant au nom d'établissement selectionné
         
            // on definie la valeur de la variable EtabNom
           String EtabNom = (String) jcmbEtablissement.getSelectedItem();
           
            // si le nom n'est pas null on recupere l'id avec la fonction getEtabId et on charge les chambres
            if (EtabNom != null)
            {
                String EtabId = getEtabId(EtabNom);
                 chargerChambres(EtabId);
            }
            // on charge les types de chambre dans la liste deroulante correspondante
            chargerTypCh();
         
         

         
         
         
              
    }//GEN-LAST:event_jcmbEtablissementActionPerformed

    private void jcmbEtablissementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmbEtablissementMouseClicked
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jcmbEtablissementMouseClicked

    private void jcmbTypeChActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbTypeChActionPerformed
        // TODO add your handling code here:
        
        // on definie la valeur de la variable chambreCode
        String chambreCode = (String) jcmbTypeCh.getSelectedItem();  
        
        // on definie la valeur de la variable EtabNom
        String EtabNom = (String) jcmbEtablissement.getSelectedItem();  
        
            // si le nom n'est pas null on recupere l'id avec la fonction getEtabId et on charge le nombre de chambres
            if (EtabNom != null)
            {
                String EtabId = getEtabId(EtabNom);
                chargerNbChambres(EtabId, chambreCode);        
            }
        
       
        
    }//GEN-LAST:event_jcmbTypeChActionPerformed

    private void jtNbChActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNbChActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jtNbChActionPerformed

    private void jpModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpModifierActionPerformed
        // TODO add your handling code here:
        String TypCh = (String) jcmbTypeCh.getSelectedItem();
        String NbTyp = (String) jtNbCh.getText();
        String EtabNom = (String) jcmbEtablissement.getSelectedItem();
        
         // si le nom n'est pas null on recupere l'id avec la fonction getEtabId et on utilise la procedure modifierNbChambres
          if (EtabNom != null)
         {
            String EtabId = getEtabId(EtabNom);
            modifierNbChambres(EtabId, TypCh, NbTyp);         
         }
       
           
        
            
    }//GEN-LAST:event_jpModifierActionPerformed

    private void jbRechargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRechargerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbRechargerActionPerformed

    private void jbRechargerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRechargerMouseClicked
        // TODO add your handling code here:
        chargerEtabl();
    }//GEN-LAST:event_jbRechargerMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbRecharger;
    private javax.swing.JComboBox jcmbEtablissement;
    private javax.swing.JComboBox jcmbTypeCh;
    private javax.swing.JLabel jlHebergementTitre;
    private javax.swing.JLabel jlNbCh;
    private javax.swing.JLabel jlTypCh;
    private javax.swing.JButton jpModifier;
    private javax.swing.JTextField jtNbCh;
    private javax.swing.JTable jtableChambres;
    // End of variables declaration//GEN-END:variables
}
