export interface LoginInterface {
    username: string;
    password: string;
    userType: string;
}

export class LoginModel implements LoginInterface {
    username: string;
    password: string;
    userType: string;

    constructor() {
        this.username = '';
        this.password = '';
        this.userType = '';
    }
}

