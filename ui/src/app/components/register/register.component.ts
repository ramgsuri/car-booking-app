import { Router } from '@angular/router';
import { Component } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {LoginModel, LoginInterface} from '../../models/login.model';
import { UserService } from 'src/app/services/user.service';
import { RegisterModel } from './../../models/register.model';


/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
    isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
      const isSubmitted = form && form.submitted;
      return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
    }
  }


@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent {

    registerData: RegisterModel;

    constructor(private userService: UserService, private router: Router) {
        this.userTypeFormControl.setValue('customer');
    }

    userTypeFormControl = new FormControl('', null);

    nameFormControl = new FormControl('', [
        Validators.required
    ]);

    contactFormControl = new FormControl('', [
        Validators.required
    ]);

    emailFormControl = new FormControl('', [
        Validators.required
    ]);
    usernameFormControl = new FormControl('', [
        Validators.required
    ]);
    passwordFormControl = new FormControl('', [
        Validators.required
    ]);

    matcher = new MyErrorStateMatcher();

    register() {
        if (this.usernameFormControl.valid && this.passwordFormControl.valid && this.nameFormControl.valid && this.contactFormControl.valid && this.emailFormControl.valid) {
            this.registerData = new RegisterModel();
            this.registerData.username = this.usernameFormControl.value;
            this.registerData.password = this.passwordFormControl.value;
            this.registerData.userType = this.userTypeFormControl.value;
            this.registerData.name = this.nameFormControl.value;
            this.registerData.contact = this.contactFormControl.value;
            this.registerData.email = this.emailFormControl.value;
            //this.userService.login(this.registerData, true);
            this.userService.register(this.registerData);
        }
    }

    login() {
        this.router.navigateByUrl('/login');
    }
}
