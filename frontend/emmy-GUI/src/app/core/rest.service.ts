import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";

export class RestService<T> {

  private API_URL = "http://localhost:8080/api/";

  constructor(private http: HttpClient) {
  }

  get(url: string, adapter: any): Observable<T> {
    return this.http.get(this.API_URL + url)
      .pipe(
        map((data: any) => adapter.adapt(data))
      );
  }
}
