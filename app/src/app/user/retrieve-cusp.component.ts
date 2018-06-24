import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cusp } from '../models/cusp.model';
import { UserService } from './user.service';

@Component({
  templateUrl: './retrieve-cusip.component.html',
  styleUrls: []
})
export class RetrieveCuspComponent implements OnInit {

   cusp: Cusp = new Cusp();
   
    cusps:Cusp[];
  //  currentUser: Cusp;

  constructor(private router: Router, private userService: UserService) {
     
  }
  ngOnInit() {
  }

  private retrieveAllCusip(cusp) {
  this.userService.getCusips(cusp).subscribe(cusps => { this.cusps = cusps; });
  };
}
