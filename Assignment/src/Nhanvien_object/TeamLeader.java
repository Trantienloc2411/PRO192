package Nhanvien_object;

import java.util.ArrayList;

public class TeamLeader extends Developer {
    private double bonus_rate;

    public TeamLeader(String empID, String empName, int baseSal, String teamName, ArrayList <String> programmingLanguage, int expYear, double bonus_Rate) {
        super(teamName, expYear, empID, empName, baseSal);
        this.bonus_rate = bonus_rate;
    }

    public double getBonus_rate() {
        return bonus_rate;
    }
    @Override
    public double getSalary() {
        return super.getSalary() + bonus_rate * super.getSalary();
    }
    
    
    
}
