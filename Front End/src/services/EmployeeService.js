import axios from 'axios';

//Service Kısmı Burası. URL den nasıl veri aldığımızın mantığını buradan anlayabiliriz

const EMPLOYEE_APİ_BASE_URL="http://localhost:8080/api/V1/employees";

class EmployeeService{

    getEmployees() {
        return axios.get(EMPLOYEE_APİ_BASE_URL);


    }

    createEmployee(employee) {
        return axios.post(EMPLOYEE_APİ_BASE_URL, employee);
    }

    getEmployeeById(employeeId){    
        return axios.get(EMPLOYEE_APİ_BASE_URL + '/' + employeeId);
    }

    updateEmployee(employee , employeeId) {

        return axios.put(EMPLOYEE_APİ_BASE_URL + '/' +employeeId , employee);
    }

    deleteEmployee(employeeId) {

        return axios.delete(EMPLOYEE_APİ_BASE_URL + '/' +employeeId);
    }


}

export default new EmployeeService();