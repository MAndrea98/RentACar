export class PriceList{

  id: number;
  datesPrice: Map<Date, number>;
  discount: Map<Date, number>;
  pricePerMile: number;
  cdwPrice: number;

  constructor() {
  }
}
