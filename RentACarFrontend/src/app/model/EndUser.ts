import {Ad} from "./Ad";
import {Review} from "./Review";
import {Request} from "./Request";

export class EndUser{

  id: number;
  idUser: number;
  name: String;
  surname; String;
  address: String;
  phone: String;
  reviews: Array<Review>;
  favorites: Array<Ad>;
  requests: Array<Request>;

  constructor(){

  }

}
