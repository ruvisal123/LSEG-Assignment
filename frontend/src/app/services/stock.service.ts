
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StockService {
  private apiUrl = 'http://localhost:8080/api/stocks';

  constructor(private http: HttpClient) { }

  getExchanges(): Observable<string[]> {
    return this.http.get<string[]>(this.apiUrl);
  }

  getStocks(exchange: string): Observable<any[]> {
    return this.http.get<any[]>(\`\${this.apiUrl}/\${exchange}\`);
  }

  getStockDetails(exchange: string, stockCode: string): Observable<any> {
    return this.http.get<any>(\`\${this.apiUrl}/\${exchange}/\${stockCode}\`);
  }
}
