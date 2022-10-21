import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-updatedetails',
  templateUrl: './updatedetails.component.html',
  styleUrls: ['./updatedetails.component.css']
})
export class UpdatedetailsComponent implements OnInit {

  signupForm: FormGroup;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.signupForm = new FormGroup({
      phone_num: new FormControl(null, [Validators.required,Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")])
    });
  }

  onSubmit() {
    console.log(this.signupForm.value);
    alert("User details updated Successfully!")
    this.router.navigate(['/']);
  }

}
