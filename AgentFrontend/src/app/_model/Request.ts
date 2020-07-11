import { EndUser } from './EndUser';
import { Ad } from './Ad';

export class Request{
  id: number;
  endUser: EndUser;
  ads: Array<Ad>;
  status: string;
  
  constructor() {
  }
}
