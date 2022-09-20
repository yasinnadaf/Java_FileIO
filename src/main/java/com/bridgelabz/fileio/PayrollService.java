package com.bridgelabz.fileio;

import java.util.List;

public interface PayrollService {
    public void writeData(List<EmployeePayrollData> employeePayrollDataList);
    public void readData();
    public long countEntries();
}
