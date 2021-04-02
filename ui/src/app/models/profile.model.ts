export interface Profile {
    customerId: string;
    dealerId: string;
    name: string;
    contactNo: string;
    emailAddress: string;
}

export class ProfileModel implements Profile {
    customerId: string;
    dealerId: string;
    name: string;
    contactNo: string;
    emailAddress: string;

    constructor() {
        this.customerId = '';
        this.dealerId = '';
        this.name = '';
        this.contactNo = '';
        this.emailAddress = '';
    }
}
