import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ErrorsService {
  errors!: any[];

  constructor(private http: HttpClient) {}

  getError(id: number) {
    return this.errors.find((errors) => errors.id == id);
  }

  getErrorsAPI() {
    const headers = {
      'Access-Control-Allow-Origin': '*',
    };

    this.http
      .get<any>(
        'https://error-serverless-eda-epayroll-poc2.apps.xnkpeyx0.canadacentral.aroapp.io/json',
        { headers }
      )
      .subscribe({
        next: (data) => {
          this.errors = data;
        },
        error: (error) => {
          console.error('Error here: ', error);
        },
      });

    return this.http.get<any>(
      'https://error-serverless-eda-epayroll-poc2.apps.xnkpeyx0.canadacentral.aroapp.io/json',
      { headers }
    );
  }
}
