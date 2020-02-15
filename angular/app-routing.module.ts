import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { CreateDepartComponent } from './create-depart/create-depart.component';

const routes: Routes = [
  { path: 'employees', component: EmployeeListComponent },
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'add', component: CreateEmployeeComponent },
  { path: 'dep', component: CreateDepartComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
