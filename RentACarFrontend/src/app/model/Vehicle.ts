import {VehicleImage} from "./VehicleImage";
import {Model} from "./Model";
import {GasType} from "./GasType";
import {VehicleClass} from "./VehicleClass";
import {PriceList} from "./PriceList";
import {Renter} from "./Renter";
import {Cart} from "./Cart";

export class Vehicle{

  id: number;
  images: Array<VehicleImage>;
  model: Model;
  gasType: GasType;
  gearBox: String;
  vehicleClass: VehicleClass;
  price: PriceList;
  mileage: number;
  proposedMileage: number;
  owner: Renter;
  cdw: boolean;
  childSeatsNo: number;
  requests: Array<Request>;
  carts: Array<Cart>;

  constructor() {
  }
}
