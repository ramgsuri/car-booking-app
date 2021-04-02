import { Component } from '@angular/core';
import { UserService } from '../services/user.service';
import { MenuService } from '../services/menu.service';
import { Router } from '@angular/router';


@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
export class HeaderComponent {
    userName = '';
    userType = '';
    constructor(private userService: UserService, private router: Router, private menuService: MenuService) {
        this.userService.user.subscribe(data => this.userName = data);
        this.userService.utype.subscribe(data => this.userType = data);
    }
    signOut() {
        this.userName = '';
        this.userType = '';
        this.userService.updateUser(this.userName);
        this.userService.updateUserType(this.userType);
        this.router.navigateByUrl('/');
    }
    toggleMenu() {
        this.menuService.toggle();
    }
}