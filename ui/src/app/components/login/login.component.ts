import { Component } from '@angular/core';
import { Router } from '@angular/router';

import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import {LoginModel, LoginInterface} from '../../models/login.model';
import { UserService } from 'src/app/services/user.service';


/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
    isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
      const isSubmitted = form && form.submitted;
      return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
    }
  }

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
    loginData: LoginInterface;
    constructor(private userService: UserService, private router: Router) {
        this.userTypeFormControl.setValue('customer');
    }

    userTypeFormControl = new FormControl('', null);

    usernameFormControl = new FormControl('', [
        Validators.required
    ]);

    passwordFormControl = new FormControl('', [
        Validators.required
    ]);

    matcher = new MyErrorStateMatcher();

    login() {
        if (this.usernameFormControl.valid && this.passwordFormControl.valid) {
            this.loginData = new LoginModel();
            this.loginData.username = this.usernameFormControl.value;
            this.loginData.password = this.passwordFormControl.value;
            this.loginData.userType = this.userTypeFormControl.value;
            this.userService.login(this.loginData);
        }
    }

    register() {
        if (this.usernameFormControl.valid && this.passwordFormControl.valid) {
            this.loginData = new LoginModel();
            this.loginData.username = this.usernameFormControl.value;
            this.loginData.password = this.passwordFormControl.value;
            this.loginData.userType = this.userTypeFormControl.value;
            this.userService.login(this.loginData, true);
        }
    }

    newUser() {
        this.router.navigateByUrl('/register');
    }
}
