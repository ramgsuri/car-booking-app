import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { Profile, ProfileModel } from '../../models/profile.model';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
    userType: string;
    profile: Profile;
    constructor(private userService: UserService, private router: Router) {
        if (this.userService.isLoggedIn) {
            this.profile = new ProfileModel();
            this.userType = this.userService.userType;
            this.userService.getProfile().subscribe(data => {
                console.log('profile resp: ' + JSON.stringify(data));
                this.profile = data as Profile;
            });
        } else {
            this.router.navigateByUrl('/');
        }
    }
}