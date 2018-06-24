import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { Router } from '@angular/router';
import { UserService } from './user.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users:User[];

  //We need to populate the data in the User,so need to call the service now
  //Make a user service will be calling for the retrieval of the data.

  constructor(private router: Router, private userService: UserService) {

  }

  ngOnInit() {

    //we can get the list of the users to be there
    var value=  this.userService.getUsers().subscribe(data=>this.users=data);
    console.log("The value is"+value);
   // this.userService.getUsers().subscribe(data=>this.users=data);
    
  };


  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      })
  };

}
