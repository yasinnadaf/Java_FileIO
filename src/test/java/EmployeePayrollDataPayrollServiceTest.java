import com.bridgelabz.fileio.EmployeePayrollData;
import com.bridgelabz.fileio.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDataPayrollServiceTest {

     @Test
     public void givenThreeEmployeesWhenWrittenToFileShouldMatchEmployeeEntries(){
        EmployeePayrollData employee1 = new EmployeePayrollData(1,"Zain",50000);
        EmployeePayrollData employee2 = new EmployeePayrollData(2,"Bob",25000);
        EmployeePayrollData employee3 = new EmployeePayrollData(3,"Savi",35000);

        List<EmployeePayrollData> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        EmployeePayrollService employeePayrollService = new EmployeePayrollService(list);
        employeePayrollService.writeData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.readData(EmployeePayrollService.IOService.FILE_IO);
        long count = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3,count);

     }
}
