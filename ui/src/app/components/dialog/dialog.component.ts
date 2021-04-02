import { Component, Inject } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {CarModel} from '../../models/car.model';

@Component({
    selector: 'app-dialog',
    templateUrl: './dialog.component.html'
})
export class DialogComponent {
    constructor(public dialogRef: MatDialogRef<DialogComponent>, @Inject(MAT_DIALOG_DATA) public data: CarModel) {
    }
    onYesClick(): void {
      this.dialogRef.close(this.data);
    }
    onNoClick(): void {
      this.dialogRef.close();
    }
}
