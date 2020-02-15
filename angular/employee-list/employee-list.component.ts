import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router'
import { Employee } from '../employee';

import { Observable } from 'rxjs';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[];
 motCle: string;
  

  constructor(private route: ActivatedRoute, private router: Router, private employeeService: EmployeeService) { }
  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.employeeService.getEmployeesList().subscribe(
      data => {
        console.log(data);
        this.employees = data;
      },
      err => {
        console.log(err);
      });
   
  }
  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id).subscribe(
      data => { console.log(data); this.reloadData(); },
      error => console.log(error));
  }
  employeeUpdate(id: number) {
    this.router.navigate(['update', id]);
  }

  doSearch() {
    this.employeeService.getEmployeesListR(this.motCle).subscribe(
      
      data => {
        console.log(data);
        this.employees = data;
      },
      err => {
        console.log(err);
      });
    console.log(this.motCle); 
  }
  chercher() {
    this.doSearch();
  }
}
