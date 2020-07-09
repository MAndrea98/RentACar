import {Renter} from './Renter';
import {EndUser} from './EndUser';
import {Vehicle} from './Vehicle';

export class Ad{
  id: number;
  renter: Renter;
  endUser: EndUser;
  vehicle: Vehicle;
  place: String;
  date: Date;
  validTru: Date;
  validFrom: Date;
  dateTo: Date;
  dateFrom: Date;
  mileageLimit: number;

  constructor() {
  }
}
