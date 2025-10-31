
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PayRollSystem{

    private ArrayList<Employee> List;

    public PayRollSystem()
    {
        List=new ArrayList<>();
    }

    public void addEmployee(Employee emp)
    {
       List.add(emp);
    }

    public void removeEmployee(int id)
    {
        Employee removed=null;
        for(Employee list:List)
        {
            if(list.getId()==id)
            {
                removed=list;
                break;
            }
           
        }

        if(removed!=null)
        {
            List.remove(removed);
        }
        else{
                System.out.println( "Employee not found");
            } 
    }

    public void displayEmployee()
    {
        for(Employee employee:List)
        {
            System.out.println(employee);
        }
    }
}