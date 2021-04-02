import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class MenuService {
    public isOpened = new BehaviorSubject<boolean>(false);
    public opened = false;
    public toggle() {
        //this.isOpened = !this.isOpened;
        this.opened = !this.opened;
        this.isOpened.next(this.opened);
    }
}