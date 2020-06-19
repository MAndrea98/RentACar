import {Renter} from './Renter';
import {EndUser} from './EndUser';
import {Vehicle} from './Vehicle';

export class Ad{
  id: number;
  renter: Renter;
  endUser: EndUser;
  vehicle: Vehicle;
  place: String;
  dated: Date;
  validTru: Date;
  validFrom: Date;
  dateTo: Date;
  free: Map<Date, boolean>;
  mileage: number;

  constructor() {
  }
}
