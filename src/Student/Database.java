package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Database {
    void database(Student student) {
        try {
            String url = "jdbc:mysql://localhost:3306/smartstart08";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("insert into student values('" + student.getRollno() + "','" + student.getName() + "','" + student.getEmail() + "')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void readSingleStudent(int rollNo) {
        try {
            String url = "jdbc:mysql://localhost:3306/smartstart08";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where rollNo='" + rollNo + "'");
            while (rs.next()) {
                Student student = new Student();
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                System.out.println(student.getRollno());
                System.out.println(student.getName());
                System.out.println(student.getEmail());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void readAllStudents(){
        try {
            String url = "jdbc:mysql://localhost:3306/smartstart08";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()) {
                Student student = new Student();
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                System.out.println(student.getRollno());
                System.out.println(student.getName());
                System.out.println(student.getEmail());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    void updateSingleString(int rollNo, String name, String email) {
        try {
            if (name == null) {
                String url = "jdbc:mysql://localhost:3306/smartstart08";
                String user = "root";
                String pass = "";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement st = con.createStatement();
                st.executeUpdate("update student set email='" + email + "' where rollNo='" + rollNo + "'");
            } else {
                if (email == null) {
                    String url = "jdbc:mysql://localhost:3306/smartstart08";
                    String user = "root";
                    String pass = "";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, pass);
                    Statement st = con.createStatement();
                    st.executeUpdate("update student set name='" + name + "' where rollNo='" + rollNo + "'");
                } else {
                    String url = "jdbc:mysql://localhost:3306/smartstart08";
                    String user = "root";
                    String pass = "";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, user, pass);
                    Statement st = con.createStatement();
                    st.executeUpdate("update student set name='" + name + "',email='" + email + "' where rollNo='" + rollNo + "'");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void deleteSingleStudent(int rollNo){
        try{
            String url = "jdbc:mysql://localhost:3306/smartstart08";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("delete from student where rollNo='"+rollNo+"'");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    void deleteAllStudent(){
        try{
            String url = "jdbc:mysql://localhost:3306/smartstart08";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.executeUpdate("delete from student");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
