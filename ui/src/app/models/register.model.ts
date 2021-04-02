import { LoginModel } from './login.model';

export class RegisterModel extends LoginModel {
    name: string;
    contact: string;
    email: string;
    constructor() {
        super();
    }
}
