import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleClassTableComponent } from './vehicle-class-table.component';

describe('VehicleClassTableComponent', () => {
  let component: VehicleClassTableComponent;
  let fixture: ComponentFixture<VehicleClassTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleClassTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleClassTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
