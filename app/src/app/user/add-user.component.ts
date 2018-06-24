import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { UserService } from './user.service';

@Component({
  templateUrl: './add-user.component.html',
  styleUrls: []
})
export class AddUserComponent implements OnInit {

   user: User = new User();

  constructor(private router: Router, private userService: UserService) {

  }
  ngOnInit() {
  }

  createUser(): void {
    this.userService.createUser(this.user)
        .subscribe( data => {
          alert("User created successfully.");
        });

  };

}
