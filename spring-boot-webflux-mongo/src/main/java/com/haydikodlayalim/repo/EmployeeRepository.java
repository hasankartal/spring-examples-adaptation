package com.haydikodlayalim.repo;

import com.haydikodlayalim.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String > {

}
