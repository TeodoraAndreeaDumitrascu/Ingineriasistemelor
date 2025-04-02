package laborator4;

import java.util.*;

class Student {
    private String numeComplet;
    private String grupa;
    private List<Integer> note;

    public Student(String numeComplet, String grupa) {
        this.numeComplet = numeComplet;
        this.grupa = grupa;
        this.note = new ArrayList<>(5);

        // a) Generare note aleatoare in intervalul [4..10]
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            note.add(random.nextInt(7) + 4); // 4 la 10 inclusiv
        }
    }

    public Student(String nume, String prenume, String grupa, List<Integer> note) {
        this.numeComplet = prenume + " " + nume;
        this.grupa = grupa;
        this.note = new ArrayList<>(note);
    }

    public String getNumeComplet() {
        return numeComplet;
    }

    public String getGrupa() {
        return grupa;
    }

    public List<Integer> getNote() {
        return note;
    }

    public double getMedia() {
        int suma = 0;
        for (Integer nota : note) {
            suma += nota;
        }
        return (double) suma / note.size();
    }

    public int getNumarRestante() {
        int count = 0;
        for (Integer nota : note) {
            if (nota < 5) {
                count++;
            }
        }
        return count;
    }

    public boolean esteIntegralist() {
        return getNumarRestante() == 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "numeComplet='" + numeComplet + '\'' +
                ", grupa='" + grupa + '\'' +
                ", note=" + note +
                ", media=" + String.format("%.2f", getMedia()) +
                ", restante=" + getNumarRestante() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(numeComplet, student.numeComplet) &&
                Objects.equals(grupa, student.grupa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeComplet, grupa);
    }
}