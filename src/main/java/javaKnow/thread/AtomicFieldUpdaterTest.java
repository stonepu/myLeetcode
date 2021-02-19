package javaKnow.thread;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicFieldUpdaterTest {

    static class Student{
        volatile String name;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        AtomicReferenceFieldUpdater<Student, String> studentNameFiledUpdater =
                AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
        studentNameFiledUpdater.compareAndSet(student, "", "");
    }
}
