package bai_tap;

public class TestLinkedList {
    public static void main(String[] args) {
        class Student{
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student studen1 = new Student(1,"Hải");
        Student studen2 = new Student(2,"Tru");
        Student studen3 = new Student(3,"Heo");
        Student studen4 = new Student(4,"Teo");
        Student studen5 = new Student(5,"Meo");
        myLinkedList.addFirst(studen1);
        myLinkedList.addFirst(studen2);
        myLinkedList.addFirst(studen3);
        myLinkedList.addFirst(studen4);

//        myLinkedList.add(2, studen4);

//        myLinkedList.remove(studen3);

//        MyLinkedList<Student> clone = myLinkedList.clone();

        System.out.println(myLinkedList.indexOf(studen2));


//        for(int i = 0 ; i< myLinkedList.size();i++){
//            Student student = (Student) myLinkedList.get(i);
//            System.out.println(student.getName());
//        }

    }
}
