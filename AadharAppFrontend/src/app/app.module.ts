import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { UserregistrationComponent } from './userregistration/userregistration.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UpdatedetailsComponent } from './updatedetails/updatedetails.component';

const appRoutes: Routes = [
  {path: '', component:UserloginComponent},
  {path: 'signup', component:UserregistrationComponent},
  {path: 'dashboard', component:UserdashboardComponent},
  {path: 'updateaadhar', component:UpdatedetailsComponent},
  {path: 'adminsignin', component:AdminloginComponent},
  {path: 'admindashboard', component:AdmindashboardComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    AdmindashboardComponent,
    AdminloginComponent,
    UserdashboardComponent,
    UserregistrationComponent,
    UserloginComponent,
    UpdatedetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
