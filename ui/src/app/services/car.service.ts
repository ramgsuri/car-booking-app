import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Car } from '../models/car.model';
import { Observable } from 'rxjs';
import { Booking } from '../models/booking.model';
import { UserService } from './user.service';

@Injectable({
    providedIn: 'root'
})
export class CarService {
    userType: string;
    userName: string;
    constructor(private httpClient: HttpClient, private userService: UserService) {
        this.userService.utype.subscribe(data => {
            this.userType = data;
        });

        this.userService.user.subscribe( data => {
            this.userName = data;
        });
    }

    public getAllCars(): Observable<Car[]> {
        if (this.userType === 'customer') {
            return this.httpClient.get<Car[]>('http://localhost:8080/car');
        } else {
            return this.getCarsByDealer();
        }
    }

    private getCarsByDealer(): Observable<Car[]> {
        return this.httpClient.get<Car[]>('http://localhost:8080/car/dealer/' + this.userName);
    }

    public addCar(car: Car): Observable<Car[]> {
        const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'});
        return this.httpClient.post<Car[]>('http://localhost:8080/car', car, {headers});
    }

    public updateCar(car: Car): Observable<Car[]> {
        const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'});
        return this.httpClient.put<Car[]>('http://localhost:8080/car', car, {headers});
    }

    public deleteCar(regNo: string) {
        return this.httpClient.delete<Car[]>('http://localhost:8080/car/' + regNo);
    }

    public booknow(booking: Booking) {
        const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'});
        return this.httpClient.post<Car[]>('http://localhost:8080/booking', booking, {headers});
    }

    public getMyBookings(user: string): Observable<Booking[]> {
        return this.httpClient.get<Booking[]>('http://localhost:8080/booking/' + this.userType + '/' + user);
    }
}
