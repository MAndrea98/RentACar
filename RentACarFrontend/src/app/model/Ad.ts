import {EndUser} from './EndUser';
import {Vehicle} from './Vehicle';
import { Cart } from './Cart';
import { Request } from './Request';

export class Ad{
  id: number;
  vehicle: Vehicle;
  place: String;
  date: Date;
  validTru: Date;
  validFrom: Date;
  dateTo: Date;
<<<<<<< HEAD
  favoriteFor: Array<EndUser>;
  requests: Array<Request>;
  carts: Array<Cart>
=======
  dateFrom: Date;
  mileageLimit: number;
>>>>>>> F_dodavanje_oglasa

  constructor() {
  }
}
