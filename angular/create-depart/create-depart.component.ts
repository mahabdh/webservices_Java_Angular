import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Departement } from '../Departement';
import { EmployeeService } from '../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-depart',
  templateUrl: './create-depart.component.html',
  styleUrls: ['./create-depart.component.css']
})
export class CreateDepartComponent implements OnInit {
  employee: Employee = new Employee();
  departement: Departement = new Departement();
  nbremp: number;
  nbrdep: number;

  submitted = false;

  constructor(private employeeService: EmployeeService,
    private router: Router) { }
  ngOnInit() {
  }
 /* newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
    this.departement = new Departement();
  }*/
  save() {
    this.employeeService.saveEmpDep(this.nbremp, this.nbrdep, this.employee, this.departement)
      .subscribe(
        data => console.log(data),
        error => console.log(error)
      );
    //this.employee = new Employee();
    //this.departement = new Departement();
    this.gotoList();
  }
  onSubmit() {
    this.employeeService.deleteAll();
    this.submitted = true;
    this.save();
  }
  gotoList() {
    this.router.navigate(['/employees']);
  }

}
