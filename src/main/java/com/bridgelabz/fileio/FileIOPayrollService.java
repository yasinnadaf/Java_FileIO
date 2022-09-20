package com.bridgelabz.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileIOPayrollService implements PayrollService{
    final String FILE_PATH = "C:\\Java_FileIO\\src\\main\\java\\com\\bridgelabz\\fileio\\Payroll.txt";
    @Override
    public void writeData(List<EmployeePayrollData> employeePayrollDataList) {
        StringBuffer employeeBuffer = new StringBuffer();
        employeePayrollDataList.forEach(empData ->{
            String empString = empData.toString().concat("\n");
            employeeBuffer.append(empString);
        });
        try {
            Files.write(Path.of(FILE_PATH),employeeBuffer.toString().getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public void readData() {
        try {
            Files.lines(Path.of(FILE_PATH)).forEach(x -> System.out.println(x));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public long countEntries() {
        try {
            return Files.lines(Path.of(FILE_PATH)).count();
        } catch (IOException e) {
            System.out.println(e);
        }
        return 0;
    }
}
