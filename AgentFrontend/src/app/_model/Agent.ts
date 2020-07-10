import {Renter} from './Renter';
import {Company} from './Company';

export class Agent{

  id:number;
  renter: Renter;
  name: String;
  surname: String;
  address: String;
  phone: String;
  company: Company;

  constructor(){

  }
}
