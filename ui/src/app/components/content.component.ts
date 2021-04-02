import { Component } from '@angular/core';
import { MenuService } from '../services/menu.service';
import { UserService } from '../services/user.service';
@Component({
    selector: 'app-content',
    templateUrl: './content.component.html',
    styleUrls: ['./content.component.css']
})
export class ContentComponent {
    opened = true;
    userType: string;
    constructor(private menuService: MenuService, private userService: UserService) {
        this.menuService.isOpened.subscribe(data => {
            this.opened = data;
        });

        this.userService.utype.subscribe(data => {
            this.userType = data;
            if (this.userType === '') {
                this.opened = false;
            }
        });
    }
}