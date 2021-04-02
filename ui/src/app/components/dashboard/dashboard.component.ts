import { AddEditDialogComponent } from './../dialog/add-edit-dialog.component';
import { Component, ViewChild, OnInit, AfterViewInit } from '@angular/core';

import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { SelectionModel } from '@angular/cdk/collections';
import { CarService } from 'src/app/services/car.service';
import { UserService } from '../../services/user.service';
import { Car, CarModel } from '../../models/car.model';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import {AddEditDialogDataModel} from '../../models/add-edit-dialog-data.model';
import { Router } from '@angular/router';
import { BooknowDialogComponent } from '../dialog/booknow-dialog.component';
import { BookingModel} from '../../models/booking.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit, AfterViewInit {
  displayedColumns: string[];
  dataSource;
  isAdding = false;
  isSelected = false;
  selectedRow: Car;
  isEditing: false;
  car: Car;
  selection = new SelectionModel<Car>(true, []); // allowMultiple, initialSelection
  userType: string;
  locations: string[] = ['--None--', 'Virginia', 'Washington DC' , 'Florida', 'New York'];
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  pageSize = 10;

  constructor(private carService: CarService, private userService: UserService, private dialog: MatDialog, private router: Router) {
    console.log('Inside Dashboard constructor');
    if (this.userService.isLoggedIn) {
      this.userType = this.userService.userType;
      this.car = new CarModel();
      this.carService.getAllCars().subscribe(data => {
        const cars: Car[] = data;
        console.log(data);
        this.displayedColumns = ['brand', 'model', 'registrationNo', 'price', 'availability', 'locationId', 'dealerId', 'action'];
        this.dataSource = new MatTableDataSource(cars);

        setTimeout(() => {
          this.dataSource.sort = this.sort;
          this.dataSource.paginator = this.paginator;
        });
      });
    } else {
      this.router.navigateByUrl('/');
    }
  }

  ngOnInit() {
  }

  ngAfterViewInit() {
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle($event) {
    if ($event.checked) {
      this.onCompleteRow(this.dataSource);
    }
    this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.data.forEach(row => this.selection.select(row));
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: Car): string {
    if (!row) {
      return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.brand}`;
  }

  private selectRow($event, row) {
    console.log('checked: ' + $event.checked);
    if ($event.checked) {
      this.selectedRow = row;
      console.log(row);
    }
    this.onSelect($event.checked);
  }

  onCompleteRow(dataSource) {
    dataSource.data.forEach(element => {
      console.log(element.model);
    });
  }

  onSelect(isSelected) {
    this.isSelected = isSelected;
  }

  addCar() {
    this.carService.addCar(this.car).subscribe(data => {
      this.isAdding = false;
    });
  }

  addNewCar() {
    const addEditDialogData = new AddEditDialogDataModel();
    addEditDialogData.isEdit = false;
    const addEditDialog = this.dialog.open(AddEditDialogComponent, {
      width: '350px',
      height: '550px',
      data: addEditDialogData
    });

    addEditDialog.afterClosed().subscribe(data => {
      this.onAddEdit(data);
    });
  }
  editRow(row: Car) {
    const addEditDialogData = new AddEditDialogDataModel();
    addEditDialogData.isEdit = true;
    addEditDialogData.brand = row.brand;
    addEditDialogData.model = row.model;
    addEditDialogData.registrationNo = row.registrationNo;
    addEditDialogData.price = row.price;
    addEditDialogData.locationId = row.locationId;
    addEditDialogData.availability = row.availability;

    const addEditDialog = this.dialog.open(AddEditDialogComponent, {
      width: '350px',
      height: '550px',
      data: addEditDialogData
    });

    addEditDialog.afterClosed().subscribe(data => {
      this.onAddEdit(data);
    });
  }

  booknow(row: Car) {
    const bookingData = new BookingModel();
    bookingData.bookingId = 0;
    bookingData.carId = row.registrationNo;
    bookingData.customerId = this.userService.userName;
    bookingData.dealerId = row.dealerId;

    const booknowDialog = this.dialog.open(BooknowDialogComponent, {
      width: '450px',
      height: '550px',
      data: bookingData
    });

    booknowDialog.afterClosed().subscribe(data => {
      this.onBooking(data);
    });
  }

  onBooking(data) {
    console.log('Booking: ' + JSON.stringify(data));
    this.carService.booknow(data).subscribe((res) => {
      console.log('booknow resp: ' + JSON.stringify(res));
      /*
      this.carService.getAllCars().subscribe(resp => {
        console.log('latest resp after update: ' + JSON.stringify(resp));
        const cars: Car[] = resp;
        this.dataSource.data = cars;
      });
      */
      this.router.navigateByUrl('/booking');
    });
  }

  onAddEdit(data) {
      if (data) {
        const car = new CarModel();
        car.brand = data.brand;
        car.model = data.model;
        car.registrationNo = data.registrationNo;
        car.price = data.price;
        car.locationId = data.locationId;
        car.availability = data.availability;
        car.dealerId = this.userService.userName;

        if (data.isEdit) {
          this.carService.updateCar(car).subscribe((res) => {
            console.log('update resp: ' + JSON.stringify(res));
            this.carService.getAllCars().subscribe(resp => {
              console.log('latest resp after update: ' + JSON.stringify(resp));
              const cars: Car[] = resp;
              this.dataSource.data = cars;
            });
          });
        } else { // Add New
          this.carService.addCar(car).subscribe((res) => {
            console.log('add resp: ' + JSON.stringify(res));
            this.carService.getAllCars().subscribe(resp => {
              console.log('latest resp after addition: ' + JSON.stringify(resp));
              const cars: Car[] = resp;
              this.dataSource.data = cars;
            });
          });
        }
      } else {
        console.log('AddEdit Dialog Cancelled');
      }
  }

  onDelete(row: Car) {
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '300px',
      height: '250px',
      data: row
    });

    dialogRef.afterClosed().subscribe(data => {
      if (data) {
        console.log('The dialog was closed: ' + JSON.stringify(data));
        this.carService.deleteCar(data.registrationNo).subscribe(res => {
          console.log('delete resp: ' + JSON.stringify(res));
          this.carService.getAllCars().subscribe(resp => {
            console.log('latest resp after delete: ' + JSON.stringify(resp));
            const cars: Car[] = resp;
            this.dataSource.data = cars;
          });
        });
      }
    });
  }
}
