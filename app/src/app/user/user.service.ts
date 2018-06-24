//This is the service class used for calling the Rest Service now
import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';
import { Cusp } from '../models/cusp.model';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService{

    constructor(private http:HttpClient) {}

    //private userUrl = 'http://localhost:8080/user-portal/user';
	private userUrl = 'http://localhost:8090/api/';
  private cusipUrl = 'http://localhost:8090/api/cusp/';


  public getUsers() {
    console.log("The response is"+this.http.get<User[]>(this.userUrl));
    return this.http.get<User[]>(this.userUrl);
  }

  public deleteUser(user) {
    return this.http.delete(this.userUrl + "/"+ user.id);
  }

  public createUser(user) {
    return this.http.post<User>(this.userUrl, user);
  }

  public getCusips(cusp) {
   // console.log("The response is"+this.http.get<Cusp[]>(this.cusipUrl,cusp));
    return this.http.get<Cusp[]>(this.cusipUrl+"/"+cusp.portfolio+"/"+cusp.date+"/"+cusp.openDate);
  }
}

