import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Persistence;
import javax.swing.*;

import static java.lang.Thread.sleep;

public class Opg3 {

    public static void main(String[] args) throws Exception {


/*
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
        */

        Runnable runnable = () -> {
            int error = 0;

            while (error == 0) {
                try {

                    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
                    EntityManager entityManager = entityManagerFactory.createEntityManager();

                    Konto fraKonto = entityManager.find(Konto.class, 1);
                    Konto tilKonto = entityManager.find(Konto.class, 2);

                    double belop = 20;
                    fraKonto.trekk(belop);
                    tilKonto.leggTil(belop);

                    System.out.println("gjennomgang");


                    entityManager.getTransaction().begin();
                    entityManager.getTransaction().commit();
                    entityManagerFactory.close();

                    error = 1;
                } catch (Exception e) {
                    error = 0;
                }


            }


        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
