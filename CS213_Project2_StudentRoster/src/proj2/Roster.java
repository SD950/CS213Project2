/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
public class Roster {
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

    private static final int NOT_FOUND = -1;


    public Roster() {
        this.roster = new Student[4];
        this.size = 0;
    }


    private int find(Student student){
        for(int i = 0; i < size; i++){
            if(roster[i].getProfile()
            		.equals(student.getProfile())){
                return i;
            }
        }
        return NOT_FOUND;
    }
    
    private void grow(){
        Student[] temp 
        = new Student[size+4];
        for(int i = 0; i < size; i++){
            temp[i] 
            		= roster[i];
        }
        roster = temp;
    }


    public boolean add(Student student){
        if(find(student)
        		!= NOT_FOUND){
            return false;
        }
        if(size + 1 
        		== roster.length + 1){
            grow();
        }
        roster[size] 
        		= student;
        size++;
        return true;
    }

    public boolean remove(Student student){
        int index = find(student);
        if(index 
        		== NOT_FOUND){
            return false;
        }
        for(int j = index;
        		j < size-1; j++){
            roster[j] 
            		= roster[j+1];
        }
        roster[size-1] 
        		= null;
        size--;
        return true;
    }

    public Student studentFind(Student student) {
        int x = find(student);
        if (x == NOT_FOUND) {
            return null;
        }
        return roster[x];
    }

    public Student studyAbroadB(Student student) {
        int x = find(student);
        if (x != NOT_FOUND) {
            if (roster[x] instanceof International) {
                return roster[x];
            }
        }
        return null;
    }
    public Student financialAidB(Student student) {
        int x = find(student);
        if (x != NOT_FOUND) {
            if (roster[x] instanceof Resident) {
                return roster[x];
            }
        }
        return null;
    }


    public void printByName() {
        if (size == 0) {
            System.out.println("Student roster is empty!");

        } else {

            System.out.println("* list of students ordered by name **");
            Student[] temp = new Student[1];
            for (int x = 0; x < this.size; x++) {
                for (int n = x + 1; n < this.size; n++) {
                    if (roster[x].getProfile()
                    		.getName().compareTo(roster[n]
                    				.getProfile().getName()) > 0) {
                        temp[0] = roster[x];
                        roster[x] = roster[n];
                        roster[n] = temp[0];
                    }
                }
            }
            for (int r = 0; r < this.size; r++) {
                System.out.println(roster[r]);
            }
            System.out.println("* end of roster **");
        }
    }

    public void print() {
        if (size == 0) {
            System.out.println("Student roster is empty!");
        } else {
            System.out.println
            ("* list of students in the roster **");
            for (int x = 0; x 
            		< size; x++) {
                System.out.println(roster[x]);
            }
            System.out.println("* end of roster **");
        }
    }


    public void calculate() {
        for (int x = 0; x < size; x++) {
            if (!(roster[x].calculated())) {
                roster[x].tuitionDue();
            }
        }
    }
    public void printByPaymentDate() {
        if (size == 0) {
            System.out.println("Student roster is empty!");
        } else {
            int rosterBLen = 0;
            System.out.println
            ("* list of students made payments ordered by payment date **");
            for (int q = 0; q < size; q++) {
                if (roster[q].getDatePayLast() !=
                    null) {
                    rosterBLen++;
                }
            }
            Student[] rosterB = new Student[rosterBLen];
            Student[] temp = new Student[1];
            for (int x = 0; x < rosterBLen; x++) {
                for (int n = 0; n < size; n++) {
                    if (roster[n].getDatePayLast() != null) {
                        rosterB[x] = roster[n];
                        x++;
                    }
                }
            }
            for (int r = 0; r < rosterBLen; r++) {
                for (int s = 0; s < rosterBLen; s++) {
                    if ((r != s) &&
                        (((rosterB[r].getDatePayLast())
                            .compareTo((rosterB[s].getDatePayLast()))) < 0)) {
                        temp[0] = rosterB[r];
                        rosterB[r] = rosterB[s];
                        rosterB[s] = temp[0];
                    }
                }
            }
            for (int p = 0; p < rosterBLen; p++) {
                System.out.println(rosterB[p]);
            }
            System.out.println("* end of roster **");
        }
    }

}
