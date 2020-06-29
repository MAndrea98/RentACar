import { Vehicle } from './Vehicle';

export class PriceList{

  id: number;
  vehicle: Vehicle[];
  dateFrom: Date;
  dateTo: Date;
  pricePerMile: number;
  cdwPrice: number;
  prices: Map<String, number>;

  constructor() {
  }
}
