import {Renter} from './Renter'
import {Agent} from "./Agent";

export class Company{

  id: number;
  renter: Renter;
  nameC: String;
  address: String;
  agents: Array<Agent>;

  constructor() {
  }
}
