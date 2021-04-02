import { CarModel } from './car.model';
export class AddEditDialogDataModel extends CarModel {
    isEdit: boolean;
    constructor() {
        super();
        this.isEdit = false;
    }
}
