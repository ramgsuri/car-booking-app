import { Injectable } from '@angular/core';
import { LoginInterface } from '../models/login.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { RegisterModel } from '../models/register.model';
import { Profile } from '../models/profile.model';

export class Resp {
    username: string;
    userType: string;
}

@Injectable({
    providedIn: 'root'
})
export class UserService {
    public isLoggedIn: boolean;
    public userName: string;
    public userType: string;

    public user = new BehaviorSubject<string>('');
    public utype = new BehaviorSubject<string>('');

    constructor(private httpClient: HttpClient, private router: Router) {
        this.isLoggedIn = false;
    }

    public login(loginData: LoginInterface, isNew?: boolean) {
        const headers = new HttpHeaders({'Content-Type' : 'application/json; charset=utf-8'});
        if (!isNew) {
            this.httpClient.post('http://localhost:8080/login', loginData, {headers}).subscribe(data => {
                if (data) {
                    this.isLoggedIn = true;
                    this.userName = (data as Resp).username;
                    this.userType = (data as Resp).userType;
                    this.updateUser(this.userName);
                    this.updateUserType(this.userType);
                    this.router.navigateByUrl('/dashboard');
                }
            });
        }
    }

    public register(registerData: RegisterModel) {
        const headers = new HttpHeaders({'Content-Type' : 'application/json; charset=utf-8'});
        const regData = {
            username: registerData.username,
            userType: registerData.userType,
            password: registerData.password,
            customerDto: {},
            dealerDto: {}
        };
        if (registerData.userType === 'customer') {
            regData.customerDto = {
                name: registerData.name,
                contactNo: registerData.contact,
                emailAddress: registerData.email,
                customerId: registerData.username
            };
        } else {
            regData.dealerDto = {
                name: registerData.name,
                contactNo: registerData.contact,
                emailAddress: registerData.email,
                dealerId: registerData.username
            };
        }
        this.httpClient.post('http://localhost:8080/register', regData, {headers}).subscribe(data => {
                if (data) {
                    this.isLoggedIn = true;
                    this.userName = registerData.username;
                    this.userType = registerData.userType;

                    this.updateUser(this.userName);
                    this.updateUserType(this.userType);
                    this.router.navigateByUrl('/dashboard');
                }
            });
    }

    public getProfile() {
        return this.httpClient.get<Profile>('http://localhost:8080/' + this.userType + '/' + this.userName);
    }

    public updateUser(userName: string) {
        this.userName = userName;
        this.user.next(userName);
    }

    public updateUserType(userType: string) {
        this.userType = userType;
        this.utype.next(userType);
    }
}

