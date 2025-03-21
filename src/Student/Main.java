package Student;

import sun.security.x509.InvalidityDateExtension;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.createSingleStudent\n2.createMultipleStudent\n3.readSingleStudent\n4.readMultipleStudent\n5.readAllStudent\n6.updateSingleStudent\n7.updateMultipleStudent\n8.deleteSingleStudent\n9.deleteMultipleStudent\n10.deleteAllStudent");
        int choice=scanner.nextInt();
        switch (choice){
            case 1:{
                createSingleStudent();
                break;
            }
            case 2:{
                createMultipleStudent();
                break;
            }
            case 3:{
                readSingleStudent();
                break;
            }
            case 4:{
                readMultipleStudent();
                break;
            }
            case 5:{
                readAllStudents();
                break;
            }
            case 6:{
                updateSingleStudent();
                break;
            }
            case 7:{
                updateMultipleStudent();
                break;
            }
            case 8:{
                deleteSingleStudent();
                break;
            }
            case 9:{
                deleteMultipleStudent();
                break;
            }
            case 10:{
                deleteAllStudent();
                break;
            }
        }
        //        readSingleStudent();
//        updateSingleStudent();
//        readSingleStudent();
//        deleteSingleStudent();
    }

    static void createSingleStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        student.setRollNo(scanner.nextInt());
        student.setName(scanner.next());
        student.setEmail(scanner.next());
        Database database = new Database();
        database.database(student);
    }
    static void createMultipleStudent(){
        Database database=new Database();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the no. of students");
        int size= scanner.nextInt();
//        Student[] students=new Student[size];
        for(int i=0;i<size;i++) {
            Student student = new Student();
            student.setRollNo(scanner.nextInt());
            student.setName(scanner.next());
            student.setEmail(scanner.next());
            database.database(student);
//            students[i]=student;
        }
//        database.createMultipleStudent(students);
    }
    static void readSingleStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rollNo");
        int rollNo = scanner.nextInt();
        Database database = new Database();
        database.readSingleStudent(rollNo);
    }
    static void readMultipleStudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the no of students");
        int size= scanner.nextInt();
        int[] rollNos=new int[size];
        System.out.println("Enter roll nos.");
        for(int i=0;i<size;i++){
            rollNos[i]= scanner.nextInt();
        }
        for(int i=0;i<size;i++){
            Database database=new Database();
            database.readSingleStudent(rollNos[i]);
        }
    }
    static void readAllStudents(){
        Database database=new Database();
        database.readAllStudents();
    }

    static void updateSingleStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter update choice");
        System.out.println("1.name\n2.email\n3.forboth");
        System.out.println("enter choice");
        int ch = scanner.nextInt();
        Database database = new Database();
        switch (ch) {
            case 1: {
                System.out.println("Enter roll no");
                int rollNo = scanner.nextInt();
                System.out.println("Enter name");
                String name = scanner.next();
                database.updateSingleString(rollNo,name,null);
                break;
            }
            case 2: {
                System.out.println("Enter roll no");
                int rollNo = scanner.nextInt();
                System.out.println("Enter email");
                String email = scanner.next();
                database.updateSingleString(rollNo,null,email);
                break;
            }
            case 3: {
                System.out.println("Enter rollno");
                int rollNo = scanner.nextInt();
                System.out.println("Enter name");
                String name = scanner.next();
                System.out.println("Enter email");
                String email = scanner.next();
                database.updateSingleString(rollNo,name,email);
                break;
            }
        }
    }
    static void updateMultipleStudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter no of students");
        int size= scanner.nextInt();
        for(int i=0;i<size;i++){
            updateSingleStudent();
        }
    }
    static void deleteSingleStudent(){
        Scanner scanner=new Scanner(System.in);
        int rollNo=scanner.nextInt();
        Database database=new Database();
        database.deleteSingleStudent(rollNo);
    }
    static void deleteMultipleStudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter size");
        int size= scanner.nextInt();
//        int roll[]=new int[size];
        for(int i=0;i<size;i++){
            System.out.println("Enter roll no.");
            Database database=new Database();
            database.deleteSingleStudent(scanner.nextInt());
        }
    }
    static void deleteAllStudent(){
        Database database=new Database();
        database.deleteAllStudent();
    }
}