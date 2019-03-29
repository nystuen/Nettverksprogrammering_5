import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        Konto iliaSinRad = new Konto();
        iliaSinRad.setName("Ilia Rad");
        iliaSinRad.setSaldo(711);

        Konto magnus = new Konto();
        magnus.setName("Magnus");
        magnus.setSaldo(99);

        System.out.println("Alle Eiere:");
        System.out.println("ilern: " + iliaSinRad.getName());
        System.out.println("magnus saldo: " + magnus.getSaldo());

        magnus.trekk(90);

        System.out.println("magnus saldo etter trekk: " + magnus.getSaldo());

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

            entityManager.persist(iliaSinRad);
            entityManager.persist(magnus);

        entityManager.getTransaction().commit();

        entityManagerFactory.close();


    }
}
