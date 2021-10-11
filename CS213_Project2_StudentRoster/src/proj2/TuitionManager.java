/**
 * 
 */
package proj2;

/**
 * @author Stephen Danso, Sri Vishnu Jayakumar
 *
 */
import java.util.Scanner;


public class TuitionManager {
    private static final int maxCreds = 24;
    private static final int minCreds = 3;

    private static final int creditHoursB = 5;
    private static final int minCreditFull = 12;

    private Major major_in(String[] in) {
        Major major = null;
        if (in[2].equalsIgnoreCase("CS") || in[2].equalsIgnoreCase("IT")
                || in[2].equalsIgnoreCase("BA") || in[2].equalsIgnoreCase("EE") ||
                in[2].equalsIgnoreCase("ME")) {
            major = Major.valueOf(in[2].toUpperCase());
        }
        return major;
    }
    
    private boolean check_Major(String[] in) {
        if (in[2].equalsIgnoreCase("CS") 
        		|| in[2].equalsIgnoreCase("IT")
                || in[2].equalsIgnoreCase("BA")
                || in[2].equalsIgnoreCase("EE") ||
                in[2].equalsIgnoreCase("ME")) {
            return true;
        }
        System.out.println("'" + in[2] + "' is not a valid major.");
        return false;
    }


    private void instructionS(Roster rosterA, String[] in) {
        Student student = new Student(in[1], major_in(in), creditHoursB);
        
        if (rosterA.studentFind(student) == null) {
            System.out.println("Couldn't find the international student.");
            
        } 
        else if (rosterA.studyAbroadB(student) != null) {
            International international = (International) 
            		rosterA.studyAbroadB(student);
                international.setAbroadStatus(true);
                international.setTotalCreditHours(12);
                international.setTuitionDue(0);
                international.tuitionDue();
                international.setLastPaymentDate(null);
                System.out.println("Tuition updated.");            
        }
    }

    private void instructionF(Roster rosterA, String[] in) {
        Student student = new Student(in[1], major_in(in), creditHoursB);
        if (rosterA.studentFind(student) == null) {
            System.out.println("Student not in the roster.");
        } else if (rosterA.financialAidB(student) != null) {
            Resident res = (Resident) rosterA.financialAidB(student);
            if (res.financialAid()) {
                System.out.println
                ("Awarded once already.");
            } else if (res.getCreditHour() < minCreditFull) {
                System.out.println
                ("Parttime student doesn't qualify for the award.");
            } else {
                res.setAidAmountResident(Double.valueOf(in[3]));
                res.setAid(true);
                res.setAidAmount(Double.valueOf(in[3]));
                System.out.println("Tuition updated.");
            }
        } else {
            System.out.println("Not a res student.");
        }
    }







    private void instructionAT(Roster rosterA, String[] in) {

        if (in.length != 5) {
        	
            System.out.println
            ("Missing data in command line.");
            return;
        }
        if (!((in[4].equalsIgnoreCase("NY"))
        		|| in[4].equalsIgnoreCase("CT"))) {
        	
            System.out.println
            ("Not part of the tri-state area.");
            return;
        }
        TriState triState = new TriState(in[1], 
        		major_in(in), Integer.valueOf(in[3]), in[4].toUpperCase());
        if ((rosterA.add(triState))) {
            System.out.println("Student added.");
        } else {
            System.out.println
            ("Student is already in the roster.");
        }
    }
    private void instructionAN(Roster rosterA, String[] in) {
        NonResident nonResident = new NonResident(in[1], major_in(in), Integer.valueOf(in[3]));
        if (rosterA.add(nonResident)) {
            System.out.println("Student added.");
        } else {
            System.out.println
            ("Student is already in the roster.");
        }
    }

    private void instructionAR(Roster rosterA, String[] in) {
        Resident res = 
        		new Resident(in[1], major_in(in), Integer.valueOf(in[3]));
        if (rosterA.add(res)) {
        	
            System.out.println("Student added.");
        } else {
        	
            System.out.println("Student is already in the roster.");
        }
    }


    private boolean hoursCredit(String[] in) {
        if (!(in[3].matches("-?\\d+"))) {
        	
            System.out.println("Invalid credit hours.");
            return false;
        } else if (((Integer.valueOf(in[3]) < 0))) {
            System.out.println
            ("Credit hours cannot be negative.");
            return false;
            
        } else if (((Integer.valueOf(in[3]) < minCreds))) {
            System.out.println
            ("Minimum credit hours is 3.");
            return false;
            
        } else if (((Integer.valueOf(in[3]) > maxCreds))) {
            System.out.println
            ("Credit hours exceed the maximum 24.");
            return false;
        }
        return true;
    }

    private void instructionAI(Roster rosterA, String[] in) {
        International international = new International
        		(in[1], major_in(in), 
        				Integer.valueOf(in[3]), Boolean.valueOf(in[4]));
        if ((Integer.valueOf(in[3])
        		>= minCreditFull)) {
            if (rosterA.add(international)) {
                System.out.println("Student added.");
            }
        } else {
            System.out.println
            ("International students must enroll at least 12 credits.");
        }
    }






