/*
 * Arden DUPONT
 */
package PkgVue;

import PkgEntite.Etablissement;
import PkgEntite.HibernateUtil;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class jpEtablissement extends javax.swing.JPanel
{
    public jpEtablissement()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        jfPrincipal.setSession(session);
        initComponents();
        chargerTable();
    }
    
    public void chargerTable()
    {
        //Chargement des éléments du tableau depuis la BDD Oracle
        int nbligne;
        int i;
        nbligne = jtEtablissement.getRowCount();
        if(nbligne > 0)
        {
            for(i=0;i <nbligne; i++)
            {
                ((DefaultTableModel)jtEtablissement.getModel()).removeRow(0);
            }
            //Chargement de la table Etablissement
            String sReq = "From Etablissement";

            Query etab = jfPrincipal.getSession().createQuery(sReq);
            Iterator tch = etab.iterate();
            while(tch.hasNext())
            {
                Etablissement unEtablissement = (Etablissement) tch.next();
                ((DefaultTableModel) jtEtablissement.getModel()).addRow(new Object[] {unEtablissement.getEtaId(), unEtablissement.getEtaNom()});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEtablissement = new javax.swing.JTable();
        jtEtabAdresse = new javax.swing.JTextField();
        jtEtabNom = new javax.swing.JTextField();
        jtEtabVille = new javax.swing.JTextField();
        jtEtabCP = new javax.swing.JTextField();
        jlEtabID = new javax.swing.JLabel();
        jlEtabVille = new javax.swing.JLabel();
        jlEtabCP = new javax.swing.JLabel();
        jlEtabAdresse = new javax.swing.JLabel();
        jlEtabNom = new javax.swing.JLabel();
        jlEtabNomResp = new javax.swing.JLabel();
        jlEtabPrenomResp = new javax.swing.JLabel();
        jlEtabResponsable = new javax.swing.JLabel();
        jlEtabCiviliteResp = new javax.swing.JLabel();
        jtEtabTel = new javax.swing.JTextField();
        jtEtabMail = new javax.swing.JTextField();
        jcEtabCiviliteResp = new javax.swing.JComboBox();
        jtEtabNomResp = new javax.swing.JTextField();
        jtEtabPrenomResp = new javax.swing.JTextField();
        jcEtabType = new javax.swing.JComboBox();
        jlEtabType = new javax.swing.JLabel();
        jlEtabMail = new javax.swing.JLabel();
        jlEtabTel = new javax.swing.JLabel();
        jbEtabSupprimer = new javax.swing.JButton();
        jbEtabModifier = new javax.swing.JButton();
        jtEtabID = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jtEtablissement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Code", "Nom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtEtablissement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEtablissementMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEtablissement);
        jtEtablissement.getColumnModel().getColumn(0).setResizable(false);

        jtEtabAdresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEtabAdresseActionPerformed(evt);
            }
        });

        jlEtabID.setText("ID*:");

        jlEtabVille.setText("Ville*:");

        jlEtabCP.setText("Code Postal*:");

        jlEtabAdresse.setText("Adresse*:");

        jlEtabNom.setText("Nom*:");

        jlEtabNomResp.setText("Nom*:");

        jlEtabPrenomResp.setText("Prénom*:");

        jlEtabResponsable.setText("Responsable:");

        jlEtabCiviliteResp.setText("Civilité*:");

        jcEtabCiviliteResp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "Mme" }));
        jcEtabCiviliteResp.setToolTipText("");
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

        jlEtabType.setText("Type*:");

        jlEtabMail.setText("E-mail:");

        jlEtabTel.setText("Téléphone*:");

        jbEtabSupprimer.setText("Supprimer");
        jbEtabSupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEtabSupprimerMouseClicked(evt);
            }
        });
        jbEtabSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEtabSupprimerActionPerformed(evt);
            }
        });

        jbEtabModifier.setText("Modifier");
        jbEtabModifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEtabModifierMouseClicked(evt);
            }
        });
        jbEtabModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEtabModifierActionPerformed(evt);
            }
        });

        jtEtabID.setText("Identifiant");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlEtabType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcEtabType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlEtabTel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtEtabTel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlEtabMail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtEtabMail)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jbEtabModifier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbEtabSupprimer))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlEtabID)
                                        .addGap(40, 40, 40)
                                        .addComponent(jtEtabID)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlEtabVille)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtEtabVille))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlEtabCP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtEtabCP))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlEtabAdresse)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtEtabAdresse))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlEtabNom)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtEtabNom)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlEtabCiviliteResp)
                                    .addComponent(jlEtabResponsable)
                                    .addComponent(jlEtabPrenomResp)
                                    .addComponent(jlEtabNomResp))))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtEtabNomResp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcEtabCiviliteResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtEtabPrenomResp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlEtabResponsable)
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jtEtabID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jtEtabNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlEtabID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlEtabNom)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlEtabAdresse)
                                    .addComponent(jtEtabAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlEtabCP)
                                    .addComponent(jtEtabCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlEtabPrenomResp)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlEtabVille)
                                        .addComponent(jtEtabVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlEtabTel)
                                    .addComponent(jtEtabTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlEtabMail)
                                    .addComponent(jtEtabMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlEtabType)
                                    .addComponent(jcEtabType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlEtabCiviliteResp)
                                    .addComponent(jcEtabCiviliteResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlEtabNomResp)
                                    .addComponent(jtEtabNomResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtEtabPrenomResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbEtabModifier)
                            .addComponent(jbEtabSupprimer))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtEtabAdresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEtabAdresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEtabAdresseActionPerformed

    private void jcEtabCiviliteRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEtabCiviliteRespActionPerformed
        //
    }//GEN-LAST:event_jcEtabCiviliteRespActionPerformed

    private void jcEtabTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEtabTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcEtabTypeActionPerformed

    private void jbEtabSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEtabSupprimerActionPerformed

      
    }//GEN-LAST:event_jbEtabSupprimerActionPerformed

    private void jbEtabModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEtabModifierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEtabModifierActionPerformed

    private void jtEtablissementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEtablissementMouseClicked
        //Selection des établissements afin de les afficher
        String sQuery;
        // On prend la valeur de la ligne
        int test = jtEtablissement.getSelectedRow();
        //System.out.println(test);
        Object sCode = jtEtablissement.getValueAt(test, 0);
        String etaCode = (String) sCode;
        if (etaCode != null)
        {
            // On va chercher les informations d'Etablissement
            sQuery = "From Etablissement Where ETA_ID =?";
   
            jfPrincipal.getSession().beginTransaction();
            Query q = jfPrincipal.getSession().createQuery(sQuery);
            q.setParameter(0, etaCode);
            Iterator etab = q.iterate();
            // Puis on les insert dans les champs correspondants à chaque données
            while(etab.hasNext())
            {
                Etablissement unEtablissement = (Etablissement)etab.next();

                String id = (String) unEtablissement.getEtaId();
                String nom = (String) unEtablissement.getEtaNom();
                String rue = (String) unEtablissement.getEtaRue();
                String cp = (String) unEtablissement.getEtaCp();
                String ville = (String) unEtablissement.getEtaVille();
                String tel = (String) unEtablissement.getEtaTel();
                String mail = (String) unEtablissement.getEtaMail();
                boolean type = (boolean) unEtablissement.isEtaType();
                String cr = (String) unEtablissement.getEtaCivilresp();
                String nr = (String) unEtablissement.getEtaNomresp();
                String pr = (String) unEtablissement.getEtaPrenomresp();

                jtEtabID.setText(id);
                jtEtabNom.setText(nom);
                jtEtabAdresse.setText(rue);
                jtEtabCP.setText(cp);
                jtEtabVille.setText(ville);
                jtEtabTel.setText(tel);
                jtEtabMail.setText(mail);
                jtEtabNomResp.setText(nr);
                jtEtabPrenomResp.setText(pr);
            }
        }
    }//GEN-LAST:event_jtEtablissementMouseClicked

    private void jbEtabModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEtabModifierMouseClicked
        //Modification des établissements 
        //Contrôle de saisies, selection obligatoire d'un établissement
        if (jtEtabID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner un établissement", "Attention", JOptionPane.WARNING_MESSAGE);
        }
        //Contrôle de saisie sur les champs, ils doivent être tous remplis à l'exection du champ mail.
        else if ((jtEtabID.getText().isEmpty()) || (jtEtabNom.getText().isEmpty()) || (jtEtabAdresse.getText().isEmpty()) || (jtEtabCP.getText().isEmpty()) || (jtEtabVille.getText().isEmpty()) || (jtEtabTel.getText().isEmpty()) || (jtEtabNomResp.getText().isEmpty()) || (jtEtabPrenomResp.getText().isEmpty()))
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
        // On récupère la saisie
        // On récupère le code de l'enregistrement que l'on veut supprimer puis on fait la requête
            int reply = JOptionPane.showConfirmDialog(null, "Voulez-vous réellement modifier cet établissement ?", "Attention", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                String EtaId = (String) jtEtabID.getText();
                String EtaNom = (String) jtEtabNom.getText();
                String EtaAdresse = (String) jtEtabAdresse.getText();
                String EtaCp = (String) jtEtabCP.getText();
                String EtaVille = (String) jtEtabVille.getText();
                String EtaTel = (String) jtEtabTel.getText();
                String EtaMail = (String) jtEtabMail.getText();
                String EtaNomResp = (String) jtEtabNomResp.getText();
                String EtaPrenomResp = (String) jtEtabPrenomResp.getText();
                String etaTyp = jcEtabType.getSelectedItem().toString();
                String etaCivil = "";
            
                Boolean etaType = Boolean.valueOf("False").booleanValue() ;
                if (etaTyp == "Etablissement scolaire")
                {
                   etaType = Boolean.valueOf("True").booleanValue() ;
                }
                if (jcEtabCiviliteResp.getSelectedItem() == "M")
                    {
                        etaCivil = "Monsieur";
                    }
                    else
                    {
                        etaCivil = "Madame" ;
                    }
                
                // On modifie les données dans la base
                String sReq = "From Etablissement Where Eta_Id =?";
                Query q = jfPrincipal.getSession().createQuery(sReq);
                q.setParameter(0, EtaId);
                Etablissement unEta = (Etablissement) q.uniqueResult();
                unEta.setEtaNom(EtaNom);
                unEta.setEtaRue(EtaAdresse);
                unEta.setEtaCp(EtaCp);
                unEta.setEtaVille(EtaVille);
                unEta.setEtaTel(EtaTel);
                unEta.setEtaMail(EtaMail);
                unEta.setEtaNomresp(EtaNomResp);
                unEta.setEtaPrenomresp(EtaPrenomResp);
                unEta.setEtaType(etaType);
                unEta.setEtaCivilresp(etaCivil);
            
                Transaction tx = jfPrincipal.getSession().beginTransaction();
                tx.commit();
                jfPrincipal.getSession().update(unEta);
            
                // On recharge le tableau
                chargerTable();
            }
        }
    }//GEN-LAST:event_jbEtabModifierMouseClicked

    private void jbEtabSupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEtabSupprimerMouseClicked
        //Suppression des établissement selectionnés 
         int reply = JOptionPane.showConfirmDialog(null, "Voulez-vous réellement supprimer cet établissement ?", "Attention", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                String EtaId = (String) jtEtabID.getText();
                String sReq = "From Etablissement Where Eta_Id =?";
                Query q = jfPrincipal.getSession().createQuery(sReq);
                q.setParameter(0, EtaId);
                Etablissement unEta = (Etablissement) q.uniqueResult();
                Transaction tx = jfPrincipal.getSession().beginTransaction();
                
                // On supprime l'enregistrement
                jfPrincipal.getSession().delete(unEta);
                
                // Puis on recharge la table
                chargerTable();
                jtEtabID.setText("");
                jtEtabNom.setText("");
                jtEtabAdresse.setText("");
                jtEtabCP.setText("");
                jtEtabVille.setText("");
                jtEtabTel.setText("");
                jtEtabMail.setText("");
                jtEtabNomResp.setText("");
                jtEtabPrenomResp.setText("");
                tx.commit();
            }
    }//GEN-LAST:event_jbEtabSupprimerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEtabModifier;
    private javax.swing.JButton jbEtabSupprimer;
    private javax.swing.JComboBox jcEtabCiviliteResp;
    private javax.swing.JComboBox jcEtabType;
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
    private javax.swing.JLabel jtEtabID;
    private javax.swing.JTextField jtEtabMail;
    private javax.swing.JTextField jtEtabNom;
    private javax.swing.JTextField jtEtabNomResp;
    private javax.swing.JTextField jtEtabPrenomResp;
    private javax.swing.JTextField jtEtabTel;
    private javax.swing.JTextField jtEtabVille;
    private javax.swing.JTable jtEtablissement;
    // End of variables declaration//GEN-END:variables

}
