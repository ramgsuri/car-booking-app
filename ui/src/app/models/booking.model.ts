interface Booking {
    bookingId: number;
    carId: string;
    customerId: string;
    dealerId: string;
    startDate: Date;
    endDate: Date;
}
class BookingModel implements Booking {
    bookingId: number;
    carId: string;
    customerId: string;
    dealerId: string;
    startDate: Date;
    endDate: Date;

    constructor() {
        this.bookingId = 0;
        this.carId = '';
        this.customerId = '';
        this.dealerId = '';
        this.startDate = new Date();
        this.endDate = new Date();
    }
}
export {Booking, BookingModel};
