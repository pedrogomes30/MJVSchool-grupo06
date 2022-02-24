public class School {
    public static void main(String[] args) {
        //java beans - getters e setters
        Student student = new Student();
        student.name = "ALOISIO";
        student.age=25;
        student.sex='M';
        student.color = "BLACK";
        

        Student student2 = new Student();
        student2.name = "PEDRO";
        student2.age=19;
        student2.sex='M';
        student2.color = "BLACK";

        System.out.println(student.name);

    }
}
