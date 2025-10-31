public class PartTimeEmployee extends Employee {
    

   private int HourlyWork;
   private double HourlyRate;

   public PartTimeEmployee(String name,int id,int HourlyWork,double HourlyRate)
   {
    super(name, id);
    this.HourlyRate=HourlyRate;
    this.HourlyWork=HourlyWork;
   }

   @Override

   public double calculateSalary()
   {
    double PartTimeSalary=HourlyRate*HourlyWork;
    return PartTimeSalary;
   }
}
