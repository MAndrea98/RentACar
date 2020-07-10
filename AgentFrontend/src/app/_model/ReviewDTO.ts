export class ReviewDTO{
  id:number;
  endUserUsername:String;
  renterUsername:String;
  stars:number;
  content:string;
  accepted:boolean;
  deleted:boolean;
  requestID: number;

  constructor() {
    this.id = 0;
    this.endUserUsername = "";
    this.renterUsername = "";
    this.stars = 0;
    this.content = "";
    this.accepted = false;
    this.deleted = false;
    this.requestID = 0;
  }
}
