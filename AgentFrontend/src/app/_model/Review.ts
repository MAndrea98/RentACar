import {EndUser} from "./EndUser";
import {Renter} from "./Renter";

export class Review{
  id: number;
  endUser: EndUser;
  renter: Renter;
  stars: number;
  content: String

  constructor(){

  }
}
