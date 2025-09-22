
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ana", 7.5),
            new Student("Bruno", 5.8),
            new Student("Carla", 9.0),
            new Student("Daniel", 4.2),
            new Student("Eduarda", 6.7),
            new Student("Felipe", 8.3),
            new Student("Gabriela", 3.9)
        );

        System.out.println("LIST DE TODOS OS ALUNOS");
        students.forEach(System.out::println);

        System.out.println("\n------------------------------");
        System.out.println("ALUNOS APROVADOS (nota >= 7)");
        students.stream()
            .filter(s -> s.getGrade() >= 7)
            .forEach(System.out::println);

        System.out.println("\n------------------------------");
        System.out.println("ALUNOS ORDENADOS POR NOTA (maior -> menor)");
        students.stream()
            .sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
            .forEach(System.out::println);

        System.out.println("\n------------------------------");
        System.out.println("ALUNOS ORDENADOS POR NOME (A-Z)");
        students.stream()
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
            .forEach(System.out::println);

        System.out.println("\n---------------------------");
        System.out.println("LISTA DE NOMES DOS ALUNOS");
        students.stream()
            .map(Student::getName)
            .forEach(System.out::println);

        System.out.println("\n---------------------------");
        System.out.println("NOTAS * 2 (exemplo de transformação com map)");
        students.stream()
            .map(s -> s.getGrade() * 2)
            .forEach(System.out::println);

        System.out.println("\n---------------------------");
        System.out.println("LISTA DE APROVADOS (guardados em nova lista)");
        List<Student> aprovados = students.stream()
            .filter(s -> s.getGrade() >= 7)
            .toList();
        aprovados.forEach(System.out::println);

        System.out.println("\n========= FIM DO RELATÓRIO =========");

    }
}