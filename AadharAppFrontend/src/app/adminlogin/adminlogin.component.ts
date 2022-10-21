import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminserviceService } from '../adminservice.service';


@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  signupForm: FormGroup;
  admin:Admin=new Admin();

  constructor(private adminServ:AdminserviceService, private router: Router,private fb: FormBuilder) { }

  ngOnInit(): void {
    this.signupForm = this.fb.group({
      username: 'Admin',
      password: 'Admin@123'
    });
  }

  onSubmit() {
    if(this.signupForm.value.username=="Admin" && this.signupForm.value.password=="Admin@123"){
      this.router.navigate(['/admindashboard']);
    }
    else{
      alert("Invalid credentials");
    }
  }

}
