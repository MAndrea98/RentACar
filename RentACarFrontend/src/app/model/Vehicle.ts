import {VehicleImage} from "./VehicleImage";
import {Model} from "./Model";
import {GasType} from "./GasType";
import {VehicleClass} from "./VehicleClass";
import {PriceList} from "./PriceList";
import {Renter} from "./Renter";
import {Cart} from "./Cart";
import { VehicleFree } from './VehicleFree';

export class Vehicle{

  id: number;
  images: Array<VehicleImage>;
  owner: Renter;
  model: Model;
  gasType: GasType;
  gearBox: String;
  vehicleClass: VehicleClass;
  mileage: number;
  proposedMileage: number;
  cdw: boolean;
  childSeatsNo: number;
  vehicleFree: Array<VehicleFree>;
  requests: Array<Request>;
  carts: Array<Cart>;
  priceList: Array<PriceList>;

  constructor() {
  }
}
