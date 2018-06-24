import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { TestComponent } from './test.component';
import { UserComponent } from './user/user.component';
import { AddUserComponent } from './user/add-user.component';
import { RetrieveCuspComponent } from './user/retrieve-cusp.component';
import { AppRoutingModule } from './app.routing.module';
import { UserService } from './user/user.service';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    UserComponent,
    AddUserComponent,
    RetrieveCuspComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }