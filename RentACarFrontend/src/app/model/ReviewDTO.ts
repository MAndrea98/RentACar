export class ReviewDTO{
  id:number;
  endUserUsername:string;
  renterUsername:string;
  stars:number;
  content:string;
  accepted:boolean;
  deleted:boolean;

  constructor() {
  }
}