    private boolean rosterAddValid(String[] in) {
        if (in.length == 1) {
            System.out.println
            ("Missing data in command line.");
            return false;
        } else if (in.length == 2) {
        	
            System.out.println
            ("Missing data in command line.");
            return false;
        } else if (in.length == 3) {
            System.out.println("Credit hours missing.");
            
            return false;
        } else if (!(check_Major(in))) {
            return false;
        } else if (!(hoursCredit(in))) {
            return false;
        }
        return true;
    }


    private boolean instructionDel(Roster rosterA, String[] in) {
        Student student = new Student
        		(in[1], major_in(in), creditHoursB);
        if (rosterA.remove(student)) {
            System.out.println
            ("Student removed from the roster.");
            return true;
        } else {
            System.out.println("Student is not in the roster.");
            return false;
        }
    }

    private void calculateIn(Roster rosterA) {
        rosterA.calculate();
        
        System.out.println("Calculation completed.");
    }

    private boolean checkA(String[] in) {
        if (!(in[0].equals("C") || in[0].equals("P") || in[0].equals("PN") || in[0].equals("PT")
                || in[0].equals("Q"))) {
            System.out.println("Command '" + in[0] + "' not supported!");
            return false;
        }
        return true;
    }

    private boolean payVaild(Roster rosterA, String[] in) {
        if (in.length == 3) {
            System.out.println("Payment amount missing.");
            return false;
        } else if ((Double.valueOf(in[3]) == 0) 
        		|| (Double.valueOf(in[3]) < 0)) {
            System.out.println("Invalid amount.");
            return false;
        }
        Date payDate = 
        		new Date(in[4]);
        Student student = 
        		new Student(in[1], major_in(in), creditHoursB);
        double dueTuitionAmount = rosterA.studentFind(student).get_DueTuition();
        if (dueTuitionAmount < Double.valueOf(in[3])) {
            System.out.println("Amount is greater than amount due.");
            return false;
        } else if (!(payDate.isValid(payDate))) {
            System.out.println("Payment date invalid.");
            return false;
        }
        return true;
    }


    private void inputPay(Roster rosterA, String[] in) {
        Date payDate = new Date(in[4]);
        Student student = new Student(in[1], major_in(in), creditHoursB);
        Double dueTuitionAmount = rosterA.studentFind(student).get_DueTuition();
        dueTuitionAmount -= Double.valueOf(in[3]);
        rosterA.studentFind(student).setTuitionDue(dueTuitionAmount);
        rosterA.studentFind(student).setLastPaymentDate(payDate);
        rosterA.studentFind(student).setLastPayment(Double.valueOf(in[3]));
        System.out.println("Payment applied.");
    }

    private boolean valid_F(String[] in) {
        if (in.length == 3) {
            System.out.println("Missing the amount.");
            return false;
        } else if (((in[0].equals("F")) &&
                (((((Double.valueOf(in[3])) > 10000)) 
                		|| (Double.valueOf(in[3]) < 0))))) {
            System.out.println("Invalid amount.");
            return false;
        }
        return true;
    }

    
    
    private boolean checkInstruction(Roster rosterA, String line) {
        String[] in = line.split(",");
        if ((in[0].equals("F"))) {
            return valid_F(in);
        } else if (in[0].equals("AR") || in[0].equals("AN") 
        		|| in[0].equals("AI") || in[0].equals("AT")) {
            return rosterAddValid(in);
        } else if (in.length == 1) {
            return checkA(in);
        } else if (in[0].equals("T")) {
            return payVaild(rosterA, in);
        }
        return true;
    }
    
    
    private void instructionsUser(String line, Roster rosterA) {
        String[] in = line.split(",");
        if ((in[0].equals("AR"))) {
            instructionAR(rosterA, in);
        } else if ((in[0].equals("AN"))) {
            instructionAN(rosterA, in);
        } else if ((in[0].equals("AI"))) {
            instructionAI(rosterA, in);
        } else if ((in[0].equals("AT"))) {
        	
            instructionAT(rosterA, in);
        } else if ((in[0].equals("F"))) {
            instructionF(rosterA, in);
        } else if ((in[0].equals("P"))) {
        	
            rosterA.print();
        } else if ((in[0].equals("R"))) {
            instructionDel(rosterA, in);
        } else if (in[0].equals("C")) {
        	
            calculateIn(rosterA);
        } else if (in[0].equals("T")) {
            inputPay(rosterA, in);
        } else if (in[0].equals("S")) {
            instructionS(rosterA, in);
        } else if (in[0].equals("PN")) {
        	
            rosterA.printByName();
        } else if (in[0].equals("PT")) {
            rosterA.printByPaymentDate();
        } else if (in[0].equals("Q")) {
        	
            System.out.println("\nTuition Manager terminated.");
            System.exit(0);
        }

    }




    /**
    * Run the TuitionManager class.
    */
    public void run() {
        System.out.println("Tuition Manager starts running.");
        Roster rosters1 = new Roster();
        Scanner scanner = new Scanner(System.in);
        while (!(scanner.equals("Q"))) {
            String line = scanner.nextLine();
            if ((line.equals("\n")) || (line.equals(""))) {
                System.out.println("");
            } else if (checkInstruction(rosters1, line)) {
                instructionsUser(line, rosters1);
            }
        }
    }

}
