/*
 * Arden DUPONT
 */
package PkgVue;

import PkgEntite.Etablissement;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class jpEtabAjouter extends javax.swing.JPanel {

    /**
     * Creates new form jpEtabAjouter
     */
    public jpEtabAjouter() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlEtabAJouter = new javax.swing.JLabel();
        jlEtabID = new javax.swing.JLabel();
        jlEtabNom = new javax.swing.JLabel();
        jlEtabAdresse = new javax.swing.JLabel();
        jlEtabCP = new javax.swing.JLabel();
        jlEtabVille = new javax.swing.JLabel();
        jlEtabTel = new javax.swing.JLabel();
        jlEtabMail = new javax.swing.JLabel();
        jlEtabType = new javax.swing.JLabel();
        jlEtabResponsable = new javax.swing.JLabel();
        jlEtabCiviliteResp = new javax.swing.JLabel();
        jlEtabNomResp = new javax.swing.JLabel();
        jlEtabPrenomResp = new javax.swing.JLabel();
        jbEtabValider = new javax.swing.JButton();
        jbEtabAnnuler = new javax.swing.JButton();
        jtEtabID = new javax.swing.JTextField();
        jtEtabNom = new javax.swing.JTextField();
        jtEtabAdresse = new javax.swing.JTextField();
        jtEtabCP = new javax.swing.JTextField();
        jtEtabVille = new javax.swing.JTextField();
        jtEtabTel = new javax.swing.JTextField();
        jtEtabMail = new javax.swing.JTextField();
        jcEtabCiviliteResp = new javax.swing.JComboBox();
        jtEtabNomResp = new javax.swing.JTextField();
        jtEtabPrenomResp = new javax.swing.JTextField();
        jcEtabType = new javax.swing.JComboBox();

        jlEtabAJouter.setText("Ajouter un établissement");

        jlEtabID.setText("ID*:");

        jlEtabNom.setText("Nom*:");

        jlEtabAdresse.setText("Adresse*:");

        jlEtabCP.setText("Code Postal*:");

        jlEtabVille.setText("Ville*:");

        jlEtabTel.setText("Téléphone*:");

        jlEtabMail.setText("E-mail:");

        jlEtabType.setText("Type*:");

        jlEtabResponsable.setText("Responsable:");

        jlEtabCiviliteResp.setText("Civilité*:");

        jlEtabNomResp.setText("Nom*:");

        jlEtabPrenomResp.setText("Prénom*:");

        jbEtabValider.setText("Valider");
        jbEtabValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEtabValiderActionPerformed(evt);
            }
        });

        jbEtabAnnuler.setText("Annuler");
        jbEtabAnnuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEtabAnnulerMouseClicked(evt);
            }
        });

        jtEtabID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEtabIDActionPerformed(evt);
            }
        });

        jtEtabNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEtabNomActionPerformed(evt);
            }
        });

        jtEtabAdresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEtabAdresseActionPerformed(evt);
            }
        });

        jtEtabVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEtabVilleActionPerformed(evt);
            }
        });

        jtEtabTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEtabTelActionPerformed(evt);
            }
        });

        jcEtabCiviliteResp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "Mme" }));
        jcEtabCiviliteResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEtabCiviliteRespActionPerformed(evt);
            }
        });

        jcEtabType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Etablissement scolaire", "Autre" }));
        jcEtabType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEtabTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlEtabAJouter)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEtabTel)
                            .addComponent(jlEtabMail)
                            .addComponent(jlEtabType)
                            .addComponent(jlEtabResponsable)
                            .addComponent(jlEtabCiviliteResp)
                            .addComponent(jlEtabNomResp)
                            .addComponent(jlEtabPrenomResp)
                            .addComponent(jlEtabID)
                            .addComponent(jlEtabNom)
                            .addComponent(jlEtabAdresse)
                            .addComponent(jlEtabCP)
                            .addComponent(jlEtabVille))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtEtabTel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtEtabNomResp, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtEtabPrenomResp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtEtabID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(jtEtabNom, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtEtabAdresse, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtEtabCP, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtEtabVille, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtEtabMail, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jcEtabCiviliteResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcEtabType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jbEtabValider)
                        .addGap(30, 30, 30)
                        .addComponent(jbEtabAnnuler)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jlEtabAJouter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlEtabID)
                    .addComponent(jtEtabID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabNom)
                    .addComponent(jtEtabNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabAdresse)
                    .addComponent(jtEtabAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabCP)
                    .addComponent(jtEtabCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabVille)
                    .addComponent(jtEtabVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabTel)
                    .addComponent(jtEtabTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabMail)
                    .addComponent(jtEtabMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabType)
                    .addComponent(jcEtabType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jlEtabResponsable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabCiviliteResp)
                    .addComponent(jcEtabCiviliteResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabNomResp)
                    .addComponent(jtEtabNomResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEtabPrenomResp)
                    .addComponent(jtEtabPrenomResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEtabValider)
                    .addComponent(jbEtabAnnuler))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbEtabValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEtabValiderActionPerformed

         
        if (jfPrincipal.getSession().isOpen())
        {
            //Contrôle de saisie sur les champs, ils doivent être tous remplis à l'exection du champ mail.
            if ((jtEtabID.getText().isEmpty()) || (jtEtabNom.getText().isEmpty()) || (jtEtabAdresse.getText().isEmpty()) || (jtEtabCP.getText().isEmpty()) || (jtEtabVille.getText().isEmpty()) || (jtEtabTel.getText().isEmpty()) || (jtEtabNomResp.getText().isEmpty()) || (jtEtabPrenomResp.getText().isEmpty()))
            {
                JOptionPane.showMessageDialog(null, "Les champs avec un \"*\" doivent être obligatoirement remplis", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            //Contrôle sur le code établissement
            else if (jtEtabID.getText().length() >= 9)
            {
                JOptionPane.showMessageDialog(null, "Le code de l'établissement doit faire au maximum 8 caractères", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            //Contrôle sur le nom établissement
            else if (jtEtabNom.getText().length() >= 46)
            {
                JOptionPane.showMessageDialog(null, "Le nom de l'établissement doit faire au maximum 45 caractères", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            //Contrôle sur la rue
            else if (jtEtabAdresse.getText().length() >= 46)
            {
                JOptionPane.showMessageDialog(null, "La rue de l'établissement doit faire au maximum 45 caractères", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            //Contrôle sur la ville
            else if (jtEtabVille.getText().length() >= 36)
            {
                JOptionPane.showMessageDialog(null, "La ville de l'établissement doit faire au maximum 35 caractères", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            //Contrôle sur le code postal
            else if (jtEtabCP.getText().length() >= 6)
            {
                JOptionPane.showMessageDialog(null, "Le code postal de l'établissement doit faire au maximum 5 caractères", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            //Contrôle sur le tel
            else if (jtEtabTel.getText().length() >= 14)
            {
                JOptionPane.showMessageDialog(null, "Le numéro de telephone de l'établissement doit faire au maximum 13 caractères", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            //Contrôle sur le mail
            else if (jtEtabMail.getText().length() >= 71)
            {
                JOptionPane.showMessageDialog(null, "L'adresse mail de l'établissement doit faire au maximum 70 caractères", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            //Contrôle sur le nom du responsable
            else if (jtEtabNomResp.getText().length() >= 26)
            {
                JOptionPane.showMessageDialog(null, "Le nom du responsable doit faire au maximum 25 caractères", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            //Contrôle sur le prenom du responsable
            else if (jtEtabPrenomResp.getText().length() >= 26)
            {
                JOptionPane.showMessageDialog(null, "Le prénom du responsable doit faire au maximum 25 caractères", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                //On met la valeur de chaque élément du formulaire dans une variable
                String etaId = jtEtabID.getText().toString();
                String etaNom = jtEtabNom.getText().toString();
                String etaRue = jtEtabAdresse.getText().toString();
                String etaCp = jtEtabCP.getText().toString();
                String etaVille = jtEtabVille.getText().toString();
                String etaTel = jtEtabTel.getText().toString();
                String etaMail = jtEtabMail.getText().toString();
                String etaTyp = jcEtabType.getSelectedItem().toString();
                Boolean etaType = Boolean.valueOf("False").booleanValue() ;
                if (etaTyp == "Etablissement scolaire")
                {
                   etaType = Boolean.valueOf("True").booleanValue() ;
                }

                String etaCivilResp = jcEtabCiviliteResp.getSelectedItem().toString();
                String etaNomResp = jtEtabNomResp.getText().toString();
                String etaPrenomResp = jtEtabPrenomResp.getText().toString();

                // On recupere l'ID entré pour voir si cet ID existe déjà
                String sReq = "From Etablissement Where ETA_ID = '"+etaId+"'";
                Query id = jfPrincipal.getSession().createQuery(sReq);
                //Si l'ID est unique
                if (id.uniqueResult() == null)
                {
                    //Instanciation d'un nouvel objet Etablissement avec les propriétés privées et envois sur la bdd
                    Etablissement unEtablissement = new Etablissement();
                    unEtablissement.setEtaId(etaId);
                    unEtablissement.setEtaNom(etaNom);
                    unEtablissement.setEtaRue(etaRue);
                    unEtablissement.setEtaCp(etaCp);
                    unEtablissement.setEtaVille(etaVille);
                    unEtablissement.setEtaTel(etaTel);
                    unEtablissement.setEtaMail(etaMail);
                    unEtablissement.setEtaType(etaType);
                    if (etaCivilResp == "M")
                    {
                        unEtablissement.setEtaCivilresp("Monsieur");
                    }
                    else
                    {
                        unEtablissement.setEtaCivilresp("Madame");
                    }
                    
                    unEtablissement.setEtaNomresp(etaNomResp);
                    unEtablissement.setEtaPrenomresp(etaPrenomResp);
                    Transaction tx = jfPrincipal.getSession().beginTransaction();
                    jfPrincipal.getSession().save(unEtablissement);
                    tx.commit();
                    JOptionPane.showMessageDialog(null, "Ajout de l'établissement effectué avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                // Si l'ID existe déjà
                {
                    JOptionPane.showMessageDialog(null, "Ajout impossible, l'ID existe déjà", "Attention", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbEtabValiderActionPerformed

    private void jtEtabIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEtabIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEtabIDActionPerformed

    private void jtEtabAdresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEtabAdresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEtabAdresseActionPerformed

    private void jcEtabCiviliteRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEtabCiviliteRespActionPerformed
       //
    }//GEN-LAST:event_jcEtabCiviliteRespActionPerformed

    private void jcEtabTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEtabTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcEtabTypeActionPerformed

    private void jtEtabNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEtabNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEtabNomActionPerformed

    private void jtEtabVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEtabVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEtabVilleActionPerformed

    private void jtEtabTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEtabTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEtabTelActionPerformed

    private void jbEtabAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEtabAnnulerMouseClicked
        // TODO add your handling code here:
        jtEtabAdresse.setText("");
        jtEtabCP.setText("");
        jtEtabID.setText("");
        jtEtabMail.setText("");
        jtEtabNom.setText("");
        jtEtabNomResp.setText("");
        jtEtabPrenomResp.setText("");
        jtEtabTel.setText("");
        jtEtabVille.setText("");
    }//GEN-LAST:event_jbEtabAnnulerMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbEtabAnnuler;
    private javax.swing.JButton jbEtabValider;
    private javax.swing.JComboBox jcEtabCiviliteResp;
    private javax.swing.JComboBox jcEtabType;
    private javax.swing.JLabel jlEtabAJouter;
    private javax.swing.JLabel jlEtabAdresse;
    private javax.swing.JLabel jlEtabCP;
    private javax.swing.JLabel jlEtabCiviliteResp;
    private javax.swing.JLabel jlEtabID;
    private javax.swing.JLabel jlEtabMail;
    private javax.swing.JLabel jlEtabNom;
    private javax.swing.JLabel jlEtabNomResp;
    private javax.swing.JLabel jlEtabPrenomResp;
    private javax.swing.JLabel jlEtabResponsable;
    private javax.swing.JLabel jlEtabTel;
    private javax.swing.JLabel jlEtabType;
    private javax.swing.JLabel jlEtabVille;
    private javax.swing.JTextField jtEtabAdresse;
    private javax.swing.JTextField jtEtabCP;
    private javax.swing.JTextField jtEtabID;
    private javax.swing.JTextField jtEtabMail;
    private javax.swing.JTextField jtEtabNom;
    private javax.swing.JTextField jtEtabNomResp;
    private javax.swing.JTextField jtEtabPrenomResp;
    private javax.swing.JTextField jtEtabTel;
    private javax.swing.JTextField jtEtabVille;
    // End of variables declaration//GEN-END:variables

    private static class jcEtabType {

        private static Object getText() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public jcEtabType() {
        }
    }
}