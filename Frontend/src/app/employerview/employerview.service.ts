import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class EmployerService {
  employers!: any[];

  constructor(private http: HttpClient) {}

  getEmployerRecord(id: number) {
    return this.employers.find((employers) => employers.id == id);
  }

  getEmployersAPI() {
    const headers = {
      'Access-Control-Allow-Origin': '*',
    };

    this.http
      .get<any>(
        'http://epayroll-data-eda-epayroll-poc.apps.xnkpeyx0.canadacentral.aroapp.io/epayroll/processed',
        { headers }
      )
      .subscribe({
        next: (data) => {
          this.employers = data;
        },
        error: (error) => {
          console.error('Error here: ', error);
        },
      });

    return this.http.get<any>(
      'http://epayroll-data-eda-epayroll-poc.apps.xnkpeyx0.canadacentral.aroapp.io/epayroll/processed',
      { headers }
    );
  }
}
