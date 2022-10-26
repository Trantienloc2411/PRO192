package Nhanvien_object;

import java.util.ArrayList;

public class Developer extends Employee{
    protected String teamName;
    protected ArrayList <String> programmingLanguage = new ArrayList<> ();
    protected int expYear;

    //constructor
    public Developer(String teamName, int expYear, String empID, String empName, int baseSal) {
        super(empID, empName, baseSal);
        this.teamName = teamName;
        this.expYear = expYear;
        this.programmingLanguage = programmingLanguage;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<String> getProgrammingLanguage() {
        return programmingLanguage;
    }

    public int getExpYear() {
        return expYear;
    }

    
    @Override
    public double getSalary() {
        if (expYear >= 5) return baseSal + expYear * 2000000;
        else if(expYear >= 3) return baseSal + expYear * 1000000;
        else return baseSal;
    }

    @Override
    public String toString() {
        return  empID +"_"+baseSal+"_"+teamName+"_"+"["+programmingLanguage+"]_"+expYear;
    }
    
}
