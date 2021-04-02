import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BookingModel } from '../../models/booking.model';

@Component({
    selector: 'app-booknow-dialog',
    templateUrl: './booknow-dialog.component.html'
})
export class BooknowDialogComponent {
    isStartDateValid = true;
    today = new Date();
    constructor(public dialogRef: MatDialogRef<BooknowDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: BookingModel) {
    }

    onSave(): void {
       this.dialogRef.close(this.data);
    }

    onCancel(): void {
       this.dialogRef.close();
    }

    public dateChanged() {
        console.log(this.data.startDate);
        this.data.endDate = this.data.startDate;
    }
}
