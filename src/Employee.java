import java.util.Arrays;
import java.util.*;
import java.text.DecimalFormat;
public class Employee implements IEmployee{
    public String name;
    public double salary;
    public double workHours; // it defines weekly working hours. It might be like 40.5 that is the reason double definition
    public int hireYear;
    public  Employee(String name,float salary,double workHours,int hireYear) {
        this.name =name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    public double tax(double salary){
        return  salary > 1000 ? salary*0.03 : 0;
    }
    public double bonus(){
        // Assume that a month have 4 week which is the reason multiple 4 for bonus
        return this.workHours>40 ?  (this.workHours-40)*30*4 : 0;
    }
    public double raiseSalary(){

        double raiseAmountDue;
        double raiesedSalary = this.salary;
        int workingYear = 2021-this.hireYear;

        if (workingYear > 19 ){
            raiseAmountDue = this.salary * 0.15;
        }
        else if(workingYear > 9){
            raiseAmountDue = this.salary * 0.1;
        }
        else{
            raiseAmountDue = this.salary * 0.05;
        }
        raiesedSalary= raiesedSalary + bonus() +raiseAmountDue;
        raiesedSalary -=  tax(raiesedSalary);


        return  Math.round(raiesedSalary * 100.0) / 100.0;
    }
    public String toString() {
        String info = "Employee -> " +
                "\nName : " + name +
                "\nHired year : " + hireYear +
                "\nWorking hours : " + workHours +
                "\nBefore raised salary  : " + salary +
                "\nBonus : " + bonus() +
                "\nTax : " + Math.round((raiseSalary()-bonus()-salary) * 100.0) / 100.0 +
                "\nAfter raising salary  : " + raiseSalary();
        System.out.println(info);
        return super.toString();
    }
}
