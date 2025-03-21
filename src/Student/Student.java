package Student;

public class Student {
    int rollNo;
    String name,email;
    //Setter
    void setRollNo(int rollNo){
        this.rollNo=rollNo;
    }
    void setName(String name){
        this.name=name;
    }
    void setEmail(String email){
        this.email=email;
    }
    //Getter
    int getRollno(){
        return rollNo;
    }
    String getName(){
        return name;
    }
    String getEmail(){
        return email;
    }
}
