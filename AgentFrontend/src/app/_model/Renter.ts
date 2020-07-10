import {Vehicle} from "./Vehicle";
import {PriceList} from "./PriceList";
import {Ad} from "./Ad";
import {Review} from "./Review";

export class Renter{

  id: number;
  idUser: number;
  vehicles: Array<Vehicle>;
  priceList: PriceList;
  ads: Array<Ad>;
  orderes: Array<Request>
  reviews: Array<Review>

  constructor() {
  }
}
