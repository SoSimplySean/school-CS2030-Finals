// Write your solution in this file only.
//
import java.util.List;

abstract class Student {
    private final static double CAP = 5.0;
    
    double getCAP() {
        return CAP;
    }

    abstract double getLoan();
    abstract String getId(); 
}

class UG extends Student {
    private final String id;
    private final static double LOAN = 99.99;

    UG(String id) {
        this.id = id;
    }

    @Override
    double getLoan() {
        return LOAN;
    }

    @Override
    String getId() {
        return this.id;
    }
}


class PG extends Student {
    private final String id;
    private final static double LOAN = 111.11;

    PG(String id) {
        this.id = id;
    }

    @Override
    double getLoan() {
        return LOAN;
    }

    @Override
    String getId() {
        return this.id;
    }
}

class Admin {

    Admin() {}

    void process(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student temp = students.get(i);
            System.out.println(String.format("%1$s : %2$s", temp.getId(), temp.getCAP()));
        }
    }
}


class Bursar {

    Bursar() {}

    void process(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student temp = students.get(i);
            System.out.println(String.format("%1$s : %2$s", temp.getId(), temp.getLoan()));
        }
    }
}



