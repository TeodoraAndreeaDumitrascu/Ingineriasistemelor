package laborator4;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(x); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        Random random=new Random();
        for(int i =0; i<5;i++){
            x.add(random.nextInt(0,10));
        }
        for(int i =0; i<7;i++){
            y.add(random.nextInt(0,10));
        }
        Collections.sort(x);
        Collections.sort(y);

System.out.println("x="+x);
        System.out.println("x="+y);

//a) xPlusY conţine toate elementele şirurilor x şi y;
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        System.out.println(" xPlusY= "+xPlusY);

        //b) zSet conţine numai valorile comune din ambele şiruri, luate o singură dată;
        zSet.addAll(x);
        zSet.addAll(y);
        zSet.retainAll(y);
        System.out.println(" zSet= "+zSet);
        //c) xMinusY conţine valorile din şirul x care nu se află în şirul y;
        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println(" xMinusY= "+xMinusY);

        //d) xPlusYLimitedByP este mulţimea elementelor din x şi y ce nu depăşesc valoarea p.
        xPlusYLimitedByP.addAll(x);
        xPlusYLimitedByP.addAll(y);
        xPlusYLimitedByP.removeIf(element -> element > p);
        System.out.println(" xPlusYLimitedByP= "+xPlusYLimitedByP);


        // A doua parte - gestionarea studenților

        // A doua parte - gestionarea studenților
        List<Student> studenti = new ArrayList<>();

        // Încărcare studenți din fișier și numărare apariții
        Map<Student, Integer> studentCount = new HashMap<>();
        try {
            studenti = citireStudentiDinFisier("input.txt", studentCount);
            System.out.println("\n--- Studenți cititi din fisier ---");
            afiseazaStudenti(studenti);

            System.out.println("\n--- Numărare apariții studenți ---");
            for (Map.Entry<Student, Integer> entry : studentCount.entrySet()) {
                System.out.println(entry.getKey().getNumeComplet() + " (grupa " +
                        entry.getKey().getGrupa() + "): " + entry.getValue() + " apariții");
            }
        } catch (Exception e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
            e.printStackTrace();
        }
        // b1) Sortarea alfabetică, pe grupe
        System.out.println("\n--- Studenți sortați alfabetic, pe grupe ---");
        studenti.sort(Comparator.comparing(Student::getGrupa)
                .thenComparing(Student::getNumeComplet));
        afiseazaStudenti(studenti);

        // b2) Sortarea descrescătoare a mediilor pentru integraliști
        System.out.println("\n--- Integraliști sortați după medie (descrescător) ---");
        List<Student> integralisti = new ArrayList<>();
        for (Student s : studenti) {
            if (s.esteIntegralist()) {
                integralisti.add(s);
            }
        }
        integralisti.sort(Comparator.comparing(Student::getMedia).reversed());
        afiseazaStudenti(integralisti);

        // b3) Sortarea crescătoare a numărului de restanțe pentru restanțieri
        System.out.println("\n--- Restanțieri sortați după numărul de restanțe (crescător) ---");
        List<Student> restantieri = new ArrayList<>();
        for (Student s : studenti) {
            if (!s.esteIntegralist()) {
                restantieri.add(s);
            }
        }
        restantieri.sort(Comparator.comparing(Student::getNumarRestante));
        afiseazaStudenti(restantieri);
    }

    private static void afiseazaStudenti(List<Student> studenti) {
        for (Student s : studenti) {
            System.out.println(s);
        }
    }

    private static List<Student> citireStudentiDinFisier(String numeFisier, Map<Student, Integer> studentCount) throws Exception {
        List<Student> studenti = new ArrayList<>();
        Scanner scanner = new Scanner(new java.io.File(numeFisier));

        while (scanner.hasNextLine()) {
            String linie = scanner.nextLine();
            String[] parti = linie.split(" ");

            if (parti.length >= 4) { // Minim: nume prenume grupa nota1
                String prenume = parti[0];
                String nume = parti[1];
                String grupa = parti[2];
                List<Integer> note = new ArrayList<>();

                // Adăugăm toate notele disponibile
                for (int i = 3; i < parti.length; i++) {
                    try {
                        int nota = Integer.parseInt(parti[i]);
                        note.add(nota);
                    } catch (NumberFormatException e) {
                        System.err.println("Nota invalidă: " + parti[i]);
                    }
                }

                // Creăm studentul și îl adăugăm în listă
                Student student = new Student(nume, prenume, grupa, note);
                studenti.add(student);

                // Actualizăm numărul de apariții în map
                studentCount.put(student, studentCount.getOrDefault(student, 0) + 1);
            }
        }

        scanner.close();
        return studenti;
    }
}