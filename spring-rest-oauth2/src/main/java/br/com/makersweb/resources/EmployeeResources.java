/**
 * 
 */
package br.com.makersweb.resources;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.domain.Employee;

/**
*
* @author Anderson O. Aristides
*
*/
@RestController
@RequestMapping("/api")
public class EmployeeResources {
	
	private static Set<Employee> Employees;
	
	static {
		Employees = new HashSet<Employee>();
		Employee foobar = null;
		for (int i = 0; i < 10; i++) {
			double sal = new SecureRandom().nextInt(400)*500;
			foobar = new Employee(i, "Employee " + i, sal);
			Employees.add(foobar);
		}
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = {"application/json"})
	@ResponseBody
	public Employee getEmployee(@PathVariable int id) {
		Iterator<Employee> X = Employees.iterator();
        while (X.hasNext()) {
            Employee f = (Employee) X.next();
            if (f.getId() == id) return f;
        }
        return null;
	}

}
