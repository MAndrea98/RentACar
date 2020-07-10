import {Renter} from './Renter'
import {Agent} from "./Agent";

export class Company{

  id: number;
  renter: Renter;
  name: String;
  address: String;
  agents: Array<Agent>;
  poslovniMaticniBroj: String;

  constructor() {
  }
}
