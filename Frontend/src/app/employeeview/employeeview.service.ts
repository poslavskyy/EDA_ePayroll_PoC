import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class EmployeeService {
  employees!: any[];

  constructor(private http: HttpClient) {}

  getEmployeeRecord(id: number) {
    return this.employees.find((employees) => employees.id == id);
  }

  getEmployeesAPI() {
    const headers = {
      'Access-Control-Allow-Origin': '*',
    };

    this.http
      .get<any>(
        'https://epayroll-data-db-serverless-eda-epayroll-poc2.apps.xnkpeyx0.canadacentral.aroapp.io/epayroll/processed',
        { headers }
      )
      .subscribe({
        next: (data) => {
          this.employees = data;
        },
        error: (error) => {
          console.error('Error here: ', error);
        },
      });

    return this.http.get<any>(
      'https://epayroll-data-db-serverless-eda-epayroll-poc2.apps.xnkpeyx0.canadacentral.aroapp.io/epayroll/processed',
      { headers }
    );
  }
}
