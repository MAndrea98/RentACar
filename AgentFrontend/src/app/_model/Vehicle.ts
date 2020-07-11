import {VehicleImage} from "./VehicleImage";
import {Model} from "./Model";
import {GasType} from "./GasType";
import {VehicleClass} from "./VehicleClass";
import {PriceList} from "./PriceList";
import {Renter} from "./Renter";
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
  priceList: Array<PriceList>;

  constructor() {
  }
}
