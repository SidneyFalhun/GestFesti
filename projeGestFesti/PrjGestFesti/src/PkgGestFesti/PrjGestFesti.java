/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgGestFesti;
import PkgEntite.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import PkgEntite.Typechambre;
/**
 *
 * @author DrkuHybride
 */
public class PrjGestFesti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Session session = HibernateUtil.getSessionFactory().openSession();
        Typechambre uneNouvelleTypeCh = new Typechambre("b1", "50 lits");
        Transaction tx = session.beginTransaction();
        session.save(uneNouvelleTypeCh);
        tx.commit();
    }
}
